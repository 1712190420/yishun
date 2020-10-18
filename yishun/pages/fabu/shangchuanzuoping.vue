<template>
	<view class="quanju">
		<view class="shuoming">
			<textarea class="shuru" type="text" placeholder="输入作品描述"></textarea>
		</view>
		<view class="shangchuan">
			<view class="jishu">
				<view class="miaoshu">
					图片上传
				</view>
				<view class="count">
					0/3
				</view>
			</view>
			<view class="tianjia">
				<image src="../../static/icon/fenlei.png" style="width: 150upx;height: 150upx;"></image>
			</view>
		</view>
		<view class="biaoqian">
			<view class="addbiaoqian">
				<button class="table" type="default">+标签</button>
			</view>
		</view>
		<view class="anniu">
			<button class="public" type="default">上传</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
.quanju{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
.shuoming{
	display: flex;
	border: 1upx solid #E5E5E5;
	height: 200upx;
	width: 680upx;
	margin-top: 30upx;
}
.shuru{
	margin-top: 20upx;
	margin-left: 30upx;
	width: 600upx;
}
.shangchuan{
	display: flex;
	flex-direction: column;
	border: 1upx solid #E5E5E5;
	height: 300upx;
	width: 680upx;
	margin-top: 30upx;
}
.jishu{
	display: flex;
	flex-direction: row;
}
.miaoshu{
	margin-top: 20upx;
	margin-left: 30upx;
}
.count{
	margin-top: 20upx;
	position: absolute;
	right: 60upx;
}
.tianjia{
	margin-left: 30upx;
	margin-top: 30upx;
}
.biaoqian{
	display: flex;
	border: 1upx solid #E5E5E5;
	height: 100upx;
	width: 680upx;
	margin-top: 30upx;
}
.addbiaoqian{
	display: flex;
	align-items: center;
	margin-left: 30upx;
}
.table{
	height: 80upx;
	width: 180upx;
	border-radius: 50upx;
	line-height: 80upx;
	float:left;
	margin-left: 10upx;
}
.public{
	margin-top: 30upx;
	width: 680upx;
	background-color: #007AFF;
}
</style>
