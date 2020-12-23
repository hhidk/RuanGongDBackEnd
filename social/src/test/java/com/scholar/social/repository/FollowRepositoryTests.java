package com.scholar.social.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class FollowRepositoryTests {
    @Autowired
    private FollowRepository followRepository;

    @Test
    void testModify() {
        int cnt = followRepository.get("5A68DDC7", 1);
        Assert.isTrue(cnt == 0, "failed");
        followRepository.set("5A68DDC7", 1);
        cnt = followRepository.get("5A68DDC7", 1);
        Assert.isTrue(cnt == 1, "failed");
        followRepository.unset("5A68DDC7", 1);
        cnt = followRepository.get("5A68DDC7", 1);
        Assert.isTrue(cnt == 0, "failed");
    }
}
