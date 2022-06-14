package com.yimin.course.service;

import com.yimin.course.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 课程(Course)表服务接口
 *
 * @author makejava
 * @since 2022-06-11 15:25:04
 */
public interface CourseService {

    List<Course> getAllMyCourse(Long id,Integer currPage, Integer pageSize);

    int addCourse(Course course);

    List<Course> getAllCourse();

    int addChooseMum(Long id);

    int reduceChooseNum(Long id);

    List<Course> searchCourse(Map<String,String> map);

    Course getCourseById(Long id);

    int getCourseRemain(Long id);

}
