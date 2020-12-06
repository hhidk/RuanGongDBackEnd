package com.scholar.profile.service;

import com.scholar.profile.dto.UserPreview;
import com.scholar.profile.mapper.UserMapper;
import com.scholar.profile.pojo.User;
import com.scholar.profile.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private UserMapper userMapper;

    public int register(String username, String password, String password2) throws Exception {
        if(userMapper.checkUserName(username)!=null)
            return 1;
        if(!password.equals(password2))
            return 2;
        if(!password.matches("^(?!\\d*$|[a-z]*$|[A-Z]*$|\\W*$)[!-~]{6,18}$"))
            return 3;
        String userID = UserUtil.generateUserID();
        User user = new User(userID, username, password);
        userMapper.addUser(user);
        return 0;
    }

    public UserPreview login(String ID, String password) throws Exception {
        return userMapper.loginUser(ID);
    }

    public int editProfile(String userID, String username, String realName, String image, int userDegree,
                           String emailAddress, String phoneNumber, String organization) throws Exception {
        User user = userMapper.getUserByUserID(userID);
        if (userMapper.checkUserName(username) != null) {
            return 1;
        }
        user.setUsername(username);
        user.setRealName(realName);
        user.setImage(image);
        user.setUserDegree(userDegree);
        user.setEmailAddress(emailAddress);
        user.setPhoneNumber(phoneNumber);
        user.setOrganization(organization);
        userMapper.updateUser(user);
        return 0;
    }

}
