<template>
	<view>
		<view @click="jumpfabuyuepai">
			<image src="../../static/camera.jpg" style="width: 750upx;height: 350upx;"></image>
		</view>
		<view @click="jumpshangchuan">
			<image src="../../static/work.jpg" style="width: 750upx;height: 350upx;"></image>
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
			jumpfabuyuepai(e) {
				uni.navigateTo({
				    url: '../fabu/fabuyuepai',
				});
			},
			jumpshangchuan(e) {
				uni.navigateTo({
				    url: '../fabu/shangchuanzuoping',
				});
			},
		}
	}
</script>

<style>

</style>
