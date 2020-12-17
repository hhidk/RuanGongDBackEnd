package com.scholar.social.repository;

import com.scholar.social.util.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostRepository {
    int put(Post post);

    Post get(@Param("postId") int postId);

    void putTags(@Param("postId") int postId, @Param("tags") String tags);

    String getTags(@Param("postId") int postId);

    void delete(@Param("postId") int postId);

    void updateTimes(@Param("postId") int postId);

    List<Post> search(@Param("sectorId") int sectorId, @Param("keyword") String keyword);
}
