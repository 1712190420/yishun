package com.xue.controller;

import com.xue.exception.MyException;
import com.xue.pojo.po.UserDetail;
import com.xue.pojo.dto.UserDetailTransfer;
import com.xue.service.UserService;
import com.xue.utils.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("获取用户数据")
    @GetMapping("/getUser")
    public JSONResult getUserByAccount(String account){
        UserDetail userDetail = userService.selectUserByAccount(account);
        if (userDetail==null)
            return JSONResult.errorMsg("查无此用户");
        else return JSONResult.success(userDetail);
    }

    @ApiOperation("修改用户数据")
    @PostMapping("/updateUser")
    public JSONResult updateUserByAccount(@RequestParam("file") MultipartFile file, HttpServletRequest request, UserDetailTransfer userDetailTransfer){
        try {
            return JSONResult.success(userService.updateUserByAccount(file,request,userDetailTransfer));
        } catch (IOException e) {
            return JSONResult.errorMsg("更新用户数据失败，请重试！");
        }
    }


    @ApiOperation("获取关注列表")
    @GetMapping("/getFocusList")
    public JSONResult getFocusList(String account){
        try {
            return JSONResult.success(userService.selectFocusList(account));
        } catch (MyException e) {
            return JSONResult.errorMsg(e.getMessage());
        }
    }

    @ApiOperation("获取粉丝人数")
    @GetMapping("/getFocusNum")
    public JSONResult getFocusNum(String account){
        return JSONResult.success(userService.getFocusNum(account));
    }


    @ApiOperation("关注")
    @GetMapping("/followUser")
    public JSONResult  followUser(String account, String focusAccount){
        return  JSONResult.success(userService.followUser(account,focusAccount));
    }

    @ApiOperation("取消关注")
    @GetMapping("/unfollowUser")
    public JSONResult  unfollowUser(String account, String focusAccount){
        return  JSONResult.success(userService.unfollowUser(account,focusAccount));
    }

}
