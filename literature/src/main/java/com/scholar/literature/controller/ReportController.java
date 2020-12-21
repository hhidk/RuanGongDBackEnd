package com.scholar.literature.controller;

import com.scholar.literature.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/reportLiterature")
    public int reportLiterature(@RequestParam("userID") String userID, @RequestParam("literatureID") String literatureID,
                                @RequestParam("title") String title, @RequestParam("content") String content) {
        try {
            return reportService.reportLiterature(userID, literatureID, title, content);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
