<template>
	<view class="quanju">
		<view class="ziliao">
			<view class="touxiang">
				<view class="miaoshu">
					头像
				</view>
				<view class="tupian">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
				<view class="qianjin">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang">
				<view class="miaoshu">
					昵称
				</view>
				<view class="tupian">
					TL
				</view>
				<view class="qianjin">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang">
				<view class="miaoshu">
					性别
				</view>
				<picker class="tupian" :range="sex" @change="sexChange">
					{{ sex[sexIndex] }} 
				</picker>
				<view class="qianjin">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang">
				<view class="miaoshu">
					生日
				</view>
				<picker class="tupian" :range="years" @change="yearChange" mode="multiSelector">
					{{years[0][yearsIndex1]}}-{{years[1][yearsIndex2]}}-{{years[2][yearsIndex3]}}
				</picker>
				<view class="qianjin">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang" @click="addressShow = true">
				<view class="content_list">
					<view class="miaoshu">地区</view>
					<view class="tupian">
					    {{address}}
						<pickerAddress v-model="addressShow" @confirm="addresspick" />
					</view>
					<view class="qianjin">
						<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
					</view>
				</view>
			</view>
			<view class="touxiang">
				<view class="miaoshu">
					身份
				</view>
				<picker class="tupian" :range="people" @change="peopleChange">
					{{ people[peopleIndex] }} 
				</picker>
				<view class="qianjin">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang">
				<view class="miaoshu">
					年龄/身高/体重
				</view>
				<view class="tupian">
					21/182/120
				</view>
				<view class="qianjin">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang">
				<view class="miaoshu">
					兴趣爱好
				</view>
				<view class="tupian">
					选填
				</view>
				<view class="qianjin">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang">
				<view class="miaoshu">
					手机号
				</view>
				<view class="tupian">
					选填
				</view>
				<view class="qianjin">
					<image src="../../static/icon/fenlei.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
		</view>
		<view class="tijiao">
			<button class="xiugai" type="default">修改</button>
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
				sex:["男","女"],
				sexIndex:0,
				years:[
					[2018, 2019, 2020],
					[10, 11, 12],
					[15, 16, 17],
				],
				yearsIndex1:0,
				yearsIndex2:0,
				yearsIndex3:0,
				people:["摄影师","摄影爱好者","摄影工作室"],
				peopleIndex:0,
				
				
			}
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
			sexChange:function(e){
				console.log(e)
				this.sexIndex = e.detail.value;
			},
			yearChange:function(e){
				console.log(e)
				this.yearsIndex1 = e.detail.value[0];
				this.yearsIndex2 = e.detail.value[1];
				this.yearsIndex3 = e.detail.value[2];
			},
			peopleChange:function(e){
				console.log(e)
				this.peopleIndex = e.detail.value;
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
.ziliao{
	display: flex;
	flex-direction: column;
	border: 1upx solid #E5E5E5;
	width: 680upx;
	margin-top: 30upx;
	background-color: #fff;
}
.touxiang{
	display: flex;
	flex-direction: row;
	border: 1upx solid #E5E5E5;
	height: 100upx;
	align-items: center;
}
.miaoshu{
	margin-left: 30upx;
}
.tupian{
	position: absolute;
	right: 160upx;
}
.qianjin{
	position: absolute;
	right: 80upx;
}
.tijiao{
	margin-top: 30upx;
}
.xiugai{
	background-color: #007AFF;
	width: 680upx;
}
</style>
