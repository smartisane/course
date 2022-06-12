package com.yimin.course.entity;

import lombok.ToString;

import java.io.Serializable;

/**
 * (StudentCourse)实体类
 *
 * @author makejava
 * @since 2022-06-11 22:46:00
 */
@ToString
public class StudentCourse implements Serializable {
    private static final long serialVersionUID = 207955694623486216L;
    
    private Long id;
    
    private Long studentId;
    
    private Long courseId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

}

