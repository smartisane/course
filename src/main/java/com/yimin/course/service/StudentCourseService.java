package com.yimin.course.service;

import com.yimin.course.entity.StudentCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (StudentCourse)表服务接口
 *
 * @author makejava
 * @since 2022-06-11 22:46:01
 */
public interface StudentCourseService {

    int withdrawCourse(StudentCourse studentCourse);

    /**
     * 学生是否已经选过课程
     * @param studentCourse
     * @return
     */
    StudentCourse isAlreadyChoose(StudentCourse studentCourse);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StudentCourse queryById(Long id);

    /**
     * 分页查询
     *
     * @param studentCourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StudentCourse> queryByPage(StudentCourse studentCourse, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param studentCourse 实例对象
     * @return 实例对象
     */
    StudentCourse insert(StudentCourse studentCourse);

    /**
     * 修改数据
     *
     * @param studentCourse 实例对象
     * @return 实例对象
     */
    StudentCourse update(StudentCourse studentCourse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
