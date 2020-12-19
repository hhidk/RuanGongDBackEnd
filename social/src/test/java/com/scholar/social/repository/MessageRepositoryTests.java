package com.scholar.social.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageRepositoryTests {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    void testPut() {
        messageRepository.put("9474EA29", "5A68DDC7", "hhhh");
    }
}
