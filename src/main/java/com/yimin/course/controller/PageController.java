package com.yimin.course.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.yimin.course.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author yimin
 * @date 2022/6/9 23:19
 */
@Controller
@Slf4j
public class PageController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping(value = {"/","/index","/course/my"})
    public String indexPage(Model model, HttpSession session){
        String token = (String) session.getAttribute("token");
        DecodedJWT jwt = JWTUtils.verify(token);
        String name = jwt.getClaim("name").asString();
        Integer role = jwt.getClaim("role").asInt();
        Long id = jwt.getClaim("id").asLong();
        log.info("name={}",name);
        log.info("role={}",role);
        log.info("id={}",id);
        model.addAttribute("name",name);
        model.addAttribute("role",role);
        model.addAttribute("id",id);
        model.addAttribute("isMyMenu",true);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping(value = {"/course/all"})
    public String allCoursePage(Model model, HttpSession session){
        String token = (String) session.getAttribute("token");
        DecodedJWT jwt = JWTUtils.verify(token);
        String name = jwt.getClaim("name").asString();
        Integer role = jwt.getClaim("role").asInt();
        Long id = jwt.getClaim("id").asLong();
        log.info("name={}",name);
        log.info("role={}",role);
        log.info("id={}",id);
        model.addAttribute("name",name);
        model.addAttribute("role",role);
        model.addAttribute("id",id);
        model.addAttribute("isAllMenu",true);
        return "course-all";
    }


    /**
     * 管理员 学生选课情况
     * @param model
     * @param session
     * @return
     */
    @GetMapping(value = {"/course/situ"})
    public String situPage(Model model, HttpSession session){
        String token = (String) session.getAttribute("token");
        DecodedJWT jwt = JWTUtils.verify(token);
        String name = jwt.getClaim("name").asString();
        Integer role = jwt.getClaim("role").asInt();
        Long id = jwt.getClaim("id").asLong();
        log.info("name={}",name);
        log.info("role={}",role);
        log.info("id={}",id);
        model.addAttribute("name",name);
        model.addAttribute("role",role);
        model.addAttribute("id",id);
        model.addAttribute("isSituMenu",true);
        return "course-situ";
    }
}
