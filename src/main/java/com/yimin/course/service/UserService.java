package com.yimin.course.service;

import com.yimin.course.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-06-09 21:00:01
 */
public interface UserService {

    /**
     * 登陆
     */
    User login(User user);

    List<User> getCourseSitu();

    User getOneCourseSitu(Long id);

}
