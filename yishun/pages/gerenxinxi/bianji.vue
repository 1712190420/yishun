<template>
	<view class="quanju">
		<view class="ziliao">
			<view class="touxiang">
				<view class="miaoshu">
					头像
				</view>
				<view class="tupian" @click="upload">
					<image :src="img" mode="aspectFill" style="width: 50upx;height: 50upx;border-radius: 50%;"></image>
				</view>
				<view class="qianjin">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang" @click="shownicheng">
				<view class="miaoshu">
					昵称
				</view>
				<view class="tupian">
					{{nicheng}}
				</view>
				<view class="qianjin">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang">
				<view class="miaoshu">
					性别
				</view>
				<picker class="tupian" :range="sex" @change="sexChange">
					{{ sex[sexIndex] }} 
				</picker>
				<view class="qianjin">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang">
				<view class="miaoshu">
					生日
				</view>
				<picker class="tupian" :range="years" @change="yearChange" mode="multiSelector">
					{{years[0][yearsIndex1]}}-{{years[1][yearsIndex2]}}-{{years[2][yearsIndex3]}}
				</picker>
				<view class="qianjin">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang" @click="addressShow = true">
				<view class="content_list">
					<view class="miaoshu">地区</view>
					<view class="tupian">
					    {{address}}
						<pickerAddress v-model="addressShow" @confirm="addresspick" />
					</view>
					<view class="qianjin">
						<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
					</view>
				</view>
			</view>
			<view class="touxiang">
				<view class="miaoshu">
					身份
				</view>
				<picker class="tupian" :range="people" @change="peopleChange">
					{{ people[peopleIndex] }} 
				</picker>
				<view class="qianjin">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang" @click="shownianling">
				<view class="miaoshu">
					年龄/身高/体重
				</view>
				<view class="tupian">
					{{nianling}}
				</view>
				<view class="qianjin">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang" @click="showaihao">
				<view class="miaoshu">
					兴趣爱好
				</view>
				<view class="tupian">
					{{xingquaihao}}
				</view>
				<view class="qianjin">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
			<view class="touxiang" @click="showshouji">
				<view class="miaoshu">
					手机号
				</view>
				<view class="tupian">
					{{shouji}}
				</view>
				<view class="qianjin">
					<image src="../../static/icon/qianjin.png" style="width: 30upx;height: 30upx;"></image>
				</view>
			</view>
		</view>
		<view class="tijiao" @click="confirm">
			<button class="xiugai" type="default">修改</button>
		</view>
		
		<view :hidden="nichengtankuang" class="popup_content">
			<view class="popup_title">修改昵称</view>
			<view class="textarea">
				<view class="shuru">
					<textarea placeholder='请输入你的昵称' v-model="nicheng">
					</textarea>
				</view>
			</view>
			<view class="btn">
				<button @click="hidenicheng" class="quxiao" type="default">取消</button>
				<button @click="submitnicheng" class="quedin" type="default">确定</button>
			</view>
		</view>
		<view class="popup_overlay" :hidden="nichengtankuang" @click="hidenicheng()"></view>
		
		<view :hidden="nianlingtankuang" class="popup_content">
			<view class="popup_title">年龄/身高/体重</view>
			<view class="textarea">
				<view class="shuru">
					<textarea placeholder='请按格式输入你的年龄/身高/体重' v-model="nianling">
					</textarea>
				</view>
			</view>
			<view class="btn">
				<button @click="hidenianling" class="quxiao" type="default">取消</button>
				<button @click="submitnianling" class="quedin" type="default">确定</button>
			</view>
		</view>
		<view class="popup_overlay" :hidden="nianlingtankuang" @click="hidenianling()"></view>
		
		<view :hidden="aihaotankuang" class="popup_content">
			<view class="popup_title">兴趣爱好</view>
			<view class="textarea">
				<view class="shuru">
					<textarea placeholder='请输入你的兴趣爱好' v-model="xingquaihao">
					</textarea>
				</view>
			</view>
			<view class="btn">
				<button @click="hideaihao" class="quxiao" type="default">取消</button>
				<button @click="submitaihao" class="quedin" type="default">确定</button>
			</view>
		</view>
		<view class="popup_overlay" :hidden="aihaotankuang" @click="hideaihao()"></view>
		
		<view :hidden="shoujitankuang" class="popup_content">
			<view class="popup_title">手机号</view>
			<view class="textarea">
				<view class="shuru">
					<textarea placeholder='请输入你的手机号' v-model="shouji">
					</textarea>
				</view>
			</view>
			<view class="btn">
				<button @click="hideshouji" class="quxiao" type="default">取消</button>
				<button @click="submitshouji" class="quedin" type="default">确定</button>
			</view>
		</view>
		<view class="popup_overlay" :hidden="shoujitankuang" @click="hideshouji()"></view>
	</view>
