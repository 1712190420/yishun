# 约拍


<a name="overview"></a>
## 概览

### 版本信息
*版本* : 1.0


### URI scheme
*域名* : localhost:8080  
*基础路径* : /


### 标签

* appointment-controller : Appointment Controller
* hello-controller : Hello Controller
* production-controller : Production Controller
* user-controller : User Controller




<a name="paths"></a>
## 资源

<a name="appointment-controller_resource"></a>
### Appointment-controller
Appointment Controller


<a name="acceptinvitationusingget"></a>
#### 接受邀请
```
GET /appointment/acceptInvitation
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**appoId**  <br>*可选*|appoId|integer (int32)|
|**Query**|**inviteAccount**  <br>*可选*|inviteAccount|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/appointment/acceptInvitation
```


###### 请求 query
```
json :
{
  "appoId" : 0,
  "inviteAccount" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="deleteinviteusingdelete"></a>
#### 撤销邀请
```
DELETE /appointment/deleteInvite
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*|account|string|
|**Query**|**id**  <br>*可选*|id|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/appointment/deleteInvite
```


###### 请求 query
```
json :
{
  "account" : "string",
  "id" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="getappointmentbyaccountusingget"></a>
#### 根据account获取对应约拍
```
GET /appointment/getAppointmentByAccount
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*|account|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/appointment/getAppointmentByAccount
```


###### 请求 query
```
json :
{
  "account" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="getappointmentbyidusingget"></a>
#### 根据id获取对应约拍
```
GET /appointment/getAppointmentById
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*可选*|id|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/appointment/getAppointmentById
```


###### 请求 query
```
json :
{
  "id" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="getfocusappointmentusingget"></a>
#### 获取关注约拍
```
GET /appointment/getFocusAppointment
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*|account|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/appointment/getFocusAppointment
```


###### 请求 query
```
json :
{
  "account" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="gethotappointmentusingget"></a>
#### 获取热门约拍
```
GET /appointment/getHotAppointment
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/appointment/getHotAppointment
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="insertinviteusingget"></a>
#### 发起约拍邀请
```
GET /appointment/insertInvite
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**appointmentId**  <br>*可选*|integer (int32)|
|**Query**|**inviteAccount**  <br>*可选*|string|
|**Query**|**invitedAccount**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/appointment/insertInvite
```


###### 请求 query
```
json :
{
  "appointmentId" : 0,
  "inviteAccount" : "string",
  "invitedAccount" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="refuseinvitationusingget"></a>
#### 拒绝邀请
```
GET /appointment/refuseInvitation
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**appoId**  <br>*可选*|appoId|integer (int32)|
|**Query**|**inviteAccount**  <br>*可选*|inviteAccount|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/appointment/refuseInvitation
```


###### 请求 query
```
json :
{
  "appoId" : 0,
  "inviteAccount" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="selectappobyconditionusingget"></a>
#### 根据条件查询接受和拒绝的邀请信息
```
GET /appointment/selectAppoByCondition
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**invitedAccount**  <br>*可选*|invitedAccount|string|
|**Query**|**status**  <br>*可选*|status|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/appointment/selectAppoByCondition
```


###### 请求 query
```
json :
{
  "invitedAccount" : "string",
  "status" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="selectappobycondition2usingget"></a>
#### 根据条件查询发出被接受和被拒绝的邀请信息
```
GET /appointment/selectAppoByCondition2
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**inviteAccount**  <br>*可选*|inviteAccount|string|
|**Query**|**status**  <br>*可选*|status|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/appointment/selectAppoByCondition2
```


###### 请求 query
```
json :
{
  "inviteAccount" : "string",
  "status" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="hello-controller_resource"></a>
### Hello-controller
Hello Controller


<a name="hellousingget"></a>
#### 测试用接口
```
GET /hello
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/hello
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="production-controller_resource"></a>
### Production-controller
Production Controller


<a name="gethotimageusingget"></a>
#### 获取热门图片
```
GET /production/getHotImg
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/production/getHotImg
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="getproductionbytagusingget"></a>
#### 根据标签获取作品
```
GET /production/getProduction
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**tag**  <br>*可选*|tag|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/production/getProduction
```


###### 请求 query
```
json :
{
  "tag" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="getproductionbyaccountusingget"></a>
#### 根据账号获取作品
```
GET /production/getProductionByAccount
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*|account|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/production/getProductionByAccount
```


###### 请求 query
```
json :
{
  "account" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="insertnewproductionusingpost"></a>
#### 新增作品
```
POST /production/insertNewProduction
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*||string|
|**Query**|**cameraArea**  <br>*可选*||string|
|**Query**|**explain**  <br>*可选*||string|
|**Query**|**file**  <br>*必填*|file|< file > array(multi)|
|**Query**|**launchTime**  <br>*可选*||string|
|**Query**|**taglist**  <br>*可选*||string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/production/insertNewProduction
```


###### 请求 query
```
json :
{
  "account" : "string",
  "cameraArea" : "string",
  "explain" : "string",
  "file" : "file",
  "launchTime" : "string",
  "taglist" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="user-controller_resource"></a>
### User-controller
User Controller


<a name="followuserusingget"></a>
#### 关注
```
GET /user/followUser
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*|account|string|
|**Query**|**focusAccount**  <br>*可选*|focusAccount|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/user/followUser
```


###### 请求 query
```
json :
{
  "account" : "string",
  "focusAccount" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="getfocuslistusingget"></a>
#### 获取关注列表
```
GET /user/getFocusList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*|account|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/user/getFocusList
```


###### 请求 query
```
json :
{
  "account" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="getfocusnumusingget"></a>
#### 获取粉丝人数
```
GET /user/getFocusNum
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*|account|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/user/getFocusNum
```


###### 请求 query
```
json :
{
  "account" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="getuserbyaccountusingget"></a>
#### 获取用户数据
```
GET /user/getUser
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*|account|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/user/getUser
```


###### 请求 query
```
json :
{
  "account" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="unfollowuserusingget"></a>
#### 取消关注
```
GET /user/unfollowUser
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*|account|string|
|**Query**|**focusAccount**  <br>*可选*|focusAccount|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/user/unfollowUser
```


###### 请求 query
```
json :
{
  "account" : "string",
  "focusAccount" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```


<a name="updateuserbyaccountusingpost"></a>
#### 修改用户数据
```
POST /user/updateUser
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**account**  <br>*可选*||string|
|**Query**|**age**  <br>*可选*||integer (int32)|
|**Query**|**area**  <br>*可选*||string|
|**Query**|**auth**  <br>*可选*||string|
|**Query**|**birthday**  <br>*可选*||string|
|**Query**|**city**  <br>*可选*||string|
|**Query**|**gender**  <br>*可选*||integer (int32)|
|**Query**|**height**  <br>*可选*||integer (int32)|
|**Query**|**hobby**  <br>*可选*||string|
|**Query**|**nickName**  <br>*可选*||string|
|**Query**|**phonenumber**  <br>*可选*||string|
|**Query**|**province**  <br>*可选*||string|
|**Query**|**weight**  <br>*可选*||string|
|**FormData**|**file**  <br>*必填*|file|file|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[JSONResult](#jsonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/user/updateUser
```


###### 请求 query
```
json :
{
  "account" : "string",
  "age" : 0,
  "area" : "string",
  "auth" : "string",
  "birthday" : "string",
  "city" : "string",
  "gender" : 0,
  "height" : 0,
  "hobby" : "string",
  "nickName" : "string",
  "phonenumber" : "string",
  "province" : "string",
  "weight" : "string"
}
```


###### 请求 formData
```
json :
"file"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "msg" : "string",
  "ok" : "string",
  "status" : 0
}
```




<a name="definitions"></a>
## 定义

<a name="jsonresult"></a>
### JSONResult

|名称|说明|类型|
|---|---|---|
|**data**  <br>*可选*|**样例** : `"object"`|object|
|**msg**  <br>*可选*|**样例** : `"string"`|string|
|**ok**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `0`|integer (int32)|





