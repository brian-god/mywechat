package com.hugo.www.mywechat.constant;


/**
 * 项目常量
 * @ClassName: ConstantObj
 * @Description:
 * @Author: Hugo
 * @CreateDate: 2019/3/23$ 13:49$
 * @Version: 1.0
 */
public interface ConstantObj {
    String SUCCESS_CODE ="200";
    String FAIL_CODE ="300";
    String PROGRAM_EXCEPTION_CODE="500";
    String DELETE_SUCCESS_MESSAGE ="删除成功";
    String INSERT_SUCCESS_MESSAGE ="插入成功";
    String SAVE_SUCCESS_MESSAGE ="保存成功";
    String PROGRAM_EXCEPTION_MESSAGE ="程序异常";
    String SAVE_FAIL_MESSAGE ="保存失败";
    String INSERT_FAIL_MESSAGE ="插入失败";
    String SELECT_SUCCESS_MESSAGE ="查询成功";
    String SELECT_FAIL_MESSAGE ="查询失败";
    String INSERT_USER_FAIL_MESSAGE="用户已存在";
    String LOGIN_SUCCESS_MESSAGE="登陆成功";
    String LOGIN_FAIL_PROGRAM_MESSAGE="登陆失败，程序异常！！";
    String LOGIN_FAIL_MESSAGE="登陆失败，账号或密码错误！！";
    String LOGIN_FAIL_MESSAGE_NULL="账号或密码错误！！";
    String RESPONSE_DATA_JSON_CODE_KEY="code";
    String RESPONSE_DATA_JSON_MESSAGE_KEY="message";
    String RESPONSE_DATA_JSON_DATA_KEY="data";
}
