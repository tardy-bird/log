package com.tardybird.log.mapper;

import com.tardybird.log.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nick
 */
@Component
@Mapper
public interface LogMapper {

    /**
     * 所有广告列表
     *
     * @param id x
     * @return x
     */
    List<Log> findAllLogs(@Param("id") Integer id);

    /**
     * 生成管理员日志
     *
     * @param log Log object
     */
    void addLog(Log log);
}
