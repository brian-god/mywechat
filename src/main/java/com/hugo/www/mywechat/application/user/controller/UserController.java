package com.hugo.www.mywechat.application.user.controller;

import com.hugo.www.mywechat.application.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制类
 * @ClassName: UserController
 * @Description:
 * @Author: Hugo
 * @CreateDate: 2019/3/23$ 14:43$
 * @Version: 1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 用户登陆验证服务
     * @param data
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public  String Login( @RequestBody String data){
        //测试提交
        return  userService.UserVerification(data,null,null,null);
    }
}