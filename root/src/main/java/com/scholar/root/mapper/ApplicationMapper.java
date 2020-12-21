package com.scholar.root.mapper;

import com.scholar.root.dto.GateApplication;
import com.scholar.root.pojo.Application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ApplicationMapper
{

    Application getApplicationByApplicationID(@Param("applicationID") int applicationID);

    int setApplicationStatus(Map<String, Object> map);

    List<GateApplication> getAllGateApplication();

}
