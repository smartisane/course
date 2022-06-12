package com.yimin.course.common;

/**
 * @author yimin
 * @date 2022/6/9 22:10
 */

import cn.hutool.json.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Result exceptionHandler(RuntimeException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.error(e.getMessage());
    }
}
