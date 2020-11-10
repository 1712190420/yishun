package com.xue.service;

import com.xue.exception.MyException;
import com.xue.pojo.po.FocusUser;
import com.xue.pojo.po.UserDetail;
import com.xue.pojo.dto.UserDetailTransfer;
import com.xue.pojo.vo.FocusPeople;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface UserService {
    UserDetail selectUserByAccount(String account);
    String updateUserByAccount(MultipartFile file, HttpServletRequest request, UserDetailTransfer userDetailTransfer)throws IOException;
    List<FocusPeople> selectFocusList(String account)throws MyException;
    int getFocusNum(String account);
    String followUser(String account,String focusAccount);
    String unfollowUser(String account,String focusAccount);
}
