<template>
	<view>
		<scroll-view scroll-y="true" style="height: 1070upx;">
			<view v-for="(item,index) in forcexinxi" :key="index">
				<view class="guanzhu">
					<view class="touxiang" @click="jumpgeren(index)">
						<image :src="forcexinxi[index].avatarUrl" mode="aspectFill" style="width: 100upx;height: 100upx;border-radius: 50%;"></image>
					</view>
					<view class="text" @click="jumpgeren(index)">
						{{forcexinxi[index].nickName}}
					</view>
					<view class="sex" v-if="forcexinxi[index].gender == 0">
						<image src="../../static/icon/man.png" style="width: 30upx;height: 30upx;"></image>
					</view>
					<view class="sex" v-if="forcexinxi[index].gender == 1">
						<image src="../../static/icon/woman.png" style="width: 30upx;height: 30upx;"></image>
					</view>
					<view class="btn">
						<button @click="quxiao(index)" class="quxiao" type="default">取消关注</button>
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
				forcexinxi:[],
			}
		},
		onLoad(e) {
			inf = e;
			this.initPage()
		},
		methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/user/getFocusList',
					data: {
						account:inf.account
					}
				})
				this.forcexinxi = res.data.data;
			},
			jumpgeren(e) {
				var that = this;
				var account = that.forcexinxi[e].account;
				uni.navigateTo({
				    url: '../gerenxinxi/gerenzhuye?account='+account,
				});
			},
			quxiao(e){
				const res = this.$myRequest({
					url: '/user/unfollowUser',
					data: {
						account:inf.account,
						focusAccount:this.forcexinxi[e].account
					}
				});
				setTimeout(function(){
					uni.redirectTo({
					    url: '../gerenxinxi/guanzhu?account='+inf.account,
					});
				},100)
			}
		}
	}
</script>

<style>
.guanzhu{
	display: flex;
	flex-direction: row;
	align-items: center;
	border: 1upx solid #E5E5E5;
	background-color: #FFFFFF;
	height: 150upx;
}
.touxiang{
	margin-left: 50upx;
	margin-right: 30upx;
}
.text{
	font-size: 36upx;
	margin-right: 30upx;
}
.btn{
	position: absolute;
	right: 30upx;
}
.quxiao{
	background-color: #FFFFFF
}
</style>
