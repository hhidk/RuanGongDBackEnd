package com.scholar.social.service;

import com.scholar.social.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private static final Logger log = LoggerFactory.getLogger(MessageService.class);
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public boolean put(String senderId, String receiverId, String content) {
        log.debug("s: {}, r: {}, content: {}", senderId, receiverId, content);
        messageRepository.put(senderId, receiverId, content);
        return true;
    }
}
