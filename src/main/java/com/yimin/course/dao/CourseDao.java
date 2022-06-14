package com.yimin.course.dao;

import com.yimin.course.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 课程(Course)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-11 15:25:04
 */
@Repository
@Mapper
public interface CourseDao {

    /**
     * 由课程id查询其剩余量
     */
    int selectRemain(Long id);

    /**
     * 由教师id查询所有创建的课程
     */
    List<Course> selectMyCreate(Long id);

    /**
     * 添加课程
     */
    int insertOne(Course course);

    /**
     * 查询所有课程
     */
    List<Course> selectAllCourse();

    /**
     * 课程被选择后，choose字段值+1
     * @return
     */
    int addChooseNum(Long id);

    /**
     * 课程被退课后，chhoose-1
     * @param id
     * @return
     */
    int reduceChooseNum(Long id);

    List<Course> selectCourseByMap(Map<String,String> map);

    Course selectCourseById(Long id);

}