</template>

<script>
	let img;
	import pickerAddress from '@/components/liudx-pickerAddress/index.vue'
	export default {
		data() {
			return {
				userDetailTransfer:{
					account: "1",
					age: '',
					area:"",
					auth:"",
					birthday:"",
					city:"",
					height:'',
					hobby:"",
					phonenumber:"",
					province:"",
					weight:"",
					gender:'',
					nickName: '',
				},
				addressShow: false,
				form: {
				    province: '',
				    city: '',
				    area: '',
				},
				address: '',
				sex:["男","女"],
				sexIndex:0,
				years:[
					[2012, 2019, 2020],
					[10, 11, 12],
					[1, 16, 17],
				],
				yearsIndex1:0,
				yearsIndex2:0,
				yearsIndex3:0,
				people:["摄影爱好者","摄影师","摄影工作室"],
				peopleIndex:0,
				nichengtankuang: true, // 默认隐藏
				nicheng: '', // 昵称
				nianlingtankuang: true, // 默认隐藏
				nianling: '', // 年龄/身高/体重
				aihaotankuang: true, // 默认隐藏
				xingquaihao: '', // 兴趣爱好
				shoujitankuang: true, // 默认隐藏
				shouji: '', // 手机号
				img:'',
				personInfo:[],
			}
		},
		onLoad(e) {
			//person = e;
			//console.log(person.id)
			this.initPage()
		},
		methods: {
			async initPage(){
				const res = await this.$myRequest({
					url: '/getUser',
					data: {
						account: 1,
					}
				})
				this.personInfo =res.data.data;
				this.img = this.personInfo.avatarUrl;
				this.nicheng = this.personInfo.nickName;
				this.nianling = this.personInfo.age+"/"+this.personInfo.height+"/"+this.personInfo.weight;
				this.sexIndex = this.personInfo.gender;
				this.shouji = this.personInfo.phonenumber;
				this.xingquaihao = this.personInfo.hobby;
				this.address = this.personInfo.province+this.personInfo.city+this.personInfo.area;
				if(this.personInfo.auth == "摄影工作室"){
					this.peopleIndex = 2;
				}else if(this.personInfo.auth == "摄影爱好者"){
					this.peopleIndex = 1;
				}else{
					this.peopleIndex = 0;
				}
				var a = this.personInfo.birthday.split("-");
				this.years[0][this.yearsIndex1] = a[0];
				this.years[1][this.yearsIndex2] = a[1];
				this.years[2][this.yearsIndex3] = a[2];
			},
			addresspick(obj) {
			    let arr = [ 'province', 'city', 'area'];
				console.log(arr)
			    let place = '';
			    arr.map(key => {
			        this.form[key] = obj[key].AreaId
			        place += obj[key].AreaName
			    })
			    this.address = place
			},
			sexChange:function(e){
				console.log(e)
				this.sexIndex = e.detail.value;
			},
			yearChange:function(e){
				console.log(e)
				this.yearsIndex1 = e.detail.value[0];
				this.yearsIndex2 = e.detail.value[1];
				this.yearsIndex3 = e.detail.value[2];
			},
			peopleChange:function(e){
				console.log(e)
				this.peopleIndex = e.detail.value;
			},
			shownicheng:function() { // 显示输入弹出框
				this.nichengtankuang = false;
			},
			hidenicheng:function() { // 隐藏输入弹出框
				this.nichengtankuang = true;
			},
			submitnicheng:function() { // 
				var _this =this;
				this.nichengtankuang = true;
				// 提交反馈内容
			    console.log(_this.nicheng);
			},
			shownianling:function() { // 显示输入弹出框
				this.nianlingtankuang = false;
			},
			hidenianling:function() { // 隐藏输入弹出框
				this.nianlingtankuang = true;
			},
			submitnianling:function() { // 
				var _this =this;
				this.nianlingtankuang = true;
				// 提交反馈内容
			    console.log(_this.nianling);
			},
			showaihao:function() { // 显示输入弹出框
				this.aihaotankuang = false;
			},
			hideaihao:function() { // 隐藏输入弹出框
				this.aihaotankuang = true;
			},
			submitaihao:function() { // 
				var _this =this;
				this.aihaotankuang = true;
				// 提交反馈内容
			    console.log(_this.xingquaihao);
			},
			showshouji:function() { // 显示输入弹出框
				this.shoujitankuang = false;
			},
			hideshouji:function() { // 隐藏输入弹出框
				this.shoujitankuang = true;
			},
			submitshouji:function() { // 
				var _this =this;
				this.shoujitankuang = true;
				// 提交反馈内容
			    console.log(_this.shouji);
			},
			confirm() {
				console.log(this.form.province);
				this.userDetailTransfer.nickName = this.nicheng;
				this.userDetailTransfer.gender = this.sexIndex;
				this.userDetailTransfer.birthday = this.years[0][this.yearsIndex1]+"-"+this.years[1][this.yearsIndex2]+"-"+this.years[2][this.yearsIndex3];
			    this.userDetailTransfer.province = this.form.province;
				this.userDetailTransfer.city = this.form.city;
				this.userDetailTransfer.area = this.form.area;
				this.userDetailTransfer.auth = this.people[this.peopleIndex]; 
				var a = this.nianling.split("/");
				this.userDetailTransfer.age = a[0];
				this.userDetailTransfer.height = a[1];
				this.userDetailTransfer.weight = a[2];
				this.userDetailTransfer.hobby = this.xingquaihao;
				this.userDetailTransfer.phonenumber = this.shouji;
				this.changeUser();
			},	
			async changeUser(){
				console.log(this.img);
				uni.uploadFile({
				    url: 'http://192.168.199.165:8080/updateUser', //仅为示例，非真实的接口地址
				    filePath: this.img,
				    name: 'file',
				    formData:this.userDetailTransfer,
					success: function () {
					    console.log('上传成功');
					},
				});
			
			},
			upload(){
				let that = this;
				uni.chooseImage({
				    success: function (chooseImageRes) {
				        const tempFilePaths = chooseImageRes.tempFilePaths;
						that.img = chooseImageRes.tempFilePaths[0];
				    }
				});
				console.log(that.img)
			},
		},
		components: {
		    pickerAddress
		}
	}
