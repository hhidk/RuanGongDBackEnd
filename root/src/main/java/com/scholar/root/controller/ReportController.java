package com.scholar.root.controller;

import com.scholar.root.dto.ArticleReport;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReportController
{

    @PostMapping("/getArticleReports")
    public List<ArticleReport> getArticleReports(@RequestParam("reportID") String reportID) {
        return new ArrayList<>();
    }
}
