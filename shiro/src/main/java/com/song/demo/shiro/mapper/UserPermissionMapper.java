package com.song.demo.shiro.mapper;

import com.song.demo.shiro.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Song
 * @Date 2019/11/22 8:44
 * @Version 1.0
 */
@Repository
public interface UserPermissionMapper {
    List<Permission> findByUserName(String userName);
}
