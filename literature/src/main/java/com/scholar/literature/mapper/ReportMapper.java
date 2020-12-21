package com.scholar.literature.mapper;

import com.scholar.literature.pojo.Report;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReportMapper {

    int addReport(Report report);

}
