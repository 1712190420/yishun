<template>
	<view>
		<view class="quanju" >
			<view class="denlu">
				<view class="account">
					<input type="text" value="请输入账号" />
				</view>
				<view class="password">
					<input type="text" value="请输入密码" />
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
			}
		},
		onLoad() {

		},
		methods: {

		}
	}
</script>

<style>
.quanju{
	display: flex;
	justify-content: center;
	align-items: center;
	height: 1200upx;
	width: 750upx;
}
.denlu{
	display: flex;
	flex-direction: column;
	background-color: #FFFFFF;
	height: 400upx;
}
</style>
