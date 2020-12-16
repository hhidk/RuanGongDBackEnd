package com.scholar.root.mapper;

import com.scholar.root.dto.ArticleReport;
import com.scholar.root.dto.CommentReport;
import com.scholar.root.dto.GateReport;
import com.scholar.root.dto.PostReport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportMapper
{
    List<ArticleReport> getArticleReportByReportID(@Param("reportID") int reportID);

    List<GateReport> getGateReportByReportID(@Param("reportID") int reportID);

    List<CommentReport> getCommentReportByReportID(@Param("reportID") int reportID);

    List<PostReport> getPostReportByReportID(@Param("reportID") int reportID);
}