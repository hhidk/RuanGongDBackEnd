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
    UserPreview loginUser(String ID, String password);

    /*
    * 检查是否有重复用户名
    */
    String checkUserName(String username);

    /*
     * 检查是否有重复邮箱
     */
    String checkEmailAddress(String emailAddress);

    /*
    * 通过userID获取User信息
    */
    User getUserByUserID(String userID);

    /*
     * 通过userID获取UserPreview信息
     */
    UserPreview getUserPreviewByUserID(String userID);

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

    /**
     * 查看用户是否已认证
     */
    String checkIsAuthor(String userID);

    /**
     * 查看门户是否已被认领
     */
    String checkIsUser(String authorID);

    String checkIsFollowed(String followerID, String userID);

}
