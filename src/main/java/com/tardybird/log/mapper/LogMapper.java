package com.tardybird.log.mapper;

import com.tardybird.log.entity.Ad;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author nick
 */
@Component
@Mapper
public interface LogMapper {

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
}
