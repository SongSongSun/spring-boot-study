package com.song.demo.springsecurity.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author Song
 * @Date 2019/11/25 15:51
 * @Version 1.0
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -3856341093202053178L;

    public ValidateCodeException(String message) {
        super(message);
    }
}
