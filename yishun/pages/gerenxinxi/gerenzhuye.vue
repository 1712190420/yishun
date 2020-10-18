<template>
	<view>
		<view class="touxiang">
			<image src="../../static/icon/man.png" style="width: 150upx;height: 150upx;border-radius: 50%;"></image>
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
		<uni-segmented-control :current="current" :values="items" @clickItem="onClickItem" style-type="button" radius="100%" width="80%" active-color="#00F"  ></uni-segmented-control>
		<view class="content">
		    <view v-show="current === 0">
				<scroll-view scroll-y="true">
					<view class="text">
						希望互免
					</view>
					<view>
						<view class="picture">
							<image src="../../static/icon/fabu.png" style="width: 150upx;height: 150upx;"></image>
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
				</scroll-view>
		    </view>
		    <view v-show="current === 1">
				选项2
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
	        }
	    }
	}
</script>

<style>
.touxiang{
	display: flex;
	justify-content: center;
	align-items: center;
	height: 250upx;
}
.xinmin{
	display: flex;
	justify-content: center;
	align-items: center;
}
.gerenxinxi{
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	margin-top: 30upx;
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
	margin-top: 30upx;
	margin-bottom: 30upx;
}
.guanzhu{
	margin-left: 150upx;
	margin-right: 150upx;
}
.text{
	margin-top: 50upx;
	margin-left: 50upx;
}
.picture{
	display: flex;
	justify-content: center;
	align-items: center;
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
