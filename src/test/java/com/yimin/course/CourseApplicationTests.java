package com.yimin.course;

import com.yimin.course.dao.CourseDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseApplicationTests {

    @Autowired
    CourseDao courseDao;

    @Test
    void contextLoads() {
    }

}
