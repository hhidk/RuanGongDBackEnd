package com.scholar.profile.service;

import com.scholar.profile.mapper.ApplicationMapper;
import com.scholar.profile.mapper.UserMapper;
import com.scholar.profile.pojo.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GateService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ApplicationMapper applicationMapper;

    public int followUser(String followerID, String userID, int option) {
        if (option == 1) {
            userMapper.addFollow(followerID, userID);
        } else {
            userMapper.deleteFollow(followerID, userID);
        }
        return 0;
    }

    public int apply(String userID, String authorID, String emailAddress, String content) {
        if (userMapper.checkIsAuthor(userID) != null) {
            return 2;
        }
        if (applicationMapper.getUserPendingApplication(userID) != null) {
            return 1;
        }
        Application application = new Application(userID, authorID, emailAddress, content);
        applicationMapper.addApplication(application);
        return 0;
    }

}
