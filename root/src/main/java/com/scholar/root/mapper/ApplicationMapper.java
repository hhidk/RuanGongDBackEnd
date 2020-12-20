package com.scholar.root.mapper;

import com.scholar.root.pojo.Application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ApplicationMapper
{

    Application getApplicationByApplicationID(@Param("applicationID") int applicationID);

}
