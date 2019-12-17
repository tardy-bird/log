package com.tardybird.log.controller;

import com.tardybird.log.entity.Log;
import com.tardybird.log.service.impl.LogServiceImpl;
import com.tardybird.log.util.IpUtil;
import com.tardybird.log.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 管理员根据条件查看日志
     *
     * @return 所有操作日志
     */
    @GetMapping("/logs")
    public Object list(@RequestParam Integer adminId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit) {
        if (adminId == null || page == null || limit == null) {
            return ResponseUtil.badArgument();
        }
        if (adminId <= 0 || page < 0 || limit < 0) {
            return ResponseUtil.badArgumentValue();
        }
        Object adList = logService.getAllAds(adminId, page, limit);
        return ResponseUtil.ok(adList);
    }

    @PostMapping("/log")
    public Object addLog(@RequestBody Log log, HttpServletRequest request) {
        String ipAddr = IpUtil.getIpAddr(request);
        log.setIp(ipAddr);
        logService.addLog(log);
        return ResponseUtil.ok(log);
    }
}
