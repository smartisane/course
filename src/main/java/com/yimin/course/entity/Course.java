package com.yimin.course.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 课程(Course)实体类
 *
 * @author makejava
 * @since 2022-06-11 23:18:07
 */
@Data
public class Course implements Serializable {
    private static final long serialVersionUID = 786152149047855775L;
    /**
     * id
     */
    private Long id;
    private List<User> students;//选课状态（联表查询）
    /**
     * 课程名
     */
    private String name;
    /**
     * 课程类型
     */
    private String type;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 限选人数
     */
    private Integer total;
    /**
     * 已选人数
     */
    private Integer choose;
    /**
     * 教师id
     */
    private Long teacherId;
    private String teacherName;
    /**
     * 教室id
     */
    private String classroom;
    /**
     * 上课时间
     */
    private String week;
    /**
     * 第几节
     */
    private String section;
    /**
     * 开设学院
     */
    private String college;



}

