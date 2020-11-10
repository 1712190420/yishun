<template>
	<view>
		<view v-if="status.status == 200">
			<scroll-view scroll-y="true" style="height: 1600upx;">
				<view v-for="(item,index) in zuoping" :key="index">
					<view class="yuepai">
						<view class="picture">
							<view v-for="(item,index) in zuoping[index].imglist" :key="index">
								<image :src="item" style="width: 400upx;height: 300upx;"></image>
							</view>	
						</view>
						<view class="text">
							{{zuoping[index].explain}}
						</view>
						<view class="location">
							<view class="mincheng">
								作者:{{zuoping[index].nickName}}
							</view>
							<view class="didian">
								<view>
									<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
								</view>
								<view class="dizhi">
									{{zuoping[index].cameraArea}}
								</view>
							</view>
							<view class="shijian">
								{{zuoping[index].launchTime}}
							</view>
						</view>	
						<view class="anniu">
							<button @click="yaoqing(index)" class="anniuyangshi yaoqing" type="default"><image src="../../static/icon/yaoqing.png" style="width: 30upx;height: 30upx;align-items: center;color: #007AFF;"></image>邀请</button>
							<button @click="guanzhu" class="anniuyangshi guanzhu" type="default">添加关注</button>
						</view>
					</view>
				</view>
				
			</scroll-view>
		</view>
		<view v-if="status.status == 500">
			<view class="none">
				<image src="../../static/none.jpg" mode=""></image>
			</view>
		</view>
	</view>
</template>

<script>
	var zuopingtag;
	export default {
		data() {
			return {
				zuoping:[],
				status:[],
			}
		},
		onLoad(e) {
			zuopingtag = e;
			this.initPage()
		},
		methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/production/getProduction',
					data: {
						tag:zuopingtag.tag
					}
				})
				this.status = res.data;
				this.zuoping = res.data.data;
			},
			yaoqing(e){
				const res = this.$myRequest({
					url: '/appointment/insertInvite',
					data: {
						inviteAccount:1,
						invitedAccount:1,
						appointmentId:this.zuoping[e].id
					}
				})
			},
			guanzhu(e){
				const res = this.$myRequest({
					url: '/user/followUser',
					data: {
						account:1,
						focusAccount:1,
					}
				});
			}
		}
	}
</script>

<style>
.yuepai{
	display: flex;
	flex-direction: column;
	border: 1upx solid #E5E5E5;
	margin-top: 30upx;
	padding-top: 30upx;
	padding-bottom: 30upx;
	background-color: #fff;
}
.picture{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
.text{
	display: flex;
	justify-content: center;
	margin-top: 30upx;
}
.location{
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	margin-top: 30upx;
}
.didian{
	display: flex;
	flex-direction: row;
	margin-left: 50upx;
	margin-right: 50upx;
}
.anniu{
	display: flex;
	flex-direction: row;
	margin-top: 30upx;
	justify-content: center;
	align-items: center;
}
.anniuyangshi{
	color: #4D3B7E;
	border: 1upx solid #4D3B7E;
	height: 60upx;
	width: 220upx;
	line-height: 60upx;
	font-size: 16px;
	background-color: #fff;
}
.yaoqing{
	margin-left: 140upx;
}
.guanzhu{
	margin-right: 140upx;
}
.none{
	background-color: #FFFFFF;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 32upx;
	height: 1240upx;
}
</style>
