package com.scholar.social.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FollowRepository {
    int get(String userId, int sectorId);

    void set(String userId, int sectorId);

    void unset(String userId, int sectorId);
}
