package com.tardybird.log.util;
import java.lang.annotation.*;

/**
 * @author DIX
 * @version 1.0
 * @description
 * @date 2019/12/16 21:44
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logs {
    /** 是否记录日志  true记录   false不记录**/
    public boolean record() default true;

    /** 要执行的具体操作比如：添加用户 **/
    public String operationName() default "";
}