package com.example.demo.play;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String MethodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e){
        ObjectError objectError=e.getBindingResult().getAllErrors().get(0);
        System.out.println(objectError);
        return objectError.getDefaultMessage();
    }

    @ExceptionHandler(APIException.class)
    public String APIExceptionHandle(APIException e){
        return e.getMsg();
    }
    */
/*    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO MethodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e){
        ObjectError objectError=e.getBindingResult().getAllErrors().get(0);
        System.out.println(objectError);
        return new ResultVO<>(1001, "参数校验失败", objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public ResultVO<String> APIExceptionHandler(APIException e) {
        // 注意哦，这里返回类型是自定义响应体
        return new ResultVO<>(e.getCode(), "响应失败", e.getMsg());
    }*/

    @ExceptionHandler(APIException.class)
    public ResultVO<String> APIExceptionHandler(APIException e) {
        // 注意哦，这里传递的响应码枚举
        return new ResultVO<>(ResultCode.FAILED, e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 注意哦，这里传递的响应码枚举
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

}
