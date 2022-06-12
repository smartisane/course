package com.yimin.course.dao;

import com.yimin.course.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-09 21:00:01
 */
@Repository
@Mapper
public interface UserDao {

    /**
     * 根据用户名和密码查询
     */
    User selectUserByNamePwd(User user);

    /**
     * 学生的选课情况
     * @return
     */
    List<User> selectCourseSitu();
    User selectOneCourseSitu(Long id);

}

