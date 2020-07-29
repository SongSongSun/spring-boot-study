package com.song.demo.springsecurityoauth2.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Song
 * @Date 2019/12/2 16:33
 * @Version 1.0
 */
@Data
public class MyUser implements Serializable {
    private static final long serialVersionUID = -2437006486962350391L;

    private String userName;
    private String password;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
}
