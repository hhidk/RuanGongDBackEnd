package com.scholar.profile.service;

import com.scholar.profile.dto.UserPreview;
import com.scholar.profile.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSpaceService {

    @Autowired
    private UserMapper userMapper;

    public UserPreview getUserInformation(String userID) throws Exception {
        return userMapper.getUserPreviewByUserID(userID);
    }

    public List<UserPreview> getFollowingList(String userID) throws Exception {
        return userMapper.getFollowUsers(userID);
    }

    public List<UserPreview> getFollowersList(String userID) throws Exception {
        return userMapper.getFollowers(userID);
    }

}
