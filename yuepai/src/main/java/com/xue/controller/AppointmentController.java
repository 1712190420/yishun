package com.xue.controller;

import com.xue.exception.MyException;
import com.xue.pojo.dto.AppointmentStatusTransfer;
import com.xue.pojo.vo.AppointmentInfoShow;
import com.xue.service.AppointmentService;
import com.xue.utils.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @ApiOperation("获取热门约拍")
    @GetMapping("/getHotAppointment")
    public JSONResult getHotAppointment(){
        return JSONResult.success(appointmentService.selectHotAppointment());
    }

    @ApiOperation("获取关注约拍")
    @GetMapping("/getFocusAppointment")
    public JSONResult getFocusAppointment(String account){
        try {
            return JSONResult.success(appointmentService.selectFocusAppointment(account));
        } catch (MyException e) {
            return JSONResult.errorMsg(e.getMessage());
        }
    }

    @ApiOperation("根据id获取对应约拍")
    @GetMapping("/getAppointmentById")
    public JSONResult getAppointmentById(int id){
        return JSONResult.success(appointmentService.selectAppointmentById(id));
    }

    @ApiOperation("发起约拍邀请")
    @GetMapping("/insertInvite")
    public JSONResult insertInvite(AppointmentStatusTransfer appointmentStatusTransfer){
        return JSONResult.success(appointmentService.insertInvitation(appointmentStatusTransfer));
    }

    @ApiOperation("撤销邀请")
    @DeleteMapping("/deleteInvite")
    public JSONResult deleteInvite(String account,int id){
        return JSONResult.success(appointmentService.deleteByAppoIdAndInviteAccount(account,id));
    }

    @ApiOperation("根据条件查询接受和拒绝的邀请信息")
    @GetMapping("/selectAppoByCondition")
    public  JSONResult selectAppoByCondition(String invitedAccount,int status){
            try {
                return  JSONResult.success(appointmentService.selectAppoByCondition(null,invitedAccount,status));
            } catch (MyException e) {
                return JSONResult.errorMsg(e.getMessage());
            }
    }

    @ApiOperation("根据条件查询发出被接受和被拒绝的邀请信息")
    @GetMapping("/selectAppoByCondition2")
    public  JSONResult selectAppoByCondition2(String inviteAccount,int status){
        try {
            return  JSONResult.success(appointmentService.selectAppoByCondition(null,inviteAccount,status));
        } catch (MyException e) {
            return JSONResult.errorMsg(e.getMessage());
        }
    }

    @ApiOperation("接受邀请")
    @GetMapping("/acceptInvitation")
    public JSONResult acceptInvitation(String inviteAccount,int appoId){
        return JSONResult.success(appointmentService.updateStatusByCondition(inviteAccount,appoId,1,0));
    }


    @ApiOperation("拒绝邀请")
    @GetMapping("/refuseInvitation")
    public JSONResult refuseInvitation(String inviteAccount,int appoId){
        return JSONResult.success(appointmentService.updateStatusByCondition(inviteAccount,appoId,2,0));
    }

    @ApiOperation("根据account获取对应约拍")
    @GetMapping("/getAppointmentByAccount")
    public JSONResult getAppointmentByAccount(String account){
        try {
            return JSONResult.success(appointmentService.selectAppointmentByAccount(account));
        } catch (MyException e) {
            return JSONResult.errorMsg(e.getMessage());
        }
    }



}
