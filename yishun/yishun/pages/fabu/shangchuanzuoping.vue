<template>
	<view class="quanju">
		<view class="shuoming">
			<textarea class="shuru" type="text" placeholder="输入作品描述" @blur="detailChange"></textarea>
		</view>
		<view class="shangchuan">
			<view class="jishu">
				<view class="miaoshu">
					图片上传
				</view>
				<view class="count">
					{{count}}/3
				</view>
			</view>
			<view class="tianjia">
				<view v-for="(item,index) in imgList" :key="index" @tap="ViewImage" :data-url="imgList[index]" style="margin-right: 20upx;">
					<image :src="imgList[index]" mode="aspectFill" style="width: 150upx;height: 150upx;"></image>
				</view>
				<view @tap="ChooseImage" v-if="imgList.length<3">
					<image src="../../static/icon/add.png" style="width: 150upx;height: 150upx;"></image>
				</view>
			</view>
		</view>
		<view class="xinxi">
			<view class="diqu">
				<view class="yaoqiu">
					拍摄时间
				</view>
				<picker class="xuanze" :range="years" @change="yearChange" mode="multiSelector">
					{{years[0][yearsIndex1]}}-{{years[1][yearsIndex2]}}-{{years[2][yearsIndex3]}}
				</picker>
				<view class="fuhao">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="diqu">
				<view class="yaoqiu">
					拍摄地点
				</view>
				<picker class="xuanze" :range="location" @change="locationChange">
				    <view>{{ location[locationIndex] }} </view>
				</picker>
				<view class="fuhao">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="diqu">
				<view class="yaoqiu">
					标签
				</view>
				<view class="xuanze">
				    <text @tap="biaoqianshow = true">{{biaoqianinfo || "请选择"}}</text>
				</view>
				<view class="fuhao">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
				<multiple-select
				    v-model="biaoqianshow"
				    :data="biaoqianlist"
				    :default-selected="biaoqiandefaultSelected"
				    @confirm="confirm"
				></multiple-select>
			</view>
		</view>
		<view class="anniu"@click="postzuoping">
			<button class="public" type="default">上传</button>
		</view>
	</view>
</template>

