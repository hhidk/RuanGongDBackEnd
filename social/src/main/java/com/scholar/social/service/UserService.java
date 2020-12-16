package com.scholar.social.service;

import com.scholar.social.repository.UserRepository;
import com.scholar.social.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(String userId) {
        return userRepository.get(userId);
    }
}
