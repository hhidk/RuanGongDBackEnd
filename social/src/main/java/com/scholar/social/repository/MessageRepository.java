package com.scholar.social.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MessageRepository {
    void put(@Param("senderId") String senderId, @Param("receiverId") String receiverId,
             @Param("content") String content);
}
