package com.scholar.profile.mapper;

import com.scholar.profile.pojo.Report;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReportMapper {

    int addReport(Report report);

}
