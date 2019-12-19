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

    public static Object findLogsFailed() {
        return fail(901, "查看日志失败");
    }

}

