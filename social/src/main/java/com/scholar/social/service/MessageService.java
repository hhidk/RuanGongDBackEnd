package com.scholar.social.service;

import com.scholar.social.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public boolean put(String senderId, String receiverId, String content) {
        messageRepository.put(senderId, receiverId, content);
        return true;
    }
}
