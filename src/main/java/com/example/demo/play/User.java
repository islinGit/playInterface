package com.example.demo.play;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "用户名不能为空")
    @Size(min = 6, max = 10, message = "账号长度必须是6-10字符")
    private String account;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 11, message = "密码不正确")
    private String password;

    @NotBlank(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

}

