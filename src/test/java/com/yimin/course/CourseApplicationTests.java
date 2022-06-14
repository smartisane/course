package com.yimin.course;

import com.yimin.course.dao.CourseDao;
import com.yimin.course.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseApplicationTests {

    @Autowired
    CourseService courseService;

    @Test
    void contextLoads() {
        int remain = courseService.getCourseRemain(2L);
        System.out.println("remain = " + remain);
    }

}
