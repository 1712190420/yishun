<template>
	<view>
		<view class="yaoqing">
			<image class="tupian" src="../../static/icon/man.png" style="width: 30upx;height: 30upx;"></image>
			<view class="yangshi">收到的约拍邀请</view>
		</view>
		<view class="yaoqing">
			<image class="tupian" src="../../static/icon/man.png" style="width: 30upx;height: 30upx;"></image>
			<view class="yangshi">发出的约拍邀请</view>
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
			
		}
	}
</script>

<style>
.yaoqing{
	display: flex;
	flex-direction: row;
	align-items: center;
	height: 100upx;
	border-style: solid;
	border-width: 3upx;
	border-color: #E5E5E5;
}
.tupian{
	margin-left: 50upx;
}
.yangshi{
	margin-left: 20upx;
}
</style>
