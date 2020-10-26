<template>
	<view>
		<view>
			<swiper class="swiper" indicator-dots="true" circular="ture" autoplay="true" interval="5000" duration="500"	>
				<swiper-item v-for="(item , index) in homeSlide" :key="index">
					<image :src="item" mode="aspectFill"></image>
				</swiper-item>
			</swiper>
		</view>
		
		<view class="tianchong">
			<view>
				<view class="fenglei" @click="jumpliebiao">
					<image class="pic" src="../../static/rengxiang.png" style="width: 300upx;height: 200upx;"></image>
					<view class="miaoshu">
						人像
					</view>
				</view>
				<view class="fenglei" @click="jumpliebiao">
					<image class="pic" src="../../static/qianwei.png" style="width: 300upx;height: 200upx;"></image>
					<view class="miaoshu">
						前卫
					</view>
				</view>
			</view>
			<view>
				<view class="fenglei" @click="jumpliebiao">
					<image class="pic" src="../../static/meishi.png" style="width: 300upx;height: 200upx;"></image>
					<view class="miaoshu">
						美食
					</view>
				</view>
				<view class="fenglei" @click="jumpliebiao">
					<image class="pic" src="../../static/fengjin.png" style="width: 300upx;height: 200upx;"></image>
					<view class="miaoshu">
						风景
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				homeSlide:[]
			}
		},
		onLoad() {
			this.homeSlide=['https://app-file.beitaichufang.com/img/H5/web/banner/banner20.jpg',
			"https://app-file.beitaichufang.com/img/H5/web/banner/banner21.jpg",
			"https://app-file.beitaichufang.com/img/H5/web/banner/banner22.jpg",
			"https://app-file.beitaichufang.com/img/H5/web/banner/banner23.jpg"
			];
		},
		methods: {
			jumpliebiao(e) {
				uni.navigateTo({
				    url: '../zuopin/zuopinxiangqing',
				});
			},
		}
	}
</script>

<style>
.swiper{
	height: 400upx;
}
swiper-item image{
	width: 100%;
	height: 400upx;
}
.tianchong{
	display: flex;
	background-color: #FFFFFF;
	padding-bottom: 45upx;
}
.fenglei{
	display: flex;
	flex-direction: column;
	width: 300upx;
	height: 300upx;
	margin-top: 50upx;
	margin-left: 50upx;
}
.pic{
	margin-bottom: 15upx;
}
.miaoshu{
	display: flex;
	justify-content: center;
	align-items: center;
	border: 1upx solid #E5E5E5;
	height: 80upx;
	color: #4D3B7E;
}
</style>
