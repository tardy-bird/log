package com.tardybird.log.service.impl;

import com.tardybird.log.entity.Ad;
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
    public List<Ad> getAllAds() {
        return logMapper.findAllAds();
    }

    @Override
    public void addLog(Log log) {
        logMapper.addLog(log);
    }

}
