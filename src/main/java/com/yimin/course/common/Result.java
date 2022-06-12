package com.yimin.course.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yimin
 * @date 2022/6/9 22:02
 */
@Data
@AllArgsConstructor
public class Result {
    private int code;
    private String msg;
    private Object data;

    public static Result success(){
        return new Result(200,"success",null);
    }

    public static Result success(String msg){
        return new Result(200,msg,null);
    }

    public static Result success(String msg,Object data){
        return new Result(200,msg,data);
    }

    public static Result error(){
        return new Result(400,"error",null);
    }

    public static Result error(String msg){
        return new Result(400,msg,null);
    }
}
