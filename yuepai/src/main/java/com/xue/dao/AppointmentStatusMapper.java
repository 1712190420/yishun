package com.xue.dao;

import com.xue.pojo.po.AppointmentStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface AppointmentStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppointmentStatus record);

    AppointmentStatus selectByPrimaryKey(Integer id);

    List<AppointmentStatus> selectAll();

    int updateByPrimaryKey(AppointmentStatus record);

    int deleteByAppoIdAndInviteAccount(Map<String,Object> map);

    List<AppointmentStatus>  slectAppoByCondition(Map<String,Object> map);

    int updateStatusByCondition(Map<String,Object> map);

}