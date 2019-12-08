package com.tardybird.log.mapper;

import com.tardybird.log.entity.Ad;
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
     * @return a list
     */
    @Select("select link,name,content,pic_url,is_default,is_enabled," +
            "start_time,end_time,gmt_create,gmt_modified,is_deleted from ad")
    @Results(id = "ad", value = {
            @Result(property = "link", column = "link", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "content", column = "content", javaType = String.class),
            @Result(property = "picUrl", column = "pic_url", javaType = String.class),
            @Result(property = "beDefault", column = "is_default", javaType = Boolean.class),
            @Result(property = "beEnable", column = "is_enabled", javaType = Boolean.class),
            @Result(property = "startTime", column = "start_time", javaType = LocalDateTime.class),
            @Result(property = "endTime", column = "end_time", javaType = LocalDateTime.class),
            @Result(property = "gmtCreate", column = "gmt_create", javaType = LocalDateTime.class),
            @Result(property = "gmtModified", column = "gmt_modified", javaType = LocalDateTime.class),
            @Result(property = "beDeleted", column = "is_deleted", javaType = Boolean.class),
    })
    List<Ad> findAllAds();

    /**
     * 生成管理员日志
     *
     * @param log Log object
     */
    @Insert("insert into log(admin_id,ip,action,type,status,gmt_create,gmt_modified,action_id)  " +
            "values(#{adminId},#{ip},#{action},#{type},#{statusCode},now(),now(),#{actionId})")
    void addLog(Log log);
}
