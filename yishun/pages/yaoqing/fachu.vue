<template>
	<view>
		<scroll-view scroll-y="true" style="height: 1000upx;">
			<view class="yuepai">
				<view>
					<view class="picture">
						<image src="../../static/2.png" style="width: 400upx;height: 300upx;"></image>
					</view>
				</view>
				<view class="text">
					作品简述
				</view>
				<view class="location">
					<view class="mincheng">
						邀请人:TL
					</view>
					<view class="didian">
						<view>
							<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
						</view>
						<view class="dizhi">
							浙江工商大学
						</view>
					</view>
					<view class="shijian">
						2020/10/21 14:30
					</view>
				</view>	
				<view class="anniu">
					<button class="yaoqing" type="default">撤销邀请</button>
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
