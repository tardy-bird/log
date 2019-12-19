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
     * 所有日志列表
     *
     * @param id 管理员ID
     * @return Log列表
     */
    List<Log> findAllLogs(@Param("id") Integer id);

    /**
     * 生成管理员日志
     *
     * @param log 日志对象
     */
    void addLog(Log log);
}
