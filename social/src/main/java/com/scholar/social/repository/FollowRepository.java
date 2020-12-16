package com.scholar.social.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FollowRepository {
    // TODO return the COUNT(*) in SELECT
    int get(String userId, int sectorId);

    // TODO INSERT
    void set(String userId, int sectorId);

    // TODO DELETE
    void unset(String userId, int sectorId);
}
