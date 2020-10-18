<template>
	<view>
		<uni-segmented-control :current="current" :values="items" @clickItem="onClickItem" style-type="button" radius="100%" width="80%" active-color="#00F"  ></uni-segmented-control>
		<view class="content">
		    <view v-show="current === 0">
				<scroll-view scroll-y="true" style="height: 1000upx;">
					<view class="yuepai">
						<view class="gerenxinxi" >
							<view class="touxiang">
								<image src="../../static/icon/man.png" style="width: 150upx;height: 150upx;border-radius: 50%;"></image>
							</view>
							<view class="xinxi">
								<view class="geren">
									<view class="name">
										TL
									</view>
									<view class="sex">
										<image src="../../static/icon/man.png" style="width: 30upx;height: 30upx;"></image>
									</view>
								</view>	
								<view class="time">
									2020/10/10 10:28
								</view>
							</view>
						</view>
						
						<view class="text">
							希望互免
						</view>
						<view>
							<view class="picture">
								<image src="../../static/1.png" style="width: 400upx;height: 300upx;"></image>
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
					<view class="yuepai">
						<view class="gerenxinxi" >
							<view class="touxiang">
								<image src="../../static/icon/man.png" style="width: 150upx;height: 150upx;border-radius: 50%;"></image>
							</view>
							<view class="xinxi">
								<view class="geren">
									<view class="name">
										WTL
									</view>
									<view class="sex">
										<image src="../../static/icon/woman.png" style="width: 30upx;height: 30upx;"></image>
									</view>
								</view>	
								<view class="time">
									2020/10/14 10:28
								</view>
							</view>
						</view>
						
						<view class="text">
							希望互免
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
		</view>
	</view>
</template>

<script>
	import uniSegmentedControl from "@/components/uni-segmented-control/uni-segmented-control.vue"
	export default {
	    components: {uniSegmentedControl},
	    data() {
	        return {
	            items: ['热门','关注'],
	            current: 0
	        }
	    },
	    methods: {
	        onClickItem(e) {
	            if (this.current !== e.currentIndex) {
	                this.current = e.currentIndex;
	            }
	        }
	    }
	}
</script>

<style>
.yuepai{
	display: flex;
	flex-direction: column;
}
.gerenxinxi{
	display: flex;
	flex-direction: row;
	height: 200upx;
	border: 1upx solid #E5E5E5;
}
.touxiang{
	display: flex;
	align-items: center;
	margin-left: 50upx;
}
.xinxi{
	display: flex;
	flex-direction: column;
	justify-content: center;
	margin-left: 50upx;
}
.geren{
	display: flex;
	flex-direction: row;
}
.sex{
	margin-left: 30upx;
}
.text{
	margin-top: 50upx;
	margin-left: 50upx;
}
.picture{
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 30upx;
	margin-bottom: 30upx;
}
.tableList{
}
.table{
	height: 50upx;
	width: 200upx;
	border-radius: 50upx;
	line-height: 50upx;
	float:left;
	margin-left: 50upx;
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
</style>
