<template>
	<view>
		<view class="yaoqing" @click="jumpshoudao">
			<image class="tupian" src="../../static/icon/tixin.png" style="width: 30upx;height: 30upx;"></image>
			<view class="yangshi">收到的约拍邀请</view>
		</view>
		<view class="yaoqing" @click="jumpfachu">
			<image class="tupian" src="../../static/icon/fachu.png" style="width: 30upx;height: 30upx;"></image>
			<view class="yangshi">发出的约拍邀请</view>
		</view>
		<view class="yaoqing" @click="jumpjieshou">
			<image class="tupian" src="../../static/icon/jieshou.png" style="width: 30upx;height: 30upx;"></image>
			<view class="yangshi">接受的约拍邀请</view>
		</view>
		<view class="yaoqing" @click="jumpjujue">
			<image class="tupian" src="../../static/icon/jujue.png" style="width: 30upx;height: 30upx;"></image>
			<view class="yangshi">拒绝的约拍邀请</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			jumpshoudao(e) {
				uni.navigateTo({
				    url: '../yaoqing/shoudao?inviteAccount=1',
				});
			},
			jumpfachu(e) {
				uni.navigateTo({
				    url: '../yaoqing/fachu?inviteAccount=1',
				});
			},
			jumpjieshou(e) {
				uni.navigateTo({
				    url: '../yaoqing/jieshou?inviteAccount=1',
				});
			},
			jumpjujue(e) {
				uni.navigateTo({
				    url: '../yaoqing/jujue?inviteAccount=1',
				});
			},
		}
	}
</script>

<style>
.yaoqing{
	display: flex;
	flex-direction: row;
	align-items: center;
	height: 100upx;
	border: 1upx solid #E5E5E5;
	background-color: #FFFFFF
}
.tupian{
	margin-left: 50upx;
}
.yangshi{
	margin-left: 20upx;
}
</style>
