package com.hugo.www.mywechat.application.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hugo.www.mywechat.application.user.entity.User;
import com.hugo.www.mywechat.application.user.mapper.UserMapper;
import com.hugo.www.mywechat.application.user.service.UserService;
import com.hugo.www.mywechat.constant.ConstantObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: Hugo
 * @CreateDate: 2019/3/23$ 13:54$
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    //数据层
    @Autowired
    private UserMapper userMapper;
    /**
     * 用户校验
     * @param data --数据
     * @param pramr1 --备用参数1
     * @param pramr2 --备用参数2
     * @param pramr3 --备用参数3
     *
     * data - > {
     * 	"username": "1123", --登陆号
     * 	"password": "1234",  --密码
     * }
     * @return
     */
    @Override
    public String UserVerification(String data, Object pramr1, Object pramr2, Object pramr3) {
        //返回的json对象
        JSONObject  resonjson = new JSONObject();
        // 字符串转json对象
        JSONObject  jsonObject =  JSONObject.parseObject(data);
        //获取登陆验证
        String user = jsonObject.getString("username");
        //获取密码
        String password = jsonObject.getString("password");
        //获取用户
        List<User> users =null;
        try {
            //请求获取用户
            users= userMapper.getUsersByCodeAndPassWord(user,password);
            if ( users != null && users.size()>0){//获取到用户
                resonjson.put(ConstantObj.RESPONSE_DATA_JSON_CODE_KEY,ConstantObj.SUCCESS_CODE);//程序异常
                resonjson.put(ConstantObj.RESPONSE_DATA_JSON_MESSAGE_KEY,ConstantObj.LOGIN_SUCCESS_MESSAGE);
                resonjson.put(ConstantObj.RESPONSE_DATA_JSON_DATA_KEY, JSON.toJSONString(users.get(0)));//数据
            }else {//未获取到用户
                resonjson.put(ConstantObj.RESPONSE_DATA_JSON_CODE_KEY,ConstantObj.FAIL_CODE);//程序异常
                resonjson.put(ConstantObj.RESPONSE_DATA_JSON_MESSAGE_KEY,ConstantObj.LOGIN_FAIL_MESSAGE_NULL);
                resonjson.put(ConstantObj.RESPONSE_DATA_JSON_DATA_KEY,"");//数据为空
            }
        } catch (Exception e) {
            resonjson.put(ConstantObj.RESPONSE_DATA_JSON_CODE_KEY,ConstantObj.PROGRAM_EXCEPTION_CODE);//程序异常
            resonjson.put(ConstantObj.RESPONSE_DATA_JSON_MESSAGE_KEY,ConstantObj.PROGRAM_EXCEPTION_MESSAGE);
            resonjson.put(ConstantObj.RESPONSE_DATA_JSON_DATA_KEY,"");//数据为空
            e.printStackTrace();
        }
        return resonjson.toJSONString();//返回数据
    }
}