<template>
	<view>
		<scroll-view scroll-y="true" style="height: 1250upx;">
			<view v-for="(item,index) in information" :key="index">
				<view class="yuepai">
					<view class="picture">
						<image :src="information[index].img" style="width: 400upx;height: 300upx;"></image>
					</view>
					<view class="text">
						{{information[index].explain}}
					</view>
					<view class="location">
						<view class="mincheng">
							被邀请人:{{information[index].invitedPeople}}
						</view>
						<view class="didian">
							<view>
								<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
							</view>
							<view class="dizhi">
								{{information[index].cameraArea}}
							</view>
						</view>
						<view class="shijian">
							{{information[index].cameraTime}}
						</view>
					</view>	
					<view class="anniu">
						<button @click="deleteInvite(index)" class="yaoqing" type="default">撤销邀请</button>
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
			}
		},
		onLoad(e) {
			inf = e;
			this.initPage()
		},
		methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/appointment/selectAppoByCondition2',
					data: {
						inviteAccount:inf.inviteAccount,
						status:0
					}
				})
				this.information = res.data.data;
			},
			deleteInvite(e) {
				console.log(this.information[e].appointmentId);
				console.log(this.information[e].inviteAccount);
				const res = this.$myRequest({
					url: '/appointment/deleteInvite',
					data: {
						id:this.information[e].appointmentId,
						account:this.information[e].inviteAccount
					}
				});
				setTimeout(function(){
					uni.redirectTo({
					    url: '../yaoqing/fachu?inviteAccount=1',
					});
				},100)
			},
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
.yaoqing{
	color: #4D3B7E;
	border: 1upx solid #4D3B7E;
	height: 60upx;
	width: 220upx;
	line-height: 60upx;
	font-size: 16px;
	background-color: #fff;
	display: flex;
	justify-content: center;
}
.guanzhu{
	margin-right: 140upx;
}
</style>
