package com.xue.service;

import com.xue.exception.MyException;
import com.xue.pojo.dto.AppointmentStatusTransfer;
import com.xue.pojo.po.AppointmentInfo;
import com.xue.pojo.vo.AppointmentInfoShow;
import com.xue.pojo.vo.InvitationShow;

import java.util.List;

public interface AppointmentService {
    List<AppointmentInfoShow> selectHotAppointment();
    List<AppointmentInfoShow> selectFocusAppointment(String account) throws MyException;
    AppointmentInfoShow selectAppointmentById(int id);
    String insertInvitation(AppointmentStatusTransfer statusTransfer);
    String deleteByAppoIdAndInviteAccount(String account,int appoid);
    List<InvitationShow> selectAppoByCondition(String inviteAccount,String invitedAccount,int status)throws MyException;
    String updateStatusByCondition(String inviteAccount,int appoId,int status,int oldstatus);
    List<AppointmentInfoShow> selectAppointmentByAccount(String account)throws MyException;

}
