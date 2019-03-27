package com.hugo.www.mywechat.application.user.service;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 用户验证接口
     * @param data --数据
     * @param pramr1 --备用参数1
     * @param pramr2 --备用参数2
     * @param pramr3 --备用参数3
     * @return
     */
    String UserVerification(String data,Object pramr1,Object pramr2,Object pramr3);
}

