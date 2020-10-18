<template>
	<view>
		<scroll-view scroll-y="true" style="height: 1000upx;">
			<view class="yuepai">
				<view>
					<view class="picture">
						<image src="../../static/2.png" style="width: 400upx;height: 300upx;"></image>
					</view>
				</view>
				<view class="location">
					<view class="mincheng">
						摄影师:TL
					</view>
					<view class="didian">
						<view>
							<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
						</view>
						<view class="dizhi">
							浙江工商大学
						</view>
					</view>
				</view>	
				<view class="anniu">
					<button class="anniuyangshi yaoqing" type="default"><image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;align-items: center;"></image>邀请约拍</button>
					<button class="anniuyangshi guanzhu" type="default">+关注</button>
				</view>
			</view>
		</scroll-view>
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
.location{
	display: flex;
	flex-direction: row;
	margin-top: 50upx;
	margin-left: 150upx;
}
.didian{
	display: flex;
	flex-direction: row;
	position: absolute;
	right: 150upx;
}
.anniu{
	display: flex;
	flex-direction: row;
	margin-top: 30upx;
	justify-content: center;
	align-items: center;
}
.anniuyangshi{
	color: #007AFF;
	border: 1upx solid #007AFF;
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
</style>
