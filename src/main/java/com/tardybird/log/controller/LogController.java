package com.tardybird.log.controller;

import com.tardybird.log.entity.Log;
import com.tardybird.log.service.impl.LogServiceImpl;
import com.tardybird.log.util.ResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nick
 */
@RestController
@RequestMapping("/logService")
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
    public Object list(Integer adminId, Integer page, Integer limit) {
        if (adminId == null || adminId < 0 || page == null || page < 0 || limit == null || limit < 0) {
            return ResponseUtil.badArgument();
        }
        Object adList = logService.getAllAds(adminId, page, limit);
        return ResponseUtil.ok(adList);
    }

    public Object addLog(@RequestBody Log log) {
        if (log == null) {
            return ResponseUtil.fail();
        }
        logService.addLog(log);
        return ResponseUtil.ok(log);
    }
}
