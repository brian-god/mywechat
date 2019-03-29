package com.hugo.www.mywechat.application.user.service;

import com.hugo.www.mywechat.utils.WxResult;

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
    WxResult UserVerification(String username, String password, Object pramr1, Object pramr2, Object pramr3);

    WxResult getAllUser(int page,int rows);

    WxResult addUser();
}

