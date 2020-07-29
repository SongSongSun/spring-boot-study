package com.song.demo.springsecurityoauth2.controller;

import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * @Author Song
 * @Date 2019/12/2 17:01
 * @Version 1.0
 */
@RestController
public class UserController {
    @GetMapping("index")
    public Object index(@AuthenticationPrincipal Authentication authentication, HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = StringUtils.substringAfter(header, "bearer ");
        return Jwts.parser().setSigningKey("test_key".getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
    }
}
