package com.xue.service.Impl;

import com.xue.dao.AppointmentInfoMapper;
import com.xue.dao.AppointmentStatusMapper;
import com.xue.dao.FocusUserMapper;
import com.xue.dao.UserDetailMapper;
import com.xue.exception.MyException;
import com.xue.pojo.dto.AppointmentStatusTransfer;
import com.xue.pojo.po.AppointmentInfo;
import com.xue.pojo.po.AppointmentStatus;
import com.xue.pojo.vo.AppointmentInfoShow;
import com.xue.pojo.vo.InvitationShow;
import com.xue.service.AppointmentService;
import com.xue.utils.AddressTransferUtil;
import com.xue.utils.IPAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentInfoMapper appointmentInfoMapper;
    @Autowired
    FocusUserMapper focusUserMapper;
    @Autowired
    AppointmentStatusMapper appointmentStatusMapper;
    @Autowired
    UserDetailMapper userDetailMapper;

    @Override
    public List<AppointmentInfoShow> selectHotAppointment() {
        List<AppointmentInfo> appointmentInfos = appointmentInfoMapper.selectHot();
        List<AppointmentInfoShow> appointmentInfoShows=new ArrayList<>();
        for (AppointmentInfo appointmentInfo : appointmentInfos) {
            AppointmentInfoShow appointmentInfoShow = new AppointmentInfoShow();
            appointmentInfoShow.setAccount(appointmentInfo.getAccount());
            appointmentInfoShow.setAvatarUrl(IPAddressUtil.getLocalIp()+appointmentInfo.getAvatarUrl());
            appointmentInfoShow.setCameraArea(appointmentInfo.getCameraArea());
            appointmentInfoShow.setCameraTime(appointmentInfo.getCameraTime());
            appointmentInfoShow.setExplain(appointmentInfo.getExplain());
            appointmentInfoShow.setGender(appointmentInfo.getGender());
            appointmentInfoShow.setGetInvite(appointmentInfo.getGetInvite());
            appointmentInfoShow.setId(appointmentInfo.getId());
            appointmentInfoShow.setImgList(AddressTransferUtil.addressTrans(appointmentInfo.getImgList()));
            appointmentInfoShow.setLaunchTime(appointmentInfo.getLaunchTime());
            appointmentInfoShow.setNickName(appointmentInfo.getNickName());
            appointmentInfoShow.setPrice(appointmentInfo.getPrice());
            appointmentInfoShow.setReadNumber(appointmentInfo.getReadNumber());
            appointmentInfoShow.setTagList(Arrays.asList(appointmentInfo.getTagList().split(";")));
            appointmentInfoShows.add(appointmentInfoShow);
        }
        return appointmentInfoShows;
    }

    @Override
    public List<AppointmentInfoShow> selectFocusAppointment(String account) throws MyException {
        List<AppointmentInfoShow> appointmentInfoShows=new ArrayList<>();
        List<String> focus = focusUserMapper.selectFocus(account);
        if (focus==null){
            throw new  MyException("没有关注的人");
        }
        for (String s : focus) {
            List<AppointmentInfo> appointmentInfoList = appointmentInfoMapper.selectByAccount(s);
            for (AppointmentInfo appointmentInfo : appointmentInfoList) {
                AppointmentInfoShow appointmentInfoShow = new AppointmentInfoShow();
                appointmentInfoShow.setAccount(appointmentInfo.getAccount());
                appointmentInfoShow.setAvatarUrl(IPAddressUtil.getLocalIp()+appointmentInfo.getAvatarUrl());
                appointmentInfoShow.setCameraArea(appointmentInfo.getCameraArea());
                appointmentInfoShow.setCameraTime(appointmentInfo.getCameraTime());
                appointmentInfoShow.setExplain(appointmentInfo.getExplain());
                appointmentInfoShow.setGender(appointmentInfo.getGender());
                appointmentInfoShow.setGetInvite(appointmentInfo.getGetInvite());
                appointmentInfoShow.setId(appointmentInfo.getId());
                appointmentInfoShow.setImgList(AddressTransferUtil.addressTrans(appointmentInfo.getImgList()));
                appointmentInfoShow.setLaunchTime(appointmentInfo.getLaunchTime());
                appointmentInfoShow.setNickName(appointmentInfo.getNickName());
                appointmentInfoShow.setPrice(appointmentInfo.getPrice());
                appointmentInfoShow.setReadNumber(appointmentInfo.getReadNumber());
                appointmentInfoShow.setTagList(Arrays.asList(appointmentInfo.getTagList().split(";")));
                appointmentInfoShows.add(appointmentInfoShow);
            }
        }
        if (appointmentInfoShows.size()==0){
            throw  new MyException("关注的人还没有发表约拍呢");
        }
        return appointmentInfoShows;
    }

    @Override
    public AppointmentInfoShow selectAppointmentById(int id) {
        AppointmentInfo appointmentInfo = appointmentInfoMapper.selectByPrimaryKey(id);
        AppointmentInfoShow appointmentInfoShow = new AppointmentInfoShow();
        appointmentInfoShow.setTagList(Arrays.asList(appointmentInfo.getTagList().split(";")));
        appointmentInfoShow.setPrice(appointmentInfo.getPrice());
        appointmentInfoShow.setNickName(appointmentInfo.getNickName());
        appointmentInfoShow.setLaunchTime(appointmentInfo.getLaunchTime());
        appointmentInfoShow.setId(appointmentInfo.getId());
        appointmentInfoShow.setGetInvite(appointmentInfo.getGetInvite());
        appointmentInfoShow.setGender(appointmentInfo.getGender());
        appointmentInfoShow.setExplain(appointmentInfo.getExplain());
        appointmentInfoShow.setCameraTime(appointmentInfo.getCameraTime());
        appointmentInfoShow.setCameraArea(appointmentInfo.getCameraArea());
        appointmentInfoShow.setAvatarUrl(IPAddressUtil.getLocalIp()+appointmentInfo.getAvatarUrl());
        appointmentInfoShow.setAccount(appointmentInfo.getAccount());
        appointmentInfoShow.setImgList(AddressTransferUtil.addressTrans(appointmentInfo.getImgList()));
        appointmentInfoShow.setReadNumber(appointmentInfo.getReadNumber());
        return appointmentInfoShow;
    }

    @Override
    public String insertInvitation(AppointmentStatusTransfer statusTransfer) {
        AppointmentStatus appointmentStatus = new AppointmentStatus();
        appointmentStatus.setAppointmentId(statusTransfer.getAppointmentId());
        appointmentStatus.setInviteAccount(statusTransfer.getInviteAccount());
        appointmentStatus.setInvitedAccount(statusTransfer.getInvitedAccount());
        appointmentStatus.setStatus(0);
        appointmentStatusMapper.insert(appointmentStatus);
        return "邀请成功";
    }

    @Override
    public String deleteByAppoIdAndInviteAccount(String account, int appoid) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("appointmentId",appoid);
        params.put("inviteAccount",account);
        int i = appointmentStatusMapper.deleteByAppoIdAndInviteAccount(params);
        if (i>0){
            return "删除成功";
        }else
            return "删除失败";
    }



    @Override
    public List<InvitationShow> selectAppoByCondition(String inviteAccount, String invitedAccount, int status)throws MyException {
        List<InvitationShow> invitationShows=new ArrayList<>();
        HashMap<String, Object> params = new HashMap<>();
        if (inviteAccount==null){
            params.put("invitedAccount",invitedAccount);
            params.put("status",status);
            List<AppointmentStatus> appointmentStatuses = appointmentStatusMapper.slectAppoByCondition(params);
            if (appointmentStatuses.size()==0){
                throw  new MyException("这个栏目下没有邀请信息！！");
            }
            for (AppointmentStatus appointmentStatus : appointmentStatuses) {
                InvitationShow invitationShow = new InvitationShow();
                AppointmentInfo appointmentInfo = appointmentInfoMapper.selectByPrimaryKey(appointmentStatus.getAppointmentId());
                invitationShow.setAppointmentId(appointmentStatus.getAppointmentId());
                invitationShow.setCameraArea(appointmentInfo.getCameraArea());
                invitationShow.setCameraTime(appointmentInfo.getCameraTime());
                invitationShow.setExplain(appointmentInfo.getExplain());
                invitationShow.setImg(AddressTransferUtil.addressTrans(appointmentInfo.getImgList().split(";")[0]).get(0));
                invitationShow.setInviteAccount(appointmentStatus.getInviteAccount());
                invitationShow.setInvitedAccount(appointmentStatus.getInvitedAccount());
                invitationShow.setInvitedPeople(appointmentInfo.getNickName());
                invitationShow.setInvitePeople(userDetailMapper.selectNickNameByAccount(appointmentStatus.getInviteAccount()));
                invitationShows.add(invitationShow);
            }
        }else if (invitedAccount==null){
            params.put("inviteAccount",inviteAccount);
            params.put("status",status);
            List<AppointmentStatus> appointmentStatuses = appointmentStatusMapper.slectAppoByCondition(params);
            if (appointmentStatuses.size()==0){
                throw  new MyException("这个栏目下没有邀请信息！！");
            }
            for (AppointmentStatus appointmentStatus : appointmentStatuses) {
                InvitationShow invitationShow = new InvitationShow();
                AppointmentInfo appointmentInfo = appointmentInfoMapper.selectByPrimaryKey(appointmentStatus.getAppointmentId());
                invitationShow.setAppointmentId(appointmentStatus.getAppointmentId());
                invitationShow.setCameraArea(appointmentInfo.getCameraArea());
                invitationShow.setCameraTime(appointmentInfo.getCameraTime());
                invitationShow.setExplain(appointmentInfo.getExplain());
                invitationShow.setImg(appointmentInfo.getImgList().split(";")[0]);
                invitationShow.setInviteAccount(appointmentStatus.getInviteAccount());
                invitationShow.setInvitedAccount(appointmentStatus.getInvitedAccount());
                invitationShow.setInvitedPeople(appointmentInfo.getNickName());
                invitationShow.setInvitePeople(userDetailMapper.selectNickNameByAccount(appointmentStatus.getInviteAccount()));
                invitationShows.add(invitationShow);
            }
        }
        return  invitationShows;
    }

    @Override
    public String updateStatusByCondition(String inviteAccount, int appoId, int status,int oldstatus) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("inviteAccount",inviteAccount);
        params.put("status",status);
        params.put("appointmentId",appoId);
        params.put("oldstatus",oldstatus);
        int i = appointmentStatusMapper.updateStatusByCondition(params);
        if (i>0){
            return "更新成功";
        }else
            return "更新失败";
    }

    @Override
    public List<AppointmentInfoShow> selectAppointmentByAccount(String account) throws MyException  {
        List<AppointmentInfoShow> appointmentInfoShows=new ArrayList<>();
        List<AppointmentInfo> appointmentInfoList = appointmentInfoMapper.selectByAccount(account);
        for (AppointmentInfo appointmentInfo : appointmentInfoList) {
            AppointmentInfoShow appointmentInfoShow = new AppointmentInfoShow();
            appointmentInfoShow.setAccount(appointmentInfo.getAccount());
            appointmentInfoShow.setAvatarUrl(IPAddressUtil.getLocalIp()+appointmentInfo.getAvatarUrl());
            appointmentInfoShow.setCameraArea(appointmentInfo.getCameraArea());
            appointmentInfoShow.setCameraTime(appointmentInfo.getCameraTime());
            appointmentInfoShow.setExplain(appointmentInfo.getExplain());
            appointmentInfoShow.setGender(appointmentInfo.getGender());
            appointmentInfoShow.setGetInvite(appointmentInfo.getGetInvite());
            appointmentInfoShow.setId(appointmentInfo.getId());
            appointmentInfoShow.setImgList(AddressTransferUtil.addressTrans(appointmentInfo.getImgList()));
            appointmentInfoShow.setLaunchTime(appointmentInfo.getLaunchTime());
            appointmentInfoShow.setNickName(appointmentInfo.getNickName());
            appointmentInfoShow.setPrice(appointmentInfo.getPrice());
            appointmentInfoShow.setReadNumber(appointmentInfo.getReadNumber());
            appointmentInfoShow.setTagList(Arrays.asList(appointmentInfo.getTagList().split(";")));
            appointmentInfoShows.add(appointmentInfoShow);
        }
        if (appointmentInfoShows.size()==0){
            throw  new MyException("关注的人还没有发表约拍呢");
        }
        return appointmentInfoShows;
    }
}
