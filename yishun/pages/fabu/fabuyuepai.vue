<template>
	<view class="quanju">
		<view class="shuoming">
			<textarea class="shuru" type="text" placeholder="输入约拍说明"></textarea>
		</view>
		<view class="shangchuan">
			<view class="jishu">
				<view class="miaoshu">
					图片上传
				</view>
				<view class="count">
					0/3
				</view>
			</view>
			<view class="tianjia">
				<image src="../../static/icon/fenlei.png" style="width: 150upx;height: 150upx;"></image>
			</view>
		</view>
		<view class="xinxi">
			<view class="diqu" @click="addressShow = true">
				<view class="content_list">
				    <view class="content_list_label">地区</view>
				    <view class="content_list_content">
				        {{address}}
						<pickerAddress v-model="addressShow" @confirm="addresspick" />
				    </view>
					<view class="fuhao">
						<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
					</view>
				</view>
			</view>
			<view class="diqu">
				<view class="yaoqiu">
					要求
				</view>
				<picker class="xuanze" :range="years" @change="yearChange">
					{{ years[yearsIndex] }} 
				</picker>
				<view class="fuhao">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="diqu">
				<view class="yaoqiu">
					费用
				</view>
				<picker class="xuanze" :range="free" @change="freeChange">
				    <view>{{ free[freetext] }} </view>
				</picker>
				<view class="fuhao">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
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
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
		</view>
		<view class="biaoqian">
			<view class="addbiaoqian">
				<button class="table" type="default">+标签</button>
			</view>
		</view>
		<view class="anniu">
			<button class="public" type="default">发布</button>
		</view>
	</view>
</template>

<script>
	import pickerAddress from '@/components/liudx-pickerAddress/index.vue'
	    export default {
	        data() {
	            return {
	                addressShow: false,
	                form: {
	                    province: '',
	                    city: '',
	                    area: '',
	                },
	                address: '',
					years:["所有人","关注的人"],
					yearsIndex:0,
					free:["希望互免","需要收费","愿意付费","费用协商"],
					freetext:0,
					location:["浙江工商大学","浙江大学","杭州电子科技大学","浙江理工大学"],
					locationIndex:0,
	            }
	        },
	        onLoad() {
	
	        },
	        methods: {
	            addresspick(obj) {
	                let arr = [ 'province', 'city', 'area'];
	                let place = '';
	                arr.map(key => {
	                    this.form[key] = obj[key].AreaId
	                    place += obj[key].AreaName
	                })
	                this.address = place
	            },
				yearChange:function(e){
					console.log(e)
					this.yearsIndex = e.detail.value;
				},
				freeChange:function(e){
					console.log(e)
					this.freetext = e.detail.value;
				},
	        },
	        components: {
	            pickerAddress
	        }
	    }
</script>

<style lang="scss" scoped>
    .content {
        &_list{
            display: flex;
            justify-content:space-around;
            &_content{
                flex: 1;
                width: auto;
                text-align: right;
            }
        }
    }
</style>

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
}
.xinxi{
	display: flex;
	flex-direction: column;
	border: 1upx solid #E5E5E5;
	margin-top: 30upx;
	height: 300upx;
	width: 680upx;
}
.diqu{
	display: flex;
	flex-direction: row;
	height: 100upx;
	border: 1upx solid #E5E5E5;
	align-items: center;
	justify-content: space-between;
}
.content_list_label{
	margin-left: 30upx;
}
.content_list_content{
	position: absolute;
	right: 150upx;
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
.biaoqian{
	display: flex;
	border: 1upx solid #E5E5E5;
	height: 100upx;
	width: 680upx;
}
.addbiaoqian{
	display: flex;
	align-items: center;
	margin-left: 30upx;
}
.table{
	height: 80upx;
	width: 180upx;
	border-radius: 50upx;
	line-height: 80upx;
	float:left;
	margin-left: 30upx;
}
.public{
	margin-top: 30upx;
	width: 680upx;
	background-color: #007AFF;
}
</style>
