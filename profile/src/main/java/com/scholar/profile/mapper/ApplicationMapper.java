package com.scholar.profile.mapper;

import com.scholar.profile.pojo.Application;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ApplicationMapper {

    int addApplication(Application application);

    /**
     * 获取用户是否有未被处理的认证
     */
    Application getUserPendingApplication(String userID);

    Application getUserRecentApplication(String userID);
}
