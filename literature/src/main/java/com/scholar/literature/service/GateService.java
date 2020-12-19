package com.scholar.literature.service;

import com.scholar.literature.mapper.UserMapper;
import com.scholar.literature.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GateService {

    @Autowired
    private UserMapper userMapper;

    public User getAuthorInformation(String authorID) throws Exception {
        User user = userMapper.getUserByAuthorID();
        if (user == null) {
            // todo: 在author表中查找authorID对应的author，并把信息填入User类。

        }
        return user;
    }

}
