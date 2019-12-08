package com.tardybird.log.controller;

import com.tardybird.log.entity.Ad;
import com.tardybird.log.entity.Log;
import com.tardybird.log.service.impl.LogServiceImpl;
import com.tardybird.log.util.ResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nick
 */
@RestController
@RequestMapping("/logs")
public class LogController {

    final
    LogServiceImpl logService;

    public LogController(LogServiceImpl logService) {
        this.logService = logService;
    }

    /**
     * 管理员根据条件查看日志
     *
     * @return 所有操作日志
     */
    @GetMapping("/")
    public Object list() {
        List<Ad> adList = logService.getAllAds();
        return ResponseUtil.ok(adList);
    }

    public Object addLog(@RequestBody LogVo logVo) {

        Log log = new Log();

        log.setAdminId(logVo.getAdminId());
        log.setIp(logVo.getIp());
        log.setType(logVo.getType());
        log.setAction(logVo.getAction());
        log.setActionId(logVo.getActionId());
        log.setStatusCode(logVo.getStatusCode());

        logService.addLog(log);
        return ResponseUtil.ok(log);
    }
}
