package com.song.demo.shiro.mapper;

import com.song.demo.shiro.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Song
 * @Date 2019/11/22 8:42
 * @Version 1.0
 */
@Repository
public interface UserRoleMapper{
    List<Role> findByUserName(String userName);
}
