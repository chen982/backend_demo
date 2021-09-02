package backend.controller;

import backend.entity.User;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //注册接口，
    //参数：传入json类型的user结构体 ：{"username":"user4","password":"user4","phone":"123456789"}
    //                    可以缺省 ：{"username":"user4","password":"user4"}
    //返回值：
    //      成功：返回 user 的 id
    //      失败："该用户已存在"
    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
        return userService.register(user);
    }

    //登录接口
    //参数：传入(String)username和(String)password
    //返回值：
    //      成功："登录成功"
    //      失败：
    //          "登录失败，用户不存在"
    //          "登录失败，密码错误"
    @PostMapping("/login")
    public User login(@RequestParam("username") String username,@RequestParam("password") String password)
    {
        return userService.login(username,password);
    }

}
