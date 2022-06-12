package com.yimin.course.controller;

import com.yimin.course.common.Result;
import com.yimin.course.entity.User;
import com.yimin.course.service.UserService;
import com.yimin.course.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-06-09 21:00:01
 */
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("login")
    @ResponseBody
    public Result login(User user, HttpSession session) {
        log.info("用户名：{}", user.getUsername());
        log.info("密码：{}", user.getPassword());

        //登陆失败时抛出异常B，不会往下执行
        User userDB = userService.login(user);
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("name", userDB.getName());
        payload.put("role", userDB.getRole());
        payload.put("id", userDB.getId());
        String token = JWTUtils.getToken(payload);
        session.setAttribute("token",token);
        //保存到redis 设置过期时间
        stringRedisTemplate.opsForValue().set(token, String.valueOf(userDB.getId()),30, TimeUnit.MINUTES);
        return Result.success("登陆成功");

    }

    @RequestMapping("test")
    @ResponseBody
    public Result test() {
        return Result.success();
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("token");
        session.invalidate();
        return "redirect:/login";
    }

}

