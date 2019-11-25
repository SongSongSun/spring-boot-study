package com.song.demo.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：song
 * @date ：Created in 2019/11/12 17:07
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@TableName("t_user")
public class User implements Serializable {

    private Integer id;
    private String username;
    private String passwd;
    private String status;
    private Date createTime;
}
