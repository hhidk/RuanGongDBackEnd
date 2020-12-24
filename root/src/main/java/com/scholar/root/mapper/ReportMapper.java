package com.scholar.root.mapper;

import com.scholar.root.dto.ArticleReport;
import com.scholar.root.dto.CommentReport;
import com.scholar.root.dto.GateReport;
import com.scholar.root.dto.PostReport;
import com.scholar.root.pojo.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ReportMapper
{
    List<ArticleReport> getArticleReport();

    List<GateReport> getGateReport();

    List<CommentReport> getCommentReport();

    List<PostReport> getPostReport();

    Report getReportByReportID(@Param("reportID") int reportID);

    int deleteReportByReportID(@Param("reportID") int reportID);

    int setReportStatus(@Param("reportID") int reportID);
}