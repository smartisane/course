package com.yimin.course.controller;

import com.yimin.course.common.Result;
import com.yimin.course.entity.StudentCourse;
import com.yimin.course.service.CourseService;
import com.yimin.course.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (StudentCourse)表控制层
 *
 * @author makejava
 * @since 2022-06-11 22:46:00
 */
@RestController
@RequestMapping("studentCourse")
public class StudentCourseController {
    /**
     * 服务对象
     */
    @Resource
    private StudentCourseService studentCourseService;

    @Autowired
    private CourseService courseService;


    /**
     * 学生选课
     *
     * @param studentCourse
     * @return
     */
    @PostMapping("/choose")
    public Result chooseCourse(StudentCourse studentCourse) {
        studentCourseService.isAlreadyChoose(studentCourse);
        studentCourseService.insert(studentCourse);
        //课程choose+1
        courseService.addChooseMum(studentCourse.getCourseId());
        return Result.success("选课成功");
    }

    @PostMapping("/withdraw")
    public Result withdrawCourse(StudentCourse studentCourse) {
        int i = studentCourseService.withdrawCourse(studentCourse);
        if (i == 0) {
            throw new RuntimeException("没有找到选课记录");
        }
        //课程choose-1
        courseService.reduceChooseNum(studentCourse.getCourseId());
        return Result.success("退课成功");
    }

    /**
     * 分页查询
     *
     * @param studentCourse 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<StudentCourse>> queryByPage(StudentCourse studentCourse, PageRequest pageRequest) {
        return ResponseEntity.ok(this.studentCourseService.queryByPage(studentCourse, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<StudentCourse> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.studentCourseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param studentCourse 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<StudentCourse> add(StudentCourse studentCourse) {
        return ResponseEntity.ok(this.studentCourseService.insert(studentCourse));
    }

    /**
     * 编辑数据
     *
     * @param studentCourse 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<StudentCourse> edit(StudentCourse studentCourse) {
        return ResponseEntity.ok(this.studentCourseService.update(studentCourse));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.studentCourseService.deleteById(id));
    }

}

