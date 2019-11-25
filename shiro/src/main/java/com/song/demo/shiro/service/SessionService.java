package com.song.demo.shiro.service;

import com.song.demo.shiro.entity.UserOnline;

import java.util.List;

/**
 * @Author Song
 * @Date 2019/11/22 11:32
 * @Version 1.0
 */
public interface SessionService {
    /**
     * 查看所有在线用户
     * @return
     */
    List<UserOnline> list();

    /**
     * 根据sessionId踢人下线
     * @param sessionId
     * @return
     */
    boolean forceLogout(String sessionId);
}
