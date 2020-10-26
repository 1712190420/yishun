<template>
	<view>
		<view class="yuepai">
			<view class="gerenxinxi" @click="jumpzhuye">
				<view class="touxiang">
					<image src="../../static/2.png" style="width: 150upx;height: 150upx;border-radius: 50%;"></image>
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
			
			<view class="jianjie">
				<view class="text">
					希望互免
				</view>
				<view class="paishe">
					拍摄时间：2020/10/14 10:28
				</view>
			</view>
			<view class="text">
				我很喜欢
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
			<view class="yaoqing">
				<view class="kefu tubiao">
					<image src="../../static/icon/kefu.png" style="width: 50upx;height: 50upx;"></image>
					<view class="test">
						客服
					</view>
				</view>
				<view class="souchang tubiao">
					<image src="../../static/icon/shoucang.png" style="width: 50upx;height: 50upx;"></image>
					<view class="test">
						收藏
					</view>
				</view>
				<view class="fengxiang tubiao">
					<image src="../../static/icon/fenxiang.png" style="width: 50upx;height: 50upx;"></image>
					<view class="test">
						分享
					</view>
				</view>
				<view class="faqiyaoqing" @click="faqiyaoqing">
					<button class="faqi">{{yaoqing}}</button>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				yaoqing:"发起邀请"
			}
		},
		methods: {
			jumpzhuye(e) {
				uni.navigateTo({
				    url: '../gerenxinxi/gerenzhuye',
				});
			},
			faqiyaoqing(e){
				this.yaoqing = "已邀请"
			}
		}
	}
</script>

<style>
.yuepai{
	display: flex;
	flex-direction: column;
	background-color: #FFFFFF
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
.geren{
	display: flex;
	flex-direction: row;
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
.yaoqing{
	display: flex;
	flex-direction: row;
	border: 1upx solid #E5E5E5;
	height: 150upx;
	margin-top: 30upx;
	align-items: center;
}
.tubiao{
	margin-left: 60upx;
}
.test{
	font-size: 8upx;
}
.faqiyaoqing{
	display: flex;
	align-items: center;
}
.faqi{
	position: absolute;
	right: 30upx;
	width: 300upx;
	background-color: #4D3B7E;
	color: #FFFFFF;
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
