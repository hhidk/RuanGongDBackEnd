package com.scholar.social.repository;

import com.scholar.social.util.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentRepository {
    void insert(@Param("userId") String userId, @Param("postId") int postId,
                @Param("content") String content);

    void delete(@Param("userId") String userId, @Param("commentId") int commentId);

    List<Comment> selectByPostId(@Param("postId") int postId);

    void deleteByPostId(@Param("postId") int postId);
}
