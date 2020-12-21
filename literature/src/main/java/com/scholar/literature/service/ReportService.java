package com.scholar.literature.service;

import com.scholar.literature.mapper.ReportMapper;
import com.scholar.literature.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportMapper reportMapper;

    public int reportLiterature(String userID, String literatureID, String title, String content) throws Exception {
        Report report = new Report(userID, literatureID, title, content);
        reportMapper.addReport(report);
        return 0;
    }

}
