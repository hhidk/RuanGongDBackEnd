package com.scholar.social.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class UserFollowRepositoryTests {
    @Autowired
    private UserFollowRepository userFollowRepository;

    @Test
    void testGetFollowing() {
        List<String> userIdList = userFollowRepository.getFollowing("9474EA29");
        Assert.isTrue(userIdList.size() == 1, "Wrong number");
        Assert.isTrue(userIdList.get(0).equals("5A68DDC7"), "Get failed");
    }
}
