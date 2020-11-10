<template>
	<view>
		<view class="yuepai">
			<view class="gerenxinxi" @click="jumpzhuye">
				<view class="touxiang">
					<image :src="information.avatarUrl" style="width: 150upx;height: 150upx;border-radius: 50%;"></image>
				</view>
				<view class="xinxi">
					<view class="geren">
						<view class="name">
							{{information.nickName}}
						</view>
						<view class="sex" v-if="information.gender == 0">
							<image src="../../static/icon/man.png" style="width: 30upx;height: 30upx;"></image>
						</view>
						<view class="sex" v-if="information.gender == 1">
							<image src="../../static/icon/woman.png" style="width: 30upx;height: 30upx;"></image>
						</view>
					</view>	
					<view class="time">
						{{information.launchTime}}
					</view>
				</view>
			</view>
			
			<view class="jianjie">
				<view class="text">
					{{price[information.price]}}
				</view>
				<view class="paishe">
					拍摄时间：{{information.cameraTime}}
				</view>
			</view>
			<view class="text">
				{{information.explain}}
			</view>
			<view>
				<view class="picture">
					<view v-for="(item,index) in information.imgList" :key="index">
						<image :src="item" style="width: 650upx;height: 450upx;"></image>
					</view>	
				</view>
			</view>
			<view class="tableList">
				<view v-for="(item,index) in information.tagList" :key="index">
					<button class="table">{{tableList[item]}}</button>
				</view>	
			</view>
			<view class="location">
				<view>
					<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
				</view>
				<view class="dizhi">
					{{information.cameraArea}}
				</view>
				<view class="shoudao">
					收到约拍{{information.getInvite}}
				</view>
				<view class="yuedu">
					阅读{{information.readNumber}}
				</view>
			</view>	
			<view class="yaoqing">
				<view class="kefu tubiao">
					<image src="../../static/icon/kefu.png" style="width: 50upx;height: 50upx;"></image>
					<view class="test">
						客服
					</view>
				</view>
				<view class="souchang tubiao">
					<image src="../../static/icon/shoucang.png" style="width: 50upx;height: 50upx;"></image>
					<view class="test">
						收藏
					</view>
				</view>
				<view class="fengxiang tubiao">
					<image src="../../static/icon/fenxiang.png" style="width: 50upx;height: 50upx;"></image>
					<view class="test">
						分享
					</view>
				</view>
				<view class="faqiyaoqing" @click="faqiyaoqing">
					<button @click="fachu" class="faqi">{{yaoqing}}</button>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	var yuepai;
	export default {
		data() {
			return {
				yaoqing:"发起邀请",
				information:[],
				tableList:["风景照","前卫照","人像照","美食照"],
				price:["希望互免","需要收费","愿意付费","费用协商"],
			}
		},
		onLoad(e) {
			yuepai = e;
			this.initPage()
		},
		methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/appointment/getAppointmentById',
					data: {
						id:yuepai.id
					}
				})
				this.information = res.data.data;
			},
			fachu(e){
				const res = this.$myRequest({
					url: '/appointment/insertInvite',
					data: {
						inviteAccount:1,
						invitedAccount:this.information.account,
						appointmentId:yuepai.id
					}
				})
			},
			jumpzhuye(e) {
				var that = this;
				var account = that.information.account;
				uni.navigateTo({
				    url: '../gerenxinxi/gerenzhuye?account='+account,
				});
			},
			faqiyaoqing(e){
				this.yaoqing = "已邀请"
			}
		}
	}
</script>

<style>
.yuepai{
	display: flex;
	flex-direction: column;
	background-color: #FFFFFF
}
.gerenxinxi{
	display: flex;
	flex-direction: row;
	height: 200upx;
}
.touxiang{
	display: flex;
	align-items: center;
	margin-left: 50upx;
}
.xinxi{
	display: flex;
	flex-direction: column;
	justify-content: center;
	margin-left: 50upx;
}
.name{
	font-size: 36upx;
	line-height: 30upx;
}
.geren{
	display: flex;
	flex-direction: row;
	margin-bottom: 10upx;
}
.sex{
	margin-left: 30upx;
}
.text{
	margin-top: 30upx;
	margin-left: 50upx;
}
.picture{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-bottom: 30upx;
	margin-top: 30upx;
}
.tableList{
	margin-left: 50upx;
}
.table{
	height: 50upx;
	width: 150upx;
	border-radius: 50upx;
	line-height: 50upx;
	float:left;
	margin-right: 10upx;
	font-size: 28upx;
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
.yaoqing{
	display: flex;
	flex-direction: row;
	border: 1upx solid #E5E5E5;
	height: 150upx;
	margin-top: 30upx;
	align-items: center;
}
.tubiao{
	margin-left: 60upx;
}
.test{
	font-size: 28upx;
}
.faqiyaoqing{
	display: flex;
	align-items: center;
}
.faqi{
	position: absolute;
	right: 30upx;
	width: 300upx;
	background-color: #4D3B7E;
	color: #FFFFFF;
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
