package com.tardybird.log.controller;

import com.tardybird.log.entity.Ad;
import com.tardybird.log.entity.Log;
import com.tardybird.log.service.impl.LogServiceImpl;
import com.tardybird.log.util.ResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nick
 */
@RestController
public class LogController {

    final
    LogServiceImpl logService;

    public LogController(LogServiceImpl logService) {
        this.logService = logService;
    }

    @GetMapping("/")
    public Object getAllAds() {
        List<Ad> adList = logService.getAllAds();
        return ResponseUtil.ok(adList);
    }

    public Object addLog(@RequestBody LogVo logVo) {
        Log log = new Log();
        log.setAdminIdId(logVo.getAdminId());
        log.setIp(logVo.getIp());
        log.setType(logVo.getType());
        log.setAction(logVo.getAction());
        log.setStatusCode(logVo.getStatus());
        log.setActionId(logVo.getActionId());

        logService.addLog(log);
        return ResponseUtil.ok();

    }
}
