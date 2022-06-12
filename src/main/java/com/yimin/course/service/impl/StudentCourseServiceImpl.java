package com.yimin.course.service.impl;

import com.yimin.course.entity.StudentCourse;
import com.yimin.course.dao.StudentCourseDao;
import com.yimin.course.service.StudentCourseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (StudentCourse)表服务实现类
 *
 * @author makejava
 * @since 2022-06-11 22:46:01
 */
@Service("studentCourseService")
public class StudentCourseServiceImpl implements StudentCourseService {
    @Resource
    private StudentCourseDao studentCourseDao;

    @Override
    public int withdrawCourse(StudentCourse studentCourse) {
        return studentCourseDao.deleteByStudentAndCourse(studentCourse);
    }

    @Override
    public StudentCourse isAlreadyChoose(StudentCourse studentCourse) {
        StudentCourse studentCourseDB = studentCourseDao.selectByStudentAndCourse(studentCourse);
        if(studentCourseDB != null){
            throw new RuntimeException("该课程已经选过了");
        }
        return null;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StudentCourse queryById(Long id) {
        return this.studentCourseDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param studentCourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StudentCourse> queryByPage(StudentCourse studentCourse, PageRequest pageRequest) {
        long total = this.studentCourseDao.count(studentCourse);
        return new PageImpl<>(this.studentCourseDao.queryAllByLimit(studentCourse, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param studentCourse 实例对象
     * @return 实例对象
     */
    @Override
    public StudentCourse insert(StudentCourse studentCourse) {
        this.studentCourseDao.insert(studentCourse);
        return studentCourse;
    }

    /**
     * 修改数据
     *
     * @param studentCourse 实例对象
     * @return 实例对象
     */
    @Override
    public StudentCourse update(StudentCourse studentCourse) {
        this.studentCourseDao.update(studentCourse);
        return this.queryById(studentCourse.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.studentCourseDao.deleteById(id) > 0;
    }
}
