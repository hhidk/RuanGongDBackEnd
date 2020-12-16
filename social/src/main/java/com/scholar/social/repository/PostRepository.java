package com.scholar.social.repository;

import com.scholar.social.util.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PostRepository {
    // TODO INSERT post and return Pk
    int put(Post post);

    // TODO SELECT post
    Post get(int postId);

    // TODO DELETE post
    void delete(int postId);

    // TODO UPDATE view times
    void updateTimes(int postId);
}
