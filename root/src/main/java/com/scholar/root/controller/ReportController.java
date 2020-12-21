package com.scholar.root.controller;

import com.scholar.root.dto.ArticleReport;
import com.scholar.root.dto.CommentReport;
import com.scholar.root.dto.GateReport;
import com.scholar.root.dto.PostReport;
import com.scholar.root.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReportController
{
    @Autowired
    private ReportService reportService;

    @PostMapping("/getArticleReports")
    public List<ArticleReport> getArticleReports(@RequestParam("reportID") int reportID) {
        try {
            return reportService.getArticleReports(reportID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/getGateReports")
    public List<GateReport> getGateReports(@RequestParam("reportID") int reportID) {
        try {
            return reportService.getGateReports(reportID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/getCommentReports")
    public List<CommentReport> getCommentReports(@RequestParam("reportID") int reportID) {
        try {
            return reportService.getCommentReports(reportID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/getPostReports")
    public List<PostReport> getPostReports(@RequestParam("reportID") int reportID) {
        try {
            return reportService.getPostReports(reportID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/approveReport")
    public int approveReport(@RequestParam("reportID") int reportID) {
        try {
            return reportService.approveReport(reportID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return 0;
        }
    }

    @PostMapping("/rejectReport")
    public int rejectReport(@RequestParam("reportID") int reportID, @RequestParam("msgContent") String msgContent) {
        try {
            return reportService.rejectReport(reportID, msgContent);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return 0;
        }
    }

    @PostMapping("/deleteReport")
    public int deleteReport(@RequestParam("reportID") int reportID) {
        try {
            return reportService.deleteReport(reportID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return 0;
        }
    }

}
