package com.example.demo.play;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@Api(value = "/", description = "参数配置swagger-ui")
@RequestMapping("")
public class SimpleInterface {

    public int count = 0;
    //@Autowired
    //private UserService userService;

    @GetMapping(value = "/getdemo/{username}")
    @ApiOperation(value = "带参数的get请求", httpMethod = "GET")
    public String getDemo(@PathVariable String username) {
        return username;
    }


    @RequestMapping(value = "/postdemo", method = RequestMethod.POST)
    @ApiOperation(value = "带参数的Post请求", httpMethod = "POST")
    public String postdemo(@RequestParam String username) {
        count++;
        String result = "这是第" + count + "访问的post请求" + username;
        return result;
    }

    //post json格式传参
    @RequestMapping(value = "/postjson", method = RequestMethod.POST)
    @ApiOperation(value = "json传参的POST请求", httpMethod = "POST")
    public @ResponseBody
    Student postdemo(@RequestBody Student s) {
        Student student = new Student();
        student.age = s.age;
        student.classname = s.classname;
        student.name = s.name + " lin";
        System.out.println(student.name);
        return student;
    }

    /*@RequestMapping(value = "/email", method = RequestMethod.POST)
    public String userEmail(@RequestBody @Valid User user ,BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return addUser(user);
    }*/

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public String userEmail(@RequestBody @Valid User user) {
        /*for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }*/
        return addUser(user);
    }

    @GetMapping("/getUser")
    public ResultVO<User> getUser() {
        User user = new User();
        user.setUsername("lin");
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");

        return new ResultVO<>(user);
    }

    public String addUser(User user) {
        // 直接编写业务逻辑
        return "success";
    }
}
