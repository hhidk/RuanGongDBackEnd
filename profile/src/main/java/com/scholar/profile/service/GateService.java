package com.scholar.profile.service;

import com.scholar.profile.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GateService {

    @Autowired
    private UserMapper userMapper;


}
