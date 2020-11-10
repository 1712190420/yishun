<template>
	<view>
		<view class="touxiang">
			<image :src="xinxi.avatarUrl" style="width: 150upx;height: 150upx;border-radius: 50%;"></image>
		</view>
		<view class="xinmin">
			{{xinxi.nickName}}
		</view>
		<view class="gerenxinxi">
			<view class="sex" v-if="xinxi.gender == 0">
				<image src="../../static/icon/man.png" style="width: 30upx;height: 30upx;"></image>
			</view>
			<view class="sex" v-if="xinxi.gender == 1">
				<image src="../../static/icon/woman.png" style="width: 30upx;height: 30upx;"></image>
			</view>
			<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;border-radius: 50%;"></image>
			<view class="dizhi">{{xinxi.province+xinxi.city+xinxi.area}}</view>
			<view class="age">年龄:{{xinxi.age}}</view>
		</view>
		<view class="renshu">
			<view class="yuepai">约拍{{yuepaiNumber}}</view>
			<view class="guanzhu">关注{{forceNumber}}</view>
			<view class="fensi">粉丝{{fansNumber}}</view>
		</view>
		<uni-segmented-control :current="current" :values="items" @clickItem="onClickItem" style-type="button" radius="100%" width="80%" active-color="#4D3B7E" style="background-color: #FFFFFF;" ></uni-segmented-control>
		<view class="content">
		    <view v-show="current === 0">
				<scroll-view scroll-y="true">
					<view v-for="(item,index) in information" :key="index">
						<view class="yanse" @click="jumpxiangqing(index)">
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
				</scroll-view>
		    </view>
		    <view v-show="current === 1">
				<scroll-view scroll-y="true" style="height: 1000upx;">
					<view v-for="(item,index) in production" :key="index">
						<view class="zuopinji">
							<view class="picture">
								<image :src="production[index].imglist[0]" style="width: 400upx;height: 300upx;"></image>
							</view>
							<view class="zuopinjianshu">
								{{production[index].explain}}
							</view>
							<view class="zuopinlocation">
								<view class="mincheng">
									摄影师:{{production[index].nickName}}
								</view>
								<view class="didian">
									<view>
										<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
									</view>
									<view class="dizhi">
										{{production[index].cameraArea}}
									</view>
								</view>
							</view>	
							<view class="anniu">
								<button @click="yaoqing(index)" class="anniuyangshi yaoqing" type="default"><image src="../../static/icon/yaoqing.png" style="width: 30upx;height: 30upx;align-items: center;color: #007AFF;"></image>邀请</button>
								<button @click="guanzhu" class="anniuyangshi guanzhuyonghu" type="default">添加关注</button>
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
	var inf;
	export default {
	    components: {uniSegmentedControl},
	    data() {
	        return {
	            items: ['约拍动态','个人作品集'],
	            current: 0,
				fansNumber:[],
				xinxi:[],
				forcexinxi:[],
				forceNumber:'',
				production:[],
				information:[],
				price:["希望互免","需要收费","愿意付费","费用协商"],
				tableList:["风景照","前卫照","人像照","美食照"],
				yuepaiNumber:'',
	        }
	    },
		onLoad(e) {
			inf = e;
			this.initPage()
		},
	    methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/user/getFocusNum',
					data: {
						account:inf.account
					}
				})
				this.fansNumber = res.data.data;
				
				const res1 = await this.$myRequest({
					url: '/user/getUser',
					data: {
						account:inf.account
					}
				})
				this.xinxi = res1.data.data;
				
				const res2 = await this.$myRequest({
					url: '/user/getFocusList',
					data: {
						account:inf.account
					}
				})
				this.forcexinxi = res2.data.data;
				if(this.forcexinxi!=null){
					this.forceNumber = this.forcexinxi.length;
				}else{
					this.forceNumber = 0;
				}
				
				const res3 = await this.$myRequest({
					url: '/production/getProductionByAccount',
					data: {
						account:inf.account
					}
				})
				this.production = res3.data.data;
				
				const res4 = await this.$myRequest({
					url: '/appointment/getAppointmentByAccount',
					data: {
						account:inf.account
					}
				})
				this.information = res4.data.data;
				if(this.information!=null){
					this.yuepaiNumber = this.information.length;
				}else{
					this.yuepaiNumber = 0;
				}
				
			},
	        onClickItem(e) {
	            if (this.current !== e.currentIndex) {
	                this.current = e.currentIndex;
	            }
	        },
			jumpxiangqing(e) {
				var that = this;
				var yuepaiId = that.information[e].id;
				uni.navigateTo({
				    url: '../yuepai/xiangqing?id='+yuepaiId,
				});
			},
			yaoqing(e){
				const res = this.$myRequest({
					url: '/appointment/insertInvite',
					data: {
						inviteAccount:inf.account,
						invitedAccount:inf.account,
						appointmentId:this.production[e].id
					}
				})
			},
			guanzhu(e){
				const res = this.$myRequest({
					url: '/user/followUser',
					data: {
						account:inf.account,
						focusAccount:inf.account,
					}
				});
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
	font-size: 28upx;
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
