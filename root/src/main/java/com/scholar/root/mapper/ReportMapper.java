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

@Mapper
@Repository
public interface ReportMapper
{
    List<ArticleReport> getArticleReportByReportID();

    List<GateReport> getGateReportByReportID();

    List<CommentReport> getCommentReportByReportID();

    List<PostReport> getPostReportByReportID();

    Report getReportByReportID(@Param("reportID") int reportID);

    int deleteReportByReportID(@Param("reportID") int reportID);
}