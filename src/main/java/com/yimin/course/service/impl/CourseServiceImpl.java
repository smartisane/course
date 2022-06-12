package com.yimin.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.yimin.course.entity.Course;
import com.yimin.course.dao.CourseDao;
import com.yimin.course.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 课程(Course)表服务实现类
 *
 * @author makejava
 * @since 2022-06-11 15:25:04
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao courseDao;

    @Override
    public List<Course> getAllMyCourse(Long id, Integer currPage, Integer pageSize) {
        return courseDao.selectMyCreate(id);
    }

    @Override
    public int addCourse(Course course) {
        return courseDao.insertOne(course);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.selectAllCourse();
    }

    @Override
    public int addChooseMum(Long id) {
        return courseDao.addChooseNum(id);
    }

    @Override
    public int reduceChooseNum(Long id) {
        return courseDao.reduceChooseNum(id);
    }

    @Override
    public List<Course> searchCourse(Map<String, String> map) {
        return courseDao.selectCourseByMap(map);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.selectCourseById(id);
    }
}
