package com.yimin.course.service.impl;

import com.yimin.course.entity.User;
import com.yimin.course.dao.UserDao;
import com.yimin.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-06-09 21:00:01
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        User userDB = userDao.selectUserByNamePwd(user);
        if (userDB != null) {
            return userDB;
        }
        throw new RuntimeException("用户名或密码错误");
    }

    @Override
    public List<User> getCourseSitu() {
        return userDao.selectCourseSitu();
    }

    @Override
    public User getOneCourseSitu(Long id) {
        return userDao.selectOneCourseSitu(id);
    }
}
