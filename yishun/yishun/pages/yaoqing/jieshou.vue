<template>
	<view>
		<uni-segmented-control :current="current" :values="items" @clickItem="onClickItem" style-type="button" radius="100%" width="80%" active-color="#4D3B7E" style="background-color: #FFFFFF;" ></uni-segmented-control>
		<view class="content">
		    <view v-show="current === 0">
				<scroll-view scroll-y="true" style="height: 1050upx;">
					<view v-for="(item,index) in fachu" :key="index">
						<view class="yuepai">
							<view class="picture">
								<image :src="fachu[index].img" style="width: 400upx;height: 300upx;"></image>
							</view>
							<view class="text">
								{{fachu[index].explain}}
							</view>
							<view class="location">
								<view class="mincheng">
									被邀请人:{{fachu[index].invitedPeople}}
								</view>
								<view class="didian">
									<view>
										<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
									</view>
									<view class="dizhi">
										{{fachu[index].cameraArea}}
									</view>
								</view>
								<view class="shijian">
									{{fachu[index].cameraTime}}
								</view>
							</view>	
						</view>
					</view>
				</scroll-view>
			</view>
			<view v-show="current === 1">
				<scroll-view scroll-y="true" style="height: 1050upx;">
					<view v-for="(item,index) in shoudao" :key="index">
						<view class="yuepai">
							<view class="picture">
								<image :src="shoudao[index].img" style="width: 400upx;height: 300upx;"></image>
							</view>
							<view class="text">
								{{shoudao[index].explain}}
							</view>
							<view class="location">
								<view class="mincheng">
									邀请人:{{shoudao[index].invitedPeople}}
								</view>
								<view class="didian">
									<view>
										<image src="../../static/icon/location.png" style="width: 30upx;height: 30upx;"></image>
									</view>
									<view class="dizhi">
										{{shoudao[index].cameraArea}}
									</view>
								</view>
								<view class="shijian">
									{{shoudao[index].cameraTime}}
								</view>
							</view>	
						</view>
					</view>
				</scroll-view>
			</view>
		</view>
	</view>
</template>

<script>
	var inf;
	export default {
		data() {
			return {
				items: ['发出的邀请','收到的邀请'],
				current: 0,
				fachu:[],
				shoudao:[],
			}
		},
		onLoad(e) {
			inf = e;
			this.initPage()
		},
		methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/appointment/selectAppoByCondition',
					data: {
						invitedAccount:inf.inviteAccount,
						status:1
					}
				})
				this.fachu = res.data.data;
				
				const res1 = await this.$myRequest({
					url: '/appointment/selectAppoByCondition2',
					data: {
						inviteAccount:inf.inviteAccount,
						status:1
					}
				})
				this.shoudao = res1.data.data;
			},
			onClickItem(e) {
			    if (this.current !== e.currentIndex) {
			        this.current = e.currentIndex;
			    }
			},
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
