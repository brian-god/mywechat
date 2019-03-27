package com.hugo.www.mywechat.assembly.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @ClassName: TestWebSocktController
 * @Description:
 * @Author: Hugo
 * @CreateDate: 2019/3/23$ 10:08$
 * @Version: 1.0
 */
@Controller
public class TestWebSocktController {
    @RequestMapping("/websocket")
    public String websocket(){
        return "client";
    }
    @RequestMapping("/user1")
    public String User1(){
        return "user1page";
    }
    @RequestMapping("/user2")
    public String User2(){
        return "user2page";
    }
}