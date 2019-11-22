package com.song.demo.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ：song
 * @date ：Created in 2019/11/12 17:07
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class User  {
    private Integer id;
    private String userName;
    private String password;
    private String status;
    private Date createTime;
}
