package com.scholar.root.controller;

import com.scholar.root.dto.GateApplication;
import com.scholar.root.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ApplicationController
{

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/approveApplication")
    public int approveApplication(@RequestParam("applicationID") int applicationID) {
        try {
            return applicationService.approveApplication(applicationID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return 0;
        }
    }

    @PostMapping("/rejectApplication")
    public int rejectApplication(@RequestParam("applicationID") int applicationID) {
        try {
            return applicationService.rejectApplication(applicationID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return 0;
        }
    }

    @PostMapping("/getAllGateApplication")
    public List<GateApplication> getAllGateApplication() {
        try {
            return applicationService.getAllGateApplication();
        }
        catch (Exception e)  {
            e.printStackTrace();
            return null;
        }
    }

}
