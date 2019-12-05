package com.tardybird.log.service.impl;

import com.tardybird.log.entity.Ad;
import com.tardybird.log.mapper.LogMapper;
import com.tardybird.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author nick
 */
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public List<Ad> getAllAds() {
        return logMapper.findAllAds();
    }
}
