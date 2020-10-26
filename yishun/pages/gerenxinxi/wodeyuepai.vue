<template>
	<view>
		<scroll-view scroll-y="true" style="height: 1240upx;">
			<view class="yuepai">
				<view class="text">
					希望互免
				</view>
				<view class="text">
					作品简述
				</view>
				<view>
					<view class="picture">
						<image src="../../static/2.png" style="width: 650upx;height: 450upx;"></image>
					</view>
				</view>
				<view class="tableList">
					<button class="table">#毕业照</button>
				</view>	
				<view class="location">
					<view>
						<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
					</view>
					<view class="dizhi">
						来自浙江工商大学
					</view>
					<view class="shoudao">
						收到约拍0
					</view>
					<view class="yuedu">
						阅读0
					</view>
				</view>
			</view>
			<view class="yuepai">
				<view class="jianjie">
					<view class="text">
						希望互免
					</view>
					<view class="paishe">
						拍摄时间：2020/10/14 10:28
					</view>
				</view>
				<view class="text">
					作品简述
				</view>
				<view>
					<view class="picture">
						<image src="../../static/2.png" style="width: 650upx;height: 450upx;"></image>
					</view>
				</view>
				<view class="tableList">
					<button class="table">#毕业照</button>
				</view>	
				<view class="location">
					<view>
						<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
					</view>
					<view class="dizhi">
						来自浙江工商大学
					</view>
					<view class="shoudao">
						收到约拍0
					</view>
					<view class="yuedu">
						阅读0
					</view>
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
	margin-bottom: 50upx;
	margin-top: 30upx;
}
.tableList{
}
.table{
	height: 50upx;
	width: 150upx;
	border-radius: 50upx;
	line-height: 50upx;
	float:left;
	margin-left: 50upx;
	font-size: 8upx;
	border: 1upx solid #4D3B7E;
	background-color: #FFFFFF;
}
.location{
	display: flex;
	flex-direction: row;
	margin-top: 50upx;
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
