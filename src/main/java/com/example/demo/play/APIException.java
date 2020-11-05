package com.example.demo.play;

import lombok.Getter;

@Getter
public class APIException extends RuntimeException {
    private String msg;
    private int code;

    public APIException() {
        this(1001, "接口异常");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
