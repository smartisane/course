package com.yimin.course.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * (User)实体类
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -30393758521193965L;
    
    private Long id;
    
    private String username;
    
    private String password;
    /**
     * 职称
     */
    private String title;
    /**
     * 学院
     */
    private String college;
    /**
     * 专业
     */
    private String major;
    /**
     * 姓名
     */
    private String name;
    
    private Integer sex;
    /**
     * 0管理员 1教师 2学生
     */
    private Integer role;

    //学生的选课
    private List<Course> courses;


}

