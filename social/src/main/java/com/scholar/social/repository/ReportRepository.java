package com.scholar.social.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReportRepository {
    // TODO add title
    void report(@Param("type") int type, @Param("content") String content,
                @Param("targetId") String targetId, @Param("reportId") String reporterId);
}
