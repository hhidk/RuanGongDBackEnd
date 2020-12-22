package com.scholar.root.service;

import com.scholar.root.dto.ArticleReport;
import com.scholar.root.dto.CommentReport;
import com.scholar.root.dto.GateReport;
import com.scholar.root.dto.PostReport;
import com.scholar.root.mapper.*;
import com.scholar.root.pojo.Message;
import com.scholar.root.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService
{

    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;



    public List<ArticleReport> getArticleReports() throws Exception {
        List<ArticleReport> list = reportMapper.getArticleReportByReportID();
        for (ArticleReport articleReport : list)
        {
            if (articleReport.getReportContent().length() > 57)
            {
                articleReport.setTrimmed(true);
                articleReport.setTrimmedContent(articleReport.getReportContent().substring(0, 55) + "...");
            }
        }
        return list;
    }

    public List<GateReport> getGateReports() throws Exception {
        List<GateReport> list = reportMapper.getGateReportByReportID();
        for (GateReport gateReport : list)
        {
            if (gateReport.getReportContent().length() > 57)
            {
                gateReport.setTrimmed(true);
                gateReport.setTrimmedContent(gateReport.getReportContent().substring(0, 55) + "...");
            }
        }
        return list;
    }

    public List<CommentReport> getCommentReports() throws Exception {
        List<CommentReport> list = reportMapper.getCommentReportByReportID();
        for (CommentReport commentReport : list)
        {

            commentReport.setCommentID(Integer.parseInt(commentReport.getStrCommentID()));

            if (commentReport.getReportContent().length() > 57)
            {
                commentReport.setTrimmed(true);
                commentReport.setTrimmedContent(commentReport.getReportContent().substring(0, 55) + "...");
            }
        }
        return list;
    }

    public List<PostReport> getPostReports() throws Exception {
        List<PostReport> list = reportMapper.getPostReportByReportID();
        for (PostReport postReport : list)
        {

            postReport.setPostID(Integer.parseInt(postReport.getStrPostID()));

            if (postReport.getReportContent().length() > 57)
            {
                postReport.setTrimmed(true);
                postReport.setTrimmedContent(postReport.getReportContent().substring(0, 55) + "...");
            }
        }
        return list;
    }

    public int approveReport(int reportID) throws Exception {

        int ret = 1;
        Report report = reportMapper.getReportByReportID(reportID);
        Message message = new Message();

        switch (report.getType()) {

            case 1:

                message.setSenderID(report.getReporterID());
                message.setReceiverID(report.getReporterID());
                message.setViewed(false);
                message.setContent(report.getTitle());
                message.setType(4);
                message.setCommentID(0);
                ret = ret & messageMapper.addMessage(message);

                //TODO: 看情况决定是否给作者发消息

                break;

            case 2:

                //删除评论
                commentMapper.deleteCommentByCommentID(Integer.parseInt(report.getReporteeID()));

                //给举报者发消息
                message.setSenderID(report.getReporterID());
                message.setReceiverID(report.getReporterID());
                message.setViewed(false);
                message.setContent(report.getTitle());
                message.setType(4);
                message.setCommentID(0);
                ret = ret & messageMapper.addMessage(message);

                //给被举报者发消息
                message.setSenderID(report.getReporteeID());
                message.setReceiverID(report.getReporteeID());
                message.setViewed(false);
                message.setContent(report.getTitle());
                message.setType(8);
                message.setCommentID(0);
                ret = ret & messageMapper.addMessage(message);

                break;

            case 3:

                //删除动态
                postMapper.deletePostByPostID(Integer.parseInt(report.getReporteeID()));

                //给举报者发消息
                message.setSenderID(report.getReporterID());
                message.setReceiverID(report.getReporterID());
                message.setViewed(false);
                message.setContent(report.getTitle());
                message.setType(4);
                message.setCommentID(0);
                ret = ret & messageMapper.addMessage(message);

                //给被举报者发消息
                message.setSenderID(report.getReporteeID());
                message.setReceiverID(report.getReporteeID());
                message.setViewed(false);
                message.setContent(report.getTitle());
                message.setType(9);
                message.setCommentID(0);
                ret = ret & messageMapper.addMessage(message);

                break;

            case 4:

                //把被举报用户变成普通用户
                userMapper.setNormalUser(report.getReporteeID());

                //给举报者发消息
                message.setSenderID(report.getReporterID());
                message.setReceiverID(report.getReporterID());
                message.setViewed(false);
                message.setContent(report.getContent());
                message.setType(4);
                message.setCommentID(0);
                ret = ret & messageMapper.addMessage(message);

                //给被举报者发消息
                message.setSenderID(report.getReporteeID());
                message.setReceiverID(report.getReporteeID());
                message.setViewed(false);
                message.setContent(report.getContent());
                message.setType(10);
                message.setCommentID(0);
                ret = ret & messageMapper.addMessage(message);
                break;

            default:
                throw new Exception("举报类型错误");

        }

        reportMapper.setReportStatus(reportID);

        return ret;

    }

    public int rejectReport(int reportID, String msgContent) throws Exception {

        int ret = 1;

        Report report = reportMapper.getReportByReportID(reportID);
        Message message = new Message();

        message.setSenderID(report.getReporterID());
        message.setReceiverID(report.getReporterID());
        message.setViewed(false);
        message.setContent(msgContent);
        message.setType(5);
        message.setCommentID(0);
        ret = ret & messageMapper.addMessage(message);

        reportMapper.setReportStatus(reportID);

        return ret;

    }

    public int deleteReport(int reportID) throws Exception {
        return reportMapper.deleteReportByReportID(reportID);
    }

}
