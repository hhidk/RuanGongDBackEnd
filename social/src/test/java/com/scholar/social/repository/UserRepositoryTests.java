package com.scholar.social.repository;

import com.scholar.social.util.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void testGet() {
        User user = userRepository.get("9474EA29");
        Assert.isTrue(user.getId().equals("9474EA29"), "Wrong Id");
        Assert.isTrue(user.getName().equals("荣誉骑士何何"), "Wrong Name");
        Assert.isTrue(user.getAvatar()
                        .equals("https://upload-bbs.mihoyo.com/upload/2020/11/16/82642572/027bf2e694c3303ee19312db6206c3d9_7402678593973153680.jpg?x-oss-process=image/resize,s_600/quality,q_80/auto-orient,0/interlace,1/format,jpg"),
                "Wrong Avatar");
    }
}
