package com.tardybird.log.service.impl;

import com.tardybird.log.entity.Log;
import com.tardybird.log.mapper.LogMapper;
import com.tardybird.log.service.LogService;
import org.springframework.stereotype.Service;

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
    public Object getAllLogs(Integer adminId, Integer page, Integer limit) {
        return logMapper.findAllLogs(adminId, page, limit);
    }

    @Override
    public void addLog(Log log) {
        logMapper.addLog(log);
    }

}
