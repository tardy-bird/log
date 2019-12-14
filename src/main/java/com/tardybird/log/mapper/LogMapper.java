package com.tardybird.log.mapper;

import com.tardybird.log.entity.Log;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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
     * @param adminId x
     * @return x
     */
    @Select("select * from oomall_log where admin_id=#{adminId}")
    @Results(id = "log", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "adminId", column = "admin_id", javaType = Integer.class),
            @Result(property = "ip", column = "ip", javaType = String.class),
            @Result(property = "type", column = "type", javaType = Integer.class),
            @Result(property = "actions", column = "actions", javaType = String.class),
            @Result(property = "statusCode", column = "status", javaType = Integer.class),
            @Result(property = "actionId", column = "action_id", javaType = Integer.class),
            @Result(property = "gmtCreate", column = "gmt_create", javaType = LocalDateTime.class),
            @Result(property = "gmtModified", column = "gmt_modified", javaType = LocalDateTime.class)
    })
    List<Log> findAllLogs(Integer adminId);

    /**
     * 生成管理员日志
     *
     * @param log Log object
     */
    @Insert("insert into oomall_log(admin_id,ip,actions,type,status,gmt_create,gmt_modified,action_id)  " +
            "values(#{adminId},#{ip},#{actions},#{type},#{statusCode},now(),now(),#{actionId})")
    void addLog(Log log);
}
