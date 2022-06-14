package com.yimin.course.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yimin.course.common.Result;
import com.yimin.course.entity.Course;
import com.yimin.course.entity.User;
import com.yimin.course.service.CourseService;
import com.yimin.course.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;

/**
 * 课程(Course)表控制层
 *
 * @author makejava
 * @since 2022-06-11 15:25:04
 */
@RestController
@RequestMapping("course")
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    /**
     * 教师创建的课程
     *
     * @param id
     * @param currPage
     * @param pageSize
     * @return
     */
    @PostMapping("/my")
    public Map<String, Object> getAllMyCourse(Long id, Integer role, @RequestParam(required = false, defaultValue = "1") Integer currPage, @RequestParam(required = false, defaultValue = "6") Integer pageSize) {
        PageHelper.startPage(currPage, pageSize);
        List<Course> courses;
        courses = courseService.getAllMyCourse(id, currPage, pageSize);
        PageInfo<Course> pageInfo = new PageInfo<>(courses);
        //layui表格要求返回的格式
        log.info(String.valueOf(pageInfo.getTotal()));
        System.out.println("pageInfo.getList() = " + pageInfo.getList());

        //layui表格要求返回的格式
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getPageNum());
        map.put("data", pageInfo.getList());
        return map;
    }

    /**
     * 教师添加课程
     *
     * @param course
     * @param session
     * @return
     */
    @RequestMapping("/add")
    public Result addCourse(Course course, HttpSession session) {
        course.setChoose(0);
        course.setCreateTime(new Date());
        if (courseService.addCourse(course) == 1) {
            return Result.success("创建课程成功");
        }
        return Result.error("创建课程失败");
    }


    /**
     * 展示所有课程接口
     */
    @PostMapping("/all")
    public Map<String, Object> getAllCourse(@RequestParam(required = false, defaultValue = "1") Integer currPage, @RequestParam(required = false, defaultValue = "6") Integer pageSize) {
        PageHelper.startPage(currPage, pageSize);
        List<Course> courses = courseService.getAllCourse();
        PageInfo<Course> pageInfo = new PageInfo<>(courses);

        //layui表格要求返回的格式
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        System.out.println("pageInfo.getTotal() = " + pageInfo.getTotal());
        System.out.println("pageInfo.getList() = " + pageInfo.getList());
        return map;
    }


    /**
     * 展示所有课程接口（搜索，条件查询）
     */
    @PostMapping("/search")
    public Map<String, Object> searchCourse(@RequestParam Map<String, String> map, @RequestParam(required = false, defaultValue = "1") Integer currPage, @RequestParam(required = false, defaultValue = "6") Integer pageSize) {

        System.out.println("map = " + map);

        PageHelper.startPage(currPage, pageSize);
        List<Course> courses = courseService.searchCourse(map);
        PageInfo<Course> pageInfo = new PageInfo<>(courses);

        //layui表格要求返回的格式
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        System.out.println("pageInfo.getTotal() = " + pageInfo.getTotal());
        System.out.println("pageInfo.getList() = " + pageInfo.getList());
        return result;
    }

    /**
     * 学生选课情况，包含学生的学号，姓名，选课数（详细课程名）
     */
    @PostMapping("/situ")
    public Map<String, Object> courseSitu(@RequestParam(required = false, defaultValue = "1") Integer currPage, @RequestParam(required = false, defaultValue = "6") Integer pageSize) {

        PageHelper.startPage(currPage, pageSize);
        List<User> users = userService.getCourseSitu();
        System.out.println("users = " + users);
        PageInfo<User> pageInfo = new PageInfo<>(users);

        //layui表格要求返回的格式
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        System.out.println("pageInfo.getTotal() = " + pageInfo.getTotal());
        System.out.println("pageInfo.getList() = " + pageInfo.getList());
        return result;
    }


    /**
     * 学生选课详情
     */
    @PostMapping("/detail")
    public Map<String, Object> courseDetail(@RequestParam("id") Long id,@RequestParam(required = false, defaultValue = "1") Integer currPage, @RequestParam(required = false, defaultValue = "6") Integer pageSize) {

        User user = userService.getOneCourseSitu(id);
        System.out.println("user = " + user);
        //这里的courses只包含id，其他为null
        List<Course> courses = user.getCourses();
        System.out.println("courses = " + courses);

        //由以上courses中的id查出详细信息，在前端展示
        List<Course> resultCourse = new ArrayList<>();
        for (Course cours : courses) {
            Course course = courseService.getCourseById(cours.getId());
            System.out.println("cours = " + cours);
            resultCourse.add(course);
        }

        //layui表格要求返回的格式
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", resultCourse.size());
        result.put("data", resultCourse);
        return result;
    }



    /**
     * 学生 我的课程接口
     *
     */
    // @PostMapping("/my")
    // public Map<String, Object> getStuCourse(Long id, @RequestParam(required = false, defaultValue = "1") Integer currPage, @RequestParam(required = false, defaultValue = "6") Integer pageSize) {
    //     PageHelper.startPage(currPage, pageSize);
    //     List<Course> courses;
    //     courses = courseService.getAllMyCourse(id, currPage, pageSize);
    //     PageInfo<Course> pageInfo = new PageInfo<>(courses);
    //     //layui表格要求返回的格式
    //     log.info(String.valueOf(pageInfo.getTotal()));
    //     System.out.println("pageInfo.getList() = " + pageInfo.getList());
    //
    //     //layui表格要求返回的格式
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("code", 0);
    //     map.put("msg", "");
    //     map.put("count", pageInfo.getPageNum());
    //     map.put("data", pageInfo.getList());
    //     return map;
    // }



}

