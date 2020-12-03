package com.scholar.profile.service;

import com.scholar.profile.mapper.UserMapper;
import com.scholar.profile.pojo.User;
import com.scholar.profile.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private UserMapper userMapper;

    public int register(String username, String password) throws Exception {
        String userID = UserUtil.generateUserID();
        User user = new User(userID, username, password);
        userMapper.addUser(user);
        return 0;
    }

}
