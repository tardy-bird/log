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
        if (adminId == null || adminId <= 0 || page < 0 || limit < 0) {
            return ResponseUtil.findLogsFailed();
        }

        Object adList = logService.getAllLogs(adminId, page, limit);

        return ResponseUtil.ok(adList);
    }

    /**
     * 判断字符串是否可以转换为数字
     *
     * @param str 给定的字符串
     * @return true 如果可以
     */
    private boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 内部接口，提供给个模块调用，记录管理员日志
     *
     * @param log     日志
     * @param request POST请求，头部带有IP和管理员ID
     * @return 成功与否
     */
    @PostMapping("/log")
    public Object addLog(@RequestBody Log log, HttpServletRequest request) {

        if (log.getActionId() == null || log.getActionId() < 0) {
            return null;
        }

        // 获取请求写日志操作的IP地址
        String ipAddr = IpUtil.getIpAddr(request);
        log.setIp(ipAddr);

        String id = request.getHeader("id");

        if (isNumeric(id)) {
            log.setAdminId(Integer.valueOf(id));
        }

        // 如果不再header，默认放在body里传
        logService.addLog(log);

        return log;
    }
}
