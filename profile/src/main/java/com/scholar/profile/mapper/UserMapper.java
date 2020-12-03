package com.scholar.profile.mapper;

import com.scholar.profile.dto.UserPreview;
import com.scholar.profile.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    /*
    * 添加普通用户
    * 注册
    */
    int addUser(User user);

    /*
     * 通过userID/username/emailAddress获得UserPreview信息
     * 用户登录
     */
    UserPreview loginUser(String ID);

    /*
    * 检查是否有重复用户名
    */
    String checkUserName(String username);

    /*
    * 通过userID获取User信息
    */
    User getUserByUserID(String userID);


}
