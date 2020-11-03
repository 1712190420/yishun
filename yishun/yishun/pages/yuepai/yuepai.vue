<template>
	<view>
		<uni-segmented-control :current="current" :values="items" @clickItem="onClickItem" style-type="button" radius="100%" width="80%" active-color="#4D3B7E" style="background-color: #FFFFFF;" ></uni-segmented-control>
		<view class="content">
		    <view v-show="current === 0">
				<scroll-view scroll-y="true" style="height: 1070upx;">
					<view v-for="(item,index) in information" :key="index">
						<view class="yuepai">
							<view class="gerenxinxi" @click="jumpzhuye(index)">
								<view class="touxiang">
									<image :src="information[index].avatarUrl" style="width: 150upx;height: 150upx;border-radius: 50%;"></image>
								</view>
								<view class="xinxi">
									<view class="geren">
										<view class="name">
											{{information[index].nickName}}
										</view>
										<view class="sex" v-if="information[index].gender == 0">
											<image src="../../static/icon/man.png" style="width: 30upx;height: 30upx;"></image>
										</view>
										<view class="sex" v-if="information[index].gender == 1">
											<image src="../../static/icon/woman.png" style="width: 30upx;height: 30upx;"></image>
										</view>
									</view>	
									<view class="time">
										{{information[index].launchTime}}
									</view>
								</view>
							</view>
							
							<view class="xin" @click="jumpxiangqing(index)">
								<view class="text">
									{{price[information[index].price]}}
								</view>
								<view class="text">
									{{information[index].explain}}
								</view>
								<view>
									<view class="picture">
										<image :src="information[index].imgList[0]" style="width: 400upx;height: 300upx;"></image>
									</view>
								</view>
								<view class="tableList">
									<view v-for="(item,index) in information[index].tagList" :key="index">
										<button class="table">{{tableList[item]}}</button>
									</view>	
								</view>
								<view class="location">
									<view>
										<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
									</view>
									<view class="dizhi">
										{{information[index].cameraArea}}
									</view>
									<view class="shoudao">
										收到约拍{{information[index].getInvite}}
									</view>
									<view class="yuedu">
										阅读{{information[index].readNumber}}
									</view>
								</view>
							</view>
						</view>
					</view>
				</scroll-view>
			</view>
			<view v-show="current === 1">
				<view v-if="zero.status == 200">
					<scroll-view scroll-y="true" style="height: 1070upx;">
						<view v-for="(item,index) in guanzhushuju" :key="index">
							<view class="yuepai">
								<view class="gerenxinxi" @click="jumpzhuye(index)">
									<view class="touxiang">
										<image :src="guanzhushuju[index].avatarUrl" style="width: 150upx;height: 150upx;border-radius: 50%;"></image>
									</view>
									<view class="xinxi">
										<view class="geren">
											<view class="name">
												{{guanzhushuju[index].nickName}}
											</view>
											<view class="sex" v-if="guanzhushuju[index].gender == 0">
												<image src="../../static/icon/man.png" style="width: 30upx;height: 30upx;"></image>
											</view>
											<view class="sex" v-if="guanzhushuju[index].gender == 1">
												<image src="../../static/icon/woman.png" style="width: 30upx;height: 30upx;"></image>
											</view>
										</view>	
										<view class="time">
											{{guanzhushuju[index].launchTime}}
										</view>
									</view>
								</view>
								
								<view class="xin" @click="jumpxiangqing1(index)">
									<view class="text">
										{{price[guanzhushuju[index].price]}}
									</view>
									<view class="text">
										{{guanzhushuju[index].explain}}
									</view>
									<view>
										<view class="picture">
											<image :src="guanzhushuju[index].imgList[0]" style="width: 400upx;height: 300upx;"></image>
										</view>
									</view>
									<view class="tableList">
										<view v-for="(item,index) in guanzhushuju[index].tagList" :key="index">
											<button class="table">{{tableList[item]}}</button>
										</view>	
									</view>
									<view class="location">
										<view>
											<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
										</view>
										<view class="dizhi">
											{{guanzhushuju[index].cameraArea}}
										</view>
										<view class="shoudao">
											收到约拍{{guanzhushuju[index].getInvite}}
										</view>
										<view class="yuedu">
											阅读{{guanzhushuju[index].readNumber}}
										</view>
									</view>
								</view>
							</view>
						</view>
					</scroll-view>
				</view>
				<view v-if="zero.status == 500">
					<view class="none">
						<image src="../../static/none.jpg" mode=""></image>
					</view>
				</view>
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
	            current: 0,
				information:[],
				guanzhushuju:[],
				zero:'',
				price:["希望互免","需要收费","愿意付费","费用协商"],
				tableList:["风景照","前卫照","人像照","美食照"],
	        }
	    },
		onLoad(e) {
			this.initPage()
		},
	    methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/appointment/getHotAppointment',
					data: {}
				})
				this.information = res.data.data;
				
				const res1 = await this.$myRequest({
					url: '/appointment/getFocusAppointment',
					data: {
						account:1
					}
				})
				this.zero = res1.data;
				this.guanzhushuju = res1.data.data;
			},
	        onClickItem(e) {
	            if (this.current !== e.currentIndex) {
	                this.current = e.currentIndex;
	            }
	        },
			jumpzhuye(e) {
				var that = this;
				var account = that.information[e].account;
				uni.navigateTo({
				    url: '../gerenxinxi/gerenzhuye?account='+account,
				});
			},
			jumpxiangqing(e) {
				var that = this;
				var yuepaiId = that.information[e].id;
				uni.navigateTo({
				    url: '../yuepai/xiangqing?id='+yuepaiId,
				});
			},
			jumpxiangqing1(e) {
				var that = this;
				var yuepaiId = that.guanzhushuju[e].id;
				uni.navigateTo({
				    url: '../yuepai/xiangqing?id='+yuepaiId,
				});
			},
	    }
	}
</script>

<style>
.yuepai{
	display: flex;
	flex-direction: column;
	background-color: #FFFFFF;
	padding-bottom: 30upx;
	margin-bottom: 30upx;
}
.gerenxinxi{
	display: flex;
	flex-direction: row;
	height: 200upx;
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
.name{
	font-size: 36upx;
	line-height: 30upx;
}
.geren{
	display: flex;
	flex-direction: row;
	margin-bottom: 10upx;
}
.sex{
	margin-left: 30upx;
}
.text{
	margin-top: 30upx;
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
	display: flex;
	flex-direction: row;
	margin-left: 50upx;
}
.table{
	display: flex;
	height: 50upx;
	width: 135upx;
	border-radius: 50upx;
	line-height: 50upx;
	float:left;
	margin-right: 10upx;
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
.xin{
	display: flex;
	flex-direction: column;
	justify-content: center;
}
.none{
	background-color: #FFFFFF;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 32upx;
	height: 1070upx;
}
</style>
