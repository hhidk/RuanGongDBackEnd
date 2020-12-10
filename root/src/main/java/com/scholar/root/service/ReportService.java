package com.scholar.root.service;

import com.scholar.root.dto.ArticleReport;
import com.scholar.root.dto.CommentReport;
import com.scholar.root.dto.GateReport;
import com.scholar.root.dto.PostReport;
import com.scholar.root.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService
{

    @Autowired
    private ReportMapper reportMapper;

    public List<ArticleReport> getArticleReports(String reportID) throws Exception {
        List<ArticleReport> list = reportMapper.getArticleReportByReportID(reportID);
        for (ArticleReport articleReport : list)
        {
            if (articleReport.getReportContent().length() > 86)
            {
                articleReport.setTrimmed(true);
                articleReport.setTrimmedContent(articleReport.getReportContent().substring(0, 85) + "...");
            }
        }
        return list;
    }

    public List<GateReport> getGateReports(String reportID) throws Exception {
        List<GateReport> list = reportMapper.getGateReportByReportID(reportID);
        for (GateReport gateReport : list)
        {
            if (gateReport.getReportContent().length() > 86)
            {
                gateReport.setTrimmed(true);
                gateReport.setTrimmedContent(gateReport.getReportContent().substring(0, 85) + "...");
            }
        }
        return list;
    }

    public List<CommentReport> getCommentReports(String reportID) throws Exception {
        List<CommentReport> list = reportMapper.getCommentReportByReportID(reportID);
        for (CommentReport commentReport : list)
        {
            if (commentReport.getReportContent().length() > 86)
            {
                commentReport.setTrimmed(true);
                commentReport.setTrimmedContent(commentReport.getReportContent().substring(0, 85) + "...");
            }
        }
        return list;
    }

    public List<PostReport> getPostReports(String reportID) throws Exception {
        List<PostReport> list = reportMapper.getPostReportByReportID(reportID);
        for (PostReport postReport : list)
        {
            if (postReport.getReportContent().length() > 86)
            {
                postReport.setTrimmed(true);
                postReport.setTrimmedContent(postReport.getReportContent().substring(0, 85) + "...");
            }
        }
        return list;
    }

}
