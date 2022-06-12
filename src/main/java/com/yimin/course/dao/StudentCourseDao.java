package com.yimin.course.dao;

import com.yimin.course.entity.StudentCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (StudentCourse)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-11 22:46:00
 */
@Repository
@Mapper
public interface StudentCourseDao {



    /**
     * 通过课程id和学生id删除（退课）
     * @param studentCourse
     * @return
     */
    int deleteByStudentAndCourse(StudentCourse studentCourse);

    /**
     * 通过课程id和学生id查询
     * @param studentCourse
     * @return
     */
    StudentCourse selectByStudentAndCourse(StudentCourse studentCourse);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StudentCourse queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param studentCourse 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<StudentCourse> queryAllByLimit(StudentCourse studentCourse, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param studentCourse 查询条件
     * @return 总行数
     */
    long count(StudentCourse studentCourse);

    /**
     * 新增数据
     *
     * @param studentCourse 实例对象
     * @return 影响行数
     */
    int insert(StudentCourse studentCourse);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StudentCourse> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StudentCourse> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StudentCourse> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StudentCourse> entities);

    /**
     * 修改数据
     *
     * @param studentCourse 实例对象
     * @return 影响行数
     */
    int update(StudentCourse studentCourse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

