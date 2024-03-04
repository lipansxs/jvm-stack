package com.lipanre.jvm.stack.spring.security.http;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiPan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private int code;

    private T data;

    private String message;

    public static <T> Response<T> success(T data) {
        return new Response<T>(200, data, "操作成功");
    }

    public static Response<String> error(String message) {
        return new Response<>(500, null, message);
    }

    public String toJSON() {
        return JSON.toJSONString(this);
    }
}
