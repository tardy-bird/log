package com.tardybird.log.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应操作结果
 *
 * @author nick
 */
public class ResponseUtil {

    public static Object ok(Object data) {
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("errno", 0);
        objectMap.put("errmsg", "成功");
        objectMap.put("data", data);
        return objectMap;
    }


    public static Object fail(int errno, String errmsg) {
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("errno", errno);
        objectMap.put("errmsg", errmsg);
        return objectMap;
    }

    public static Object badArgument() {
        return fail(401, "参数不对");
    }

    public static Object badArgumentValue() {
        return fail(402, "参数值不对");
    }

    public static Object unLogin() {
        return fail(501, "请登录");
    }

    public static Object serious() {
        return fail(502, "系统内部错误");
    }

    public static Object unSupport() {
        return fail(503, "业务不支持");
    }

    public static Object updatedDateExpired() {
        return fail(504, "更新数据已经失效");
    }

    public static Object updatedDataFailed() {
        return fail(505, "更新数据失败");
    }

    public static Object unAuthorized() {
        return fail(506, "无操作权限");
    }
}

