package com.scholar.social.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FollowRepository {
    int get(@Param("userId") String userId, @Param("sectorId") int sectorId);

    void set(@Param("userId") String userId, @Param("sectorId") int sectorId);

    void unset(@Param("userId") String userId, @Param("sectorId") int sectorId);
}
