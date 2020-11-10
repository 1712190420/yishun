<template>
	<view style="background-color: #eee;">
		<view class="gerenxinxi" style="background-color: #fff;">
			<view class="touxiang">
				<image :src="me.avatarUrl" style="width: 150upx;height: 150upx;border-radius: 50%;"></image>
			</view>
			<view class="xinxi">
				<view class="geren">
					<view class="name">
						{{me.nickName}}
					</view>
					<view class="sex" v-if="me.gender == 0">
						<image src="../../static/icon/man.png" style="width: 30upx;height: 30upx;"></image>
					</view>
					<view class="sex" v-if="me.gender == 1">
						<image src="../../static/icon/woman.png" style="width: 30upx;height: 30upx;"></image>
					</view>
				</view>	
				<view class="renzheng">
					未认证
				</view>
			</view>
		</view>
		<view class="gong" style="background-color: #fff;">
			<view class="gongneng">
				<view class="zigongneng" @click="jumpyuepai">
					<image class="tu" src="../../static/icon/wodeshoucang.png"></image>
					<view class="myyuepai">我的约拍</view>
				</view>
				<view class="zigongneng" @click="jumpzhuye">
					<image class="tu" src="../../static/icon/gerenzhuye.png"></image>
					<view class="myyuepai">个人主页</view>
				</view>
				<view class="zigongneng" @click="jumpbianji">
					<image class="tu" src="../../static/icon/bianji.png"></image>
					<view class="myyuepai">编辑资料</view>
				</view>
			</view>
			<view class="gongneng">
				<view class="zigongneng">
					<image class="tu" src="../../static/icon/fenxiangminpian.png"></image>
					<view class="myyuepai">分享名片</view>
				</view>
				<view class="zigongneng" @click="jumpguanzhu">
					<image class="tu" src="../../static/icon/wodeshoucang.png"></image>
					<view class="myyuepai">我的关注</view>
				</view>
				<view class="zigongneng">
					<image class="tu" src="../../static/icon/fankui.png"></image>
					<view class="myyuepai">建议反馈</view>
				</view>
			</view>
		</view>
		<view class="gong" style="background-color: #fff;">
			<view class="huodong">
				<image class="icon" src="../../static/icon/renzheng.png"></image>
				<view class="text">认证中心</view>
				<image class="qianjin" src="../../static/icon/qianjin.png"></image>
			</view>
			<view class="huodong">
				<image class="icon" src="../../static/icon/guanli.png"></image>
				<view class="text">活动管理</view>
				<image class="qianjin" src="../../static/icon/qianjin.png"></image>
			</view>
			<view class="huodong">
				<image class="icon" src="../../static/icon/qiandao.png"></image>
				<view class="text">每日签到</view>
				<image class="qianjin" src="../../static/icon/qianjin.png"></image>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				me:[],
			}
		},
		onShow(e) {
			this.initPage()
		},
		methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/user/getUser',
					data: {
						account:1
					}
				})
				this.me = res.data.data;
			},
			jumpyuepai(e) {
				var that = this;
				var account = that.me.account;
				uni.navigateTo({
				    url: '../gerenxinxi/wodeyuepai?account='+account,
				});
			},
			jumpzhuye(e) {
				var that = this;
				var account = that.me.account;
				uni.navigateTo({
				    url: '../gerenxinxi/gerenzhuye?account='+account,
				});
			},
			jumpbianji(e) {
				var that = this;
				var account = that.me.account;
				uni.navigateTo({
				    url: '../gerenxinxi/bianji?account='+account,
				});
			},
			jumpguanzhu(e) {
				var that = this;
				var account = that.me.account;
				uni.navigateTo({
				    url: '../gerenxinxi/guanzhu?account='+account,
				});
			}
		}
	}
</script>

<style>
    .gerenxinxi{
		display: flex;
		flex-direction: row;
		border-style: solid;
		border-width: 3upx;
		border-color: #E5E5E5;
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
		align-items: center;
		margin-left: 50upx;
	}
	.geren{
		display: flex;
		flex-direction: row;
	}
	.sex{
		margin-left: 30upx;
	}
	.gong{
		margin-top: 50upx;
	}
	.gongneng{
		display: flex;
		flex-direction: row;
		
		height: 200upx;
	}
	.zigongneng{
		display: flex;
		flex-direction: column;
		flex: 1;
		border: 1upx solid #E5E5E5;
		justify-content: center;
		align-items: center;
	}
	.tu{
		 width: 50upx;
		 height: 50upx;
	}
	.myyuepai{
	}
	.huodong{
		display: flex;
		flex-direction: row;
		border: 1upx solid #E5E5E5;
		height: 100upx;
		align-items: center;
	}
	.icon{
		margin-left: 40upx;
		height: 40upx;
		width: 40upx;
	}
	.text{
		margin-left: 20upx;
	}
	.qianjin{
		position: absolute;
		right: 40upx;
		height: 40upx;
		width: 40upx;
	}
</style>
