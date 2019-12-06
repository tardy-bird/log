package com.tardybird.log.mapper;

import com.tardybird.log.entity.Ad;
import com.tardybird.log.entity.Log;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
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
    @Results(id = "student", value = {
            @Result(property = "link", column = "link", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "content", column = "content", javaType = String.class),
            @Result(property = "pic_url", column = "pic_url", javaType = String.class),
            @Result(property = "is_default", column = "is_default", javaType = Boolean.class),
            @Result(property = "is_enabled", column = "is_enabled", javaType = Boolean.class),
            @Result(property = "start_time", column = "start_time", javaType = Timestamp.class),
            @Result(property = "end_time", column = "end_time", javaType = Timestamp.class),
            @Result(property = "gmt_create", column = "gmt_create", javaType = Timestamp.class),
            @Result(property = "gmt_modified", column = "gmt_modified", javaType = Timestamp.class),
            @Result(property = "is_deleted", column = "is_deleted", javaType = Boolean.class),
    })
    List<Ad> findAllAds();

    /**
     * 生成管理员日志
     *
     * @param log Log object
     */
    @Insert("insert into log(admin_id,ip,type,status,gmt_create,gmr_modified,action_id)  " +
            "values(#{admin_id},#{ip},#{type},#{action},#{status},now(),now(),#{action_id})")
    void addLog(Log log);
}
