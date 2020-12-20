package com.scholar.social.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReportRepository {
    void report(@Param("type") int type, @Param("content") String content,
                @Param("targetId") String targetId, @Param("reporterId") String reporterId,
                @Param("title") String title);
}
