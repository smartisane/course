package com.yimin.course.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author yimin
 * @date 2022/6/9 21:09
 * jwt 工具类
 */
public class JWTUtils {

    private static final String SIGN = "yimin";

    /**
     * 生成token
     */
    public static String getToken(Map<String, Object> payload) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);
        String token = JWT.create()
                .withPayload(payload)//保存信息
                .withExpiresAt(calendar.getTime())//过期时间
                .sign(Algorithm.HMAC256(SIGN));//签名

        return token;
    }

    /**
     * 验证token
     */
    public static DecodedJWT verify(String token) {
        //验证失败抛出异常
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }
}
