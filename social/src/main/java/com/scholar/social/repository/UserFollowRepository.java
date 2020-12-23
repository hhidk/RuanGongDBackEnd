package com.scholar.social.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserFollowRepository {
    List<String> getFollowing(@Param("userId") String userId);
}