<script>
	import multipleSelect from '@/components/uni-segmented-control/multiple-select.vue'
	export default {
		data() {
			return {
				imgList:[],//string数组里放uri
				imgLists:[],
				img:{
					uri:"",
					name:"",
				},
				detail:"",
				count: 0,
				tableList:["+标签","人像","美食","前卫","风景"],
				tableIndex:0,
				years:[
					[2018, 2019, 2020],
					[10, 11, 12],
					[15, 16, 17],
				],
				yearsIndex1:0,
				yearsIndex2:0,
				yearsIndex3:0,
				location:["浙江工商大学","浙江大学","杭州电子科技大学","浙江理工大学"],
				locationIndex:0,
				biaoqianshow: false, //是否显示 - 双向绑定
				biaoqianinfo: "",
				biaoqianlist: [], //数据源
				biaoqiandefaultSelected: ["3", "5"], //默认选中项   
				zuopingDetailTransfer:{
					account:"1",
					explain:"1",
					taglist:"1",
					launchTime:"1",
					cameraArea:"1"
				}
			}
		},
		onShow() {
			setTimeout(() => {
			  this.biaoqianlist = [
			    {
			      label: "毕业照",
			      value: "1",
			    },
			    {
			      label: "证件照",
			      value: "2",
			    },
			    {
			      label: "美食",
			      value: "3",
			    },
			    {
			      label: "汉服",
			      value: "4",
			    },
			  ];
			}, 1000);
		},
		onLoad(e) {
			
		},
		methods: {

			async postzuoping(){
				console.log(this.imgList.length);
				for(var i=0;i<this.imgList.length;i++){
					this.img.name=i;
					this.img.uri = this.imgList[i];
					this.imgLists.push(this.img);
				};
				this.detailTransfer();
				uni.uploadFile({
				            url: 'http://192.168.199.165:8080/production/insertNewProduction', 
							fileType: "image",  
				            files: this.imgLists,
				            formData: this.zuopingDetailTransfer,
				            success: (uploadFileRes) => {
				                console.log(uploadFileRes.data);
				            }
				});
			},
			detailChange:function(e){
				console.log(e)
				this.detail = e.detail.value;
			},
			detailTransfer:function(e){
				console.log(e)
				this.zuopingDetailTransfer.account='1';
				this.zuopingDetailTransfer.explain=this.detail;
				this.zuopingDetailTransfer.launchTime=this.years[0][this.yearsIndex1]+'-'+this.years[1][this.yearsIndex2]+'-'+this.years[2][this.yearsIndex3];
				this.zuopingDetailTransfer.cameraArea=this.location[this.locationIndex];
				this.zuopingDetailTransfer.taglist=this.biaoqianinfo;
				console.log(this.zuopingDetailTransfer);
			},
			tableChange:function(e){
				console.log(e)
				this.tableIndex = e.detail.value;
			},
			yearChange:function(e){
				console.log(e)
				this.yearsIndex1 = e.detail.value[0];
				this.yearsIndex2 = e.detail.value[1];
				this.yearsIndex3 = e.detail.value[2];
			},
			locationChange:function(e){
				console.log(e)
				this.locationIndex = e.detail.value;
			},
			ChooseImage() {
					uni.chooseImage({
						count: 3, //默认9
						sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
						sourceType: ['album'], //从相册选择
						success: (res) => {
							if (this.imgList.length != 0) {
								this.imgList = this.imgList.concat(res.tempFilePaths)
							} else {
								this.imgList = res.tempFilePaths
							}
							this.count = this.imgList.length
						},
					});
			},
			ViewImage(e) {
				uni.previewImage({
					urls: this.imgList,
					current: e.currentTarget.dataset.url
				});
			},
			confirm(data) {
				  console.log(data);
				  this.biaoqianinfo = data.map((el) => el.label).join("  ");
			}
		},
		components: {
			multipleSelect
		}
	}
</script>

<style>
.quanju{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
.shuoming{
	display: flex;
	border: 1upx solid #E5E5E5;
	height: 200upx;
	width: 680upx;
	margin-top: 30upx;
	background-color: #FFFFFF
}
.shuru{
	margin-top: 20upx;
	margin-left: 30upx;
	width: 600upx;
}
.shangchuan{
	display: flex;
	flex-direction: column;
	border: 1upx solid #E5E5E5;
	height: 300upx;
	width: 680upx;
	margin-top: 30upx;
	background-color: #FFFFFF
}
.jishu{
	display: flex;
	flex-direction: row;
}
.miaoshu{
	margin-top: 20upx;
	margin-left: 30upx;
}
.count{
	margin-top: 20upx;
	position: absolute;
	right: 60upx;
}
.tianjia{
	margin-left: 30upx;
	margin-top: 30upx;
	display: flex;
	flex-direction: row;
}
.table{
	display: flex;
	align-items: center;
	justify-content: center;
	height: 60upx;
	width: 150upx;
	border-radius: 50upx;
	line-height: 60upx;
	font-size: 5upx;
	border: 1upx solid #4D3B7E;
	background-color: #FFFFFF;
}
.public{
	margin-top: 30upx;
	width: 680upx;
	background-color: #4D3B7E;
	color: #FFFFFF;
}
.xinxi{
	display: flex;
	flex-direction: column;
	border: 1upx solid #E5E5E5;
	margin-top: 30upx;
	height: 160upx;
	width: 680upx;
	background-color: #FFFFFF
}
.diqu{
	display: flex;
	flex-direction: row;
	height: 100upx;
	border: 1upx solid #E5E5E5;
	align-items: center;
	justify-content: space-between;
}
.fuhao{
	position: absolute;
	right: 60upx;
}
.yaoqiu{
	margin-left: 30upx;
}
.xuanze{
	margin-right: 110upx;
}
</style>
