package com.song.multidatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.multidatasource.entity.User;
import com.song.multidatasource.mapper.UserMapper;
import com.song.multidatasource.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author Song
 * @Date 2020/7/28 11:19
 * @Version 1.0
 * @Description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 类上 {@code @DS("slave")} 代表默认从库，在方法上写 {@code @DS("master")} 代表默认主库
     *
     * @param user 用户
     */
    @DS("master")
    @Override
    public void addUser(User user) {
        baseMapper.insert(user);
    }

}
