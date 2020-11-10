package com.xue.service.Impl;

import com.xue.dao.AppointmentStatusMapper;
import com.xue.dao.FocusUserMapper;
import com.xue.dao.UserDetailMapper;
import com.xue.exception.MyException;
import com.xue.pojo.po.FocusUser;
import com.xue.pojo.po.UserDetail;
import com.xue.pojo.dto.UserDetailTransfer;
import com.xue.pojo.vo.FocusPeople;
import com.xue.service.UserService;
import com.xue.utils.IPAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDetailMapper userDetailMapper;
    @Autowired
    AppointmentStatusMapper appointmentStatusMapper;
    @Autowired
    FocusUserMapper focusUserMapper;

    @Override
    public UserDetail selectUserByAccount(String account) {
        UserDetail userDetail = userDetailMapper.selectByPrimaryKey(account);
        String avatarUrl = userDetail.getAvatarUrl();
        avatarUrl=IPAddressUtil.getLocalIp()+avatarUrl;
        userDetail.setAvatarUrl(avatarUrl);
        return userDetail;
    }

    @Override
    public String updateUserByAccount(MultipartFile file, HttpServletRequest request, UserDetailTransfer userDetailTransfer)throws IOException {
        UserDetail userDetail = new UserDetail();
        UserDetail userDetail1 = userDetailMapper.selectByPrimaryKey(userDetailTransfer.getAccount());
        if (userDetail1==null){
            return "没有此用户";
        }
        String uploadFileName=file.getOriginalFilename();
        if ("".equals(uploadFileName)){
            return "上传的图片文件名不能为空";
        }
        String suffix=uploadFileName.substring(uploadFileName.length()-3,uploadFileName.length());
        if(suffix.equals("jpg")||suffix.equals("png")){
            System.out.println("上传的文件名"+uploadFileName);
            String path = "/home/projects/yuepai/file";
            //如果路径不存在，创建一个
            File realPath = new File(path);
            if (!realPath.exists()) {
                boolean b = realPath.mkdir();
                System.out.println("b"+b);
            }
            System.out.println("上传文件保存地址：" + realPath);
            System.out.println("标记");
            InputStream is = file.getInputStream();
            //文件输入流
            System.out.println("标记--");
            OutputStream os = new FileOutputStream(new File(realPath, uploadFileName)); //文件输出流
            System.out.println("标记1");
            //读取写出
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
                os.flush();
            }
            os.close();
            is.close();
            String pictureurl="file/"+uploadFileName;
            userDetail.setAccount(userDetailTransfer.getAccount());
            userDetail.setAge(userDetailTransfer.getAge());
            userDetail.setArea(userDetailTransfer.getArea());
            userDetail.setAuth(userDetailTransfer.getAuth());
            userDetail.setAvatarUrl(pictureurl);
            userDetail.setBirthday(userDetailTransfer.getBirthday());
            userDetail.setCity(userDetailTransfer.getCity());
            userDetail.setGender(userDetailTransfer.getGender());
            userDetail.setHeight(userDetailTransfer.getHeight());
            userDetail.setHobby(userDetailTransfer.getHobby());
            userDetail.setNickName(userDetailTransfer.getNickName());
            userDetail.setPhonenumber(userDetailTransfer.getPhonenumber());
            userDetail.setProvince(userDetailTransfer.getProvince());
            userDetail.setWeight(userDetailTransfer.getWeight());
            userDetailMapper.updateByPrimaryKey(userDetail);
            return "更新成功";
        }else {
            userDetail.setAccount(userDetailTransfer.getAccount());
            userDetail.setAge(userDetailTransfer.getAge());
            userDetail.setArea(userDetailTransfer.getArea());
            userDetail.setAuth(userDetailTransfer.getAuth());
            userDetail.setAvatarUrl(userDetail1.getAvatarUrl());
            userDetail.setBirthday(userDetailTransfer.getBirthday());
            userDetail.setCity(userDetailTransfer.getCity());
            userDetail.setGender(userDetailTransfer.getGender());
            userDetail.setHeight(userDetailTransfer.getHeight());
            userDetail.setHobby(userDetailTransfer.getHobby());
            userDetail.setNickName(userDetailTransfer.getNickName());
            userDetail.setPhonenumber(userDetailTransfer.getPhonenumber());
            userDetail.setProvince(userDetailTransfer.getProvince());
            userDetail.setWeight(userDetailTransfer.getWeight());
            userDetailMapper.updateByPrimaryKey(userDetail);
            return "更新成功";
        }
    }

    @Override
    public List<FocusPeople> selectFocusList(String account)throws MyException{
        List<FocusPeople> focusPeopleList = new ArrayList<>();
        List<String> accounts = focusUserMapper.selectFocus(account);
        if (accounts.size()==0){
            throw new MyException("你还没有关注的人！！");
        }
        for (String acc : accounts) {
            FocusPeople focusPeople = new FocusPeople();
            UserDetail userDetail = userDetailMapper.selectByPrimaryKey(acc);
            focusPeople.setAccount(userDetail.getAccount());
            focusPeople.setAvatarUrl(IPAddressUtil.getLocalIp()+userDetail.getAvatarUrl());
            focusPeople.setGender(userDetail.getGender());
            focusPeople.setNickName(userDetail.getNickName());
            focusPeopleList.add(focusPeople);
        }
        return focusPeopleList;
    }

    @Override
    public int getFocusNum(String account) {
        return focusUserMapper.selectFansNum(account);
    }

    @Override
    public String followUser(String account,String focusAccount) {
        FocusUser focusUser = new FocusUser();
        focusUser.setAccount(account);
        focusUser.setFocusAccount(focusAccount);
        int i = focusUserMapper.insert(focusUser);
        if (i>0){
            return "关注成功";
        }else
            return "关注失败";
    }

    @Override
    public String unfollowUser(String account, String focusAccount) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("account",account);
        params.put("focusAccount",focusAccount);
        int i = focusUserMapper.unfollowUser(params);
        if (i>0){
            return "取消关注成功";
        }else
            return "取消关注失败";
    }

}
