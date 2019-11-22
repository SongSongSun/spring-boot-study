package com.song.demo.shiro.common;

import lombok.Data;

/**
 * @author ：song
 * @date ：Created in 2019/11/12 17:48
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class ResultVO {
    private Integer code;
    private String message;

    public ResultVO(Integer code, String message){
        this.code = code;
        this.message =message;
    }
}
