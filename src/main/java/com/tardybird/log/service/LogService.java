package com.tardybird.log.service;

import com.tardybird.log.entity.Log;

/**
 * @author nick
 */
public interface LogService {

    /**
     * 获取所有日志列表
     *
     * @param adminId 管理员ID
     * @param page    页数
     * @param limit   每一页限制
     * @return 分页日志列表
     */
    Object getAllLogs(Integer adminId, Integer page, Integer limit);

    /**
     * 生成管理员日志
     *
     * @param log Log对象
     */
    void addLog(Log log);
}
