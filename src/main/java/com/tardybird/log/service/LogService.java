package com.tardybird.log.service;

import com.tardybird.log.entity.Log;

/**
 * @author nick
 */
public interface LogService {

    /**
     * 所有广告列表
     *
     * @param adminId x
     * @param page    x
     * @param limit   x
     * @return x
     */
    Object getAllAds(Integer adminId, Integer page, Integer limit);

    /**
     * 生成管理员日志
     *
     * @param log Log object
     */
    void addLog(Log log);
}
