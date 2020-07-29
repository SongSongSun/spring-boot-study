package com.song.multidatasource.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.song.multidatasource.entity.User;
import com.song.multidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Song
 * @Date 2020/7/28 15:18
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping
    @DS("#header.tenantName")//从header获取
    public List<User> index() {
        List<User> list = userService.list();
        return list;
    }
}
