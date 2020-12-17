package com.scholar.social.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReportRepository {
    void report(int type, String content, String targetId, String reporterId);
}
