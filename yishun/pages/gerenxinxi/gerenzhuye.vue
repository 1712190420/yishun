<template>
	<view>
		<view class="touxiang">
			<image src="../../static/2.png" style="width: 150upx;height: 150upx;border-radius: 50%;"></image>
		</view>
		<view class="xinmin">
			TL
		</view>
		<view class="gerenxinxi">
			<view class="sex">男</view>
			<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;border-radius: 50%;"></image>
			<view class="dizhi">杭州市江干区</view>
			<view class="age">22岁</view>
		</view>
		<view class="renshu">
			<view class="yuepai">约拍0</view>
			<view class="guanzhu">关注0</view>
			<view class="fensi">粉丝0</view>
		</view>
		<uni-segmented-control :current="current" :values="items" @clickItem="onClickItem" style-type="button" radius="100%" width="80%" active-color="#4D3B7E" style="background-color: #FFFFFF;" ></uni-segmented-control>
		<view class="content">
		    <view v-show="current === 0">
				<scroll-view scroll-y="true">
					<view class="yanse" @click="jumpxiangqing">
						<view class="text">
							希望互免
						</view>
						<view class="text">
							我很喜欢
						</view>
						<view>
							<view class="picture">
								<image src="../../static/2.png" style="width: 400upx;height: 300upx;"></image>
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
					
					<view class="yanse">
						<view class="text">
							希望互免
						</view>
						<view class="text">
							我很喜欢
						</view>
						<view>
							<view class="picture">
								<image src="../../static/2.png" style="width: 400upx;height: 300upx;"></image>
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
		    <view v-show="current === 1">
				<scroll-view scroll-y="true" style="height: 1000upx;">
					<view class="zuopinji">
						<view>
							<view class="picture">
								<image src="../../static/2.png" style="width: 400upx;height: 300upx;"></image>
							</view>
						</view>
						<view class="zuopinjianshu">
							作品简述
						</view>
						<view class="zuopinlocation">
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
							<button class="anniuyangshi yaoqing" type="default"><image src="../../static/icon/yaoqing.png" style="width: 30upx;height: 30upx;align-items: center;color: #007AFF;"></image>邀请约拍</button>
							<button class="anniuyangshi guanzhuyonghu" type="default">+关注</button>
						</view>
					</view>
				</scroll-view>
		    </view>
		</view>
	</view>
</template>

<script>
	import uniSegmentedControl from "@/components/uni-segmented-control/uni-segmented-control.vue"
	export default {
	    components: {uniSegmentedControl},
	    data() {
	        return {
	            items: ['约拍动态','个人作品集'],
	            current: 0
	        }
	    },
	    methods: {
	        onClickItem(e) {
	            if (this.current !== e.currentIndex) {
	                this.current = e.currentIndex;
	            }
	        },
			jumpxiangqing(e) {
				uni.navigateTo({
				    url: '../yuepai/xiangqing',
				});
			},
	    }
	}
</script>

<style>
.touxiang{
	display: flex;
	justify-content: center;
	align-items: center;
	height: 250upx;
	background-color: #4D3B7E;
}
.xinmin{
	display: flex;
	justify-content: center;
	align-items: center;
	padding-bottom: 30upx;
	background-color: #4D3B7E;
	color: #FFFFFF;
}
.gerenxinxi{
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	padding-top: 30upx;
	padding-bottom: 30upx;
	background-color: #FFFFFF;
}
.sex{
	margin-right: 40upx;
}
.age{
	margin-left: 40upx;
}
.renshu{
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	padding-bottom: 30upx;
	background-color: #FFFFFF;
}
.guanzhu{
	margin-left: 150upx;
	margin-right: 150upx;
}
.text{
	padding-top: 30upx;
	margin-left: 50upx;
}
.picture{
	display: flex;
	justify-content: center;
	align-items: center;
	padding-bottom: 30upx;
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
	margin-top: 30upx;
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
.yanse{
	display: flex;
	flex-direction: column;
	background-color: #FFFFFF;
	padding-bottom: 30upx;
	margin-bottom: 30upx;
}
.zuopinji{
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
.zuopinlocation{
	display: flex;
	flex-direction: row;
	margin-top: 30upx;
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
	color: #4D3B7E;
	border: 1upx solid #4D3B7E;
	height: 60upx;
	width: 220upx;
	line-height: 60upx;
	font-size: 16px;
	background-color: #fff;
}
.yaoqing{
	margin-left: 140upx;
}
.guanzhuyonghu{
	margin-right: 140upx;
}
.zuopinjianshu{
	display: flex;
	justify-content: center;
}
</style>
