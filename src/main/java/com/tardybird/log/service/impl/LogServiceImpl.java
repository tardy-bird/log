package com.tardybird.log.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardybird.log.entity.Log;
import com.tardybird.log.mapper.LogMapper;
import com.tardybird.log.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nick
 */
@Service
public class LogServiceImpl implements LogService {

    private final
    LogMapper logMapper;

    public LogServiceImpl(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    @Override
    public Object getAllAds(Integer adminId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Log> logs = logMapper.findAllLogs(adminId);
        return new PageInfo<>(logs);
    }

    @Override
    public void addLog(Log log) {
        logMapper.addLog(log);
    }

}
