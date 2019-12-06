package com.tardybird.log.service;

import com.tardybird.log.entity.Ad;
import com.tardybird.log.entity.Log;

import java.util.List;

/**
 * @author nick
 */
public interface LogService {

    /**
     * 所有广告列表
     *
     * @return a list
     */
    List<Ad> getAllAds();

    /**
     * 生成管理员日志
     *
     * @param log Log object
     */
    void addLog(Log log);
}
