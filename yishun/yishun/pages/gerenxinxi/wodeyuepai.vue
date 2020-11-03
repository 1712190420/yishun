<template>
	<view>
		<scroll-view scroll-y="true" style="height: 1240upx;">
			<view v-for="(item,index) in information" :key="index">
				<view class="yuepai">
					<view class="text">
						{{price[information[index].price]}}
					</view>
					<view class="text">
						{{information[index].explain}}
					</view>
					<view>
						<view class="picture">
							<image :src="information[index].imgList[0]" style="width: 650upx;height: 450upx;"></image>
						</view>
					</view>
					<view class="tableList">
						<view v-for="(item,index) in information[index].tagList" :key="index">
							<button class="table">{{tableList[item]}}</button>
						</view>	
					</view>	
					<view class="location">
						<view>
							<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
						</view>
						<view class="dizhi">
							{{information[index].cameraArea}}
						</view>
						<view class="shoudao">
							收到约拍{{information[index].getInvite}}
						</view>
						<view class="yuedu">
							阅读{{information[index].readNumber}}
						</view>
					</view>
				</view>
			</view>
		</scroll-view>
	</view>
</template>

<script>
	var inf;
	export default {
		data() {
			return {
				information:[],
				price:["希望互免","需要收费","愿意付费","费用协商"],
				tableList:["风景照","前卫照","人像照","美食照"],
			}
		},
		onLoad(e) {
			inf = e;
			this.initPage()
		},
		methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/appointment/getAppointmentByAccount',
					data: {
						account:inf.account
					}
				})
				this.information = res.data.data;
			},
		}
	}
</script>

<style>
.yuepai{
	display: flex;
	flex-direction: column;
	border: 1upx solid #E5E5E5;
	padding-bottom: 30upx;
	margin-bottom: 30upx;
	background-color: #FFFFFF
}
.text{
	margin-top: 30upx;
	margin-left: 50upx;
}
.picture{
	display: flex;
	justify-content: center;
	align-items: center;
	margin-bottom: 30upx;
	margin-top: 30upx;
}
.tableList{
	display: flex;
	flex-direction: row;
	margin-left: 50upx;
}
.table{
	display: flex;
	height: 50upx;
	width: 135upx;
	border-radius: 50upx;
	line-height: 50upx;
	float:left;
	margin-right: 10upx;
	font-size: 8upx;
	border: 1upx solid #4D3B7E;
	background-color: #FFFFFF;
}
.location{
	display: flex;
	flex-direction: row;
	margin-top: 30upx;
	margin-left: 50upx;
}
.shoudao{
	position: absolute;
	right: 150upx;
}
.yuedu{
	position: absolute;
	right: 30upx;
}
.jianjie{
	display: flex;
	flex-direction: row;
}
.paishe{
	margin-top: 30upx;
	position: absolute;
	right: 50upx;
}
</style>
