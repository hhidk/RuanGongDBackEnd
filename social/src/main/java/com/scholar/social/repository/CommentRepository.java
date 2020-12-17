package com.scholar.social.repository;

import com.scholar.social.util.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentRepository {
    void insert(String userId, int postId, String content);

    void delete(String userId, int commentId);

    List<Comment> selectByPostId(int postId);

    void deleteByPostId(int postId);
}
