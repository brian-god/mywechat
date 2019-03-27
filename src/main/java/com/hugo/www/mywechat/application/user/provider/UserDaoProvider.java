package com.hugo.www.mywechat.application.user.provider;

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
     * @param type -- 类型
     * @return
     */
    public String longVerification(String username,String password,String type){
        String Column_names = "mobile";//默认根据电话
        if (type != null || !"".equals(type)){
            if("2".equals(type)){
                Column_names = "email";//再根据邮箱
            }
            if("3".equals(type)){
                Column_names = "username"; //再根据用户名
            }
        }
        return "select * from fa_user where "+Column_names+"='"+username+"' and password= '"+password+"' and dr=0 ";
    }

}