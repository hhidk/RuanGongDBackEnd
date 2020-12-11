package com.scholar.social.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * for sector get
 */
@RestController
public class SectorController {
    @RequestMapping(value = "/getAllSectors",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> get() {
        // TODO call service
        return null;
    }

    @RequestMapping(value = "/getAllTags",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> getInfo() {
        // TODO call service
        return null;
    }
}
