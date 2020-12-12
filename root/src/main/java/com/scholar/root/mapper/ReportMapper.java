package com.scholar.root.mapper;

import com.scholar.root.dto.ArticleReport;
import com.scholar.root.dto.CommentReport;
import com.scholar.root.dto.GateReport;
import com.scholar.root.dto.PostReport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ReportMapper
{
    List<ArticleReport> getArticleReportByReportID(@Param("reportID") String reportID);

    List<GateReport> getGateReportByReportID(@Param("reportID") String reportID);

    List<CommentReport> getCommentReportByReportID(@Param("reportID") String reportID);

    List<PostReport> getPostReportByReportID(@Param("reportID") String reportID);
}
4GC891vxMVIro01mGa