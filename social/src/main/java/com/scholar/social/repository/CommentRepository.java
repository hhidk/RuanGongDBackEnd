package com.scholar.social.repository;

import com.scholar.social.util.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentRepository {
    void insert(@Param("userId") String userId, @Param("postId") String postId,
                @Param("content") String content);

    void delete(@Param("userId") String userId, @Param("commentId") int commentId);

    Comment select(@Param("commentId") int commentId);

    List<Comment> selectByPostId(@Param("postId") String postId);

    void deleteByPostId(@Param("postId") String postId);
}
