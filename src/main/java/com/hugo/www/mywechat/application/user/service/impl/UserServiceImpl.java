package com.hugo.www.mywechat.application.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hugo.www.mywechat.application.user.entity.User;
import com.hugo.www.mywechat.application.user.mapper.UserMapper;
import com.hugo.www.mywechat.application.user.service.UserService;
import com.hugo.www.mywechat.utils.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 *
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
     *
     * @param pramr1 --备用参数1
     * @param pramr2 --备用参数2
     * @param pramr3 --备用参数3
     *               <p>
     *               data - > {
     *               "username": "1123", --登陆号
     *               "password": "1234",  --密码
     *               }
     * @return
     */
    @Override
    public WxResult UserVerification(String username, String password, Object pramr1, Object pramr2, Object pramr3) {
   /*     //返回的json对象
        JSONObject resonjson = new JSONObject();
        // 字符串转json对象
        JSONObject jsonObject = JSONObject.parseObject(data);
        //获取登陆验证
        String user = jsonObject.getString("username");
        //获取密码
        String password = jsonObject.getString("password");*/
        //获取用户
        List<User> users = null;
        try {
            //请求获取用户
            users = userMapper.getUsersByCodeAndPassWord(username, password);
            if (users == null && users.size() < 0) {
                return WxResult.build(400,"用户名或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return   WxResult.build(400,"数据异常");
        }
        return   WxResult.build(200,"登录成功",users);
    }

    @Override
    public WxResult getAllUser(int page,int rows) {
        PageHelper.startPage(page, rows);
        List<User> allUser = userMapper.getAllUser();
        if (allUser.size() > 0 && allUser !=null){
            PageInfo<User> pageInfo = new PageInfo<>(allUser);
            return WxResult.build(200,"查询成功",pageInfo);
        }
        return WxResult.build(400,"未查到用户信息");
    }

    @Override
    public WxResult addUser() {
        return WxResult.build(400,"未查到用户信息");
    }
}