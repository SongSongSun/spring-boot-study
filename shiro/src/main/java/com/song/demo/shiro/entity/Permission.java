package com.song.demo.shiro.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Song
 * @Date 2019/11/22 8:40
 * @Version 1.0
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = 7160557680614732403L;
    private Integer id;
    private String url;
    private String name;
}
