package com.yimin.course.intercepter;

import com.yimin.course.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author yimin
 * @date 2022/6/9 22:27
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // String token = request.getHeader("token");
        // if(token != null && stringRedisTemplate.opsForValue().get(token)!=null){
        //     JWTUtils.verify(token);//使用redis后，好像可以不要这句
        //     // 每次认证后重置过期时间
        //     stringRedisTemplate.expire(token,30, TimeUnit.MINUTES);
        //     return true;
        // }
        String token = (String) request.getSession().getAttribute("token");

        if(token != null && stringRedisTemplate.opsForValue().get(token)!=null){
            // 每次认证后重置过期时间
            stringRedisTemplate.expire(token,30, TimeUnit.MINUTES);
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }
}
