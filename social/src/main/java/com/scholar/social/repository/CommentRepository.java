package com.scholar.social.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommentRepository {
    void insert(String userId, int postId, String content);

    void delete(String userId, int commentId);
}
