package com.scholar.root.service;

import com.scholar.root.dto.ArticleReport;
import com.scholar.root.dto.CommentReport;
import com.scholar.root.dto.GateReport;
import com.scholar.root.dto.PostReport;
import com.scholar.root.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService
{

    @Autowired
    private ReportMapper reportMapper;

    public List<ArticleReport> getArticleReports(int reportID) throws Exception {
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

    public List<GateReport> getGateReports(int reportID) throws Exception {
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

    public List<CommentReport> getCommentReports(int reportID) throws Exception {
        List<CommentReport> list = reportMapper.getCommentReportByReportID(reportID);
        for (CommentReport commentReport : list)
        {

            commentReport.setCommentID(Integer.parseInt(commentReport.getStrCommentID()));

            if (commentReport.getReportContent().length() > 86)
            {
                commentReport.setTrimmed(true);
                commentReport.setTrimmedContent(commentReport.getReportContent().substring(0, 85) + "...");
            }
        }
        return list;
    }

    public List<PostReport> getPostReports(int reportID) throws Exception {
        List<PostReport> list = reportMapper.getPostReportByReportID(reportID);
        for (PostReport postReport : list)
        {

            postReport.setPostID(Integer.parseInt(postReport.getStrPostID()));

            if (postReport.getReportContent().length() > 86)
            {
                postReport.setTrimmed(true);
                postReport.setTrimmedContent(postReport.getReportContent().substring(0, 85) + "...");
            }
        }
        return list;
    }

}
