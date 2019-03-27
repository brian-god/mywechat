package com.hugo.www.mywechat.application.user.mapper;


import com.hugo.www.mywechat.application.user.entity.User;
import com.hugo.www.mywechat.application.user.provider.UserDaoProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 用户服务
 */
@Mapper
public interface UserMapper {
    /**
     * 根据账号查询
     * @return
     * @throws Exception
     */
    @SelectProvider(type = UserDaoProvider.class,method = "longVerification")
    List<User> getUsersByCodeAndPassWord(String username, String password, String type) throws  Exception;

    /**
     * 获取所有用户
     * @return
     */
    @Select("select * from fa_user")
    List<User> getAllUser();
}
