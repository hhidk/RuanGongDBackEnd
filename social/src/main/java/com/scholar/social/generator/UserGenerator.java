package com.scholar.social.generator;

import com.scholar.social.util.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserGenerator {
    public static Map<String, Object> userInfo(User user, String prefix) {
        Map<String, Object> res = new HashMap<>();
        res.put(prefix + "Id", user.getId());
        res.put(prefix + "Avatar", user.getAvatar());
        res.put(prefix + "Name", user.getName());
        return res;
    }
}