</script>

<style lang="scss" scoped>
    .content {
        &_list{
            display: flex;
            justify-content:space-around;
            &_content{
                flex: 1;
                width: auto;
                text-align: right;
            }
        }
    }
</style>

<style>
.quanju{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
.ziliao{
	display: flex;
	flex-direction: column;
	width: 680upx;
	margin-top: 30upx;
	background-color: #fff;
}
.touxiang{
	display: flex;
	flex-direction: row;
	border: 1upx solid #E5E5E5;
	height: 100upx;
	align-items: center;
}
.miaoshu{
	margin-left: 30upx;
}
.tupian{
	position: absolute;
	right: 160upx;
}
.qianjin{
	position: absolute;
	right: 80upx;
}
.tijiao{
	margin-top: 30upx;
}
.xiugai{
	background-color: #4D3B7E;
	color: #FFFFFF;
	width: 680upx;
}
.popup_overlay {
	position: fixed;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity=88);
}
.popup_content {
	position: fixed;
	top: 50%;
	left: 50%;
	width: 520upx;
	height: 400upx;
	margin-left: -270upx;
	margin-top: -270upx;
	background-color: white;
	z-index: 1002;
	overflow: auto;
	border-radius: 20upx;
}
.popup_title {
	display: flex;
	padding-top: 20upx;
	text-align: center;
	font-size: 32upx;
	padding-bottom: 30upx;
	justify-content: center;
}
.textarea {
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #F1F1F1;
	height: 200upx;
}
.shuru{
	display: flex;
	height: 100upx;
	width: 400upx;
	background-color: #FFFFFF;
}
.btn{
	display: flex;
	flex-direction: row;
	height: 60upx;
	margin-top: 20upx;
}
.quxiao{
	height: 60upx;
	line-height: 60upx;
	border: 1upx solid #4D3B7E;
	color: #4D3B7E;
	background-color: #FFFFFF;
	font-size: 32upx;
}
.quedin{
	height: 60upx;
	line-height: 60upx;
	color: #FFFFFF;
	background-color: #4D3B7E;
	font-size: 32upx;
}
</style>
