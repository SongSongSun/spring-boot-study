package com.song.demo.shiro.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Song
 * @Date 2019/11/22 8:40
 * @Version 1.0
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -227437593919820521L;
    private Integer id;
    private String name;
    private String memo;
}
