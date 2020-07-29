package com.song.multidatasource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.song.multidatasource.entity.User;

/**
 * @Author Song
 * @Date 2020/7/28 11:19
 * @Version 1.0
 * @Description
 */
public interface UserService extends IService<User> {

    /**
     * 添加 User
     *
     * @param user 用户
     */
    void addUser(User user);
}
