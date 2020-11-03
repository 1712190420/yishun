<template>
	<view>
		<swiper class="swiper" indicator-dots="true" circular="ture" autoplay="true" interval="5000" duration="500"	>
			<swiper-item v-for="(item , index) in homeSlide" :key="index">
				<image :src="item" mode="aspectFill"></image>
			</swiper-item>
		</swiper>
		<view class="tianchong">
			<view>
				<view class="fenglei" @click="jumpliebiao(0)">
					<image class="pic" src="../../static/rengxiang.png" style="width: 300upx;height: 200upx;"></image>
					<view class="miaoshu">
						人像
					</view>
				</view>
				<view class="fenglei" @click="jumpliebiao(1)">
					<image class="pic" src="../../static/qianwei.png" style="width: 300upx;height: 200upx;"></image>
					<view class="miaoshu">
						前卫
					</view>
				</view>
			</view>
			<view>
				<view class="fenglei" @click="jumpliebiao(2)">
					<image class="pic" src="../../static/meishi.png" style="width: 300upx;height: 200upx;"></image>
					<view class="miaoshu">
						美食
					</view>
				</view>
				<view class="fenglei" @click="jumpliebiao(3)">
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
			this.initPage()
		},
		methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/production/getHotImg',
					data: {}
				})
				this.homeSlide = res.data.data;
			},
			jumpliebiao(e) {
				console.log(e)
				uni.navigateTo({
				    url: '../zuopin/zuopinxiangqing?tag='+e,
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
