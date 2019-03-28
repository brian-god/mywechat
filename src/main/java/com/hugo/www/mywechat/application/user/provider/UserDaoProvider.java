package com.hugo.www.mywechat.application.user.provider;

import com.hugo.www.mywechat.utils.CheckUtils;

/**
 * 用户Sq处理
 * @ClassName: UserDaoProvider
 * @Description:
 * @Author: Hugo
 * @CreateDate: 2019/3/23$ 13:35$
 * @Version: 1.0
 */
public class UserDaoProvider {
    /**
     * 登陆验证SQL
     * @param username -- 账号
     * @param password -- 密码
     * @return
     */
    public String longVerification(String username,String password){
        String Column_names =   "username"; //默认根用户名
        if(CheckUtils.isMobile(username)){//验证是不是手机号
            Column_names = "mobile"; //再根据手机号
        }
        if(CheckUtils.checkEmail(username)){//验证是否是邮箱
            Column_names = "email";//再根据邮箱
        }
        return "select * from fa_user where "+Column_names+"='"+username+"' and password= '"+password+"' and dr=0 ";
    }

}