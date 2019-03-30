package com.hugo.www.mywechat.application.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.hugo.www.mywechat.application.user.service.impl.UserServiceImpl;
import com.hugo.www.mywechat.utils.JsonUtils;
import com.hugo.www.mywechat.utils.WxResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    private static Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    /**
     * 用户登陆验证服务
     * @param data
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public WxResult Login(@RequestBody String data){
        // 字符串转json对象
        JSONObject jsonObject = JSONObject.parseObject(data);
        //获取登陆验证
        String username = jsonObject.getString("username");
        //获取密码
        String password = jsonObject.getString("password");
        if(StringUtils.isEmpty(username)){
            return WxResult.build(400,"请输入账号");
        }else if(StringUtils.isEmpty(password)){
            return WxResult.build(400,"请输入密码");
        }
        WxResult result = userService.UserVerification(username, password, null, null, null);
        if (result != null && result.getStatus()==200 && result.getData()!=null) {
            log.info("返回的数据为："+ JsonUtils.objectToJson(result.getData()));
            return result;
        }
        return  result.build(400,"请检查账号密码是否正确!");
    }

    @GetMapping("/getAllUser")
    @ResponseBody
    public WxResult getAllUser(@RequestParam(value="page", defaultValue="1") int page,
                               @RequestParam(value="rows", defaultValue="10") int rows){
        return  userService.getAllUser(page,rows);
    }

    @GetMapping("/addUser")
    @ResponseBody
    public WxResult addUser(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        return  null;
    }
}