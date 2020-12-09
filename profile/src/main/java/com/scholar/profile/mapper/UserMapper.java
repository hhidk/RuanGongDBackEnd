package com.scholar.profile.mapper;

import com.scholar.profile.dto.UserPreview;
import com.scholar.profile.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /*
    * 修改User信息
    */
    int updateUser(User user);

    /*
     * 获取用户关注列表
     */
    List<UserPreview> getFollowUsers(String userID);

    /*
     * 获取用户粉丝列表
     */
    List<UserPreview> getFollowers(String userID);

    /**
     * 添加关注信息
     */
    int addFollow(String followerID, String userID);

    /**
     * 删除关注信息
     */
    int deleteFollow(String followerID, String userID);


}
