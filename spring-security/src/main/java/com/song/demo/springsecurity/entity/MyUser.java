package com.song.demo.springsecurity.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Song
 * @Date 2019/11/25 11:43
 * @Version 1.0
 */
@Data
public class MyUser implements Serializable {
    private static final long serialVersionUID = 8933206525216209512L;
    private String userName;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}
