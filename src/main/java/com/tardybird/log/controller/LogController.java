package com.tardybird.log.controller;

import com.tardybird.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nick
 */
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping("/")
    public Object getAllAds() {
        return logService.getAllAds();
    }
}
