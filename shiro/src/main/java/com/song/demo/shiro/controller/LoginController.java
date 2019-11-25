package com.song.demo.shiro.controller;


import com.song.demo.shiro.common.ResultVO;
import com.song.demo.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：song
 * @date ：Created in 2019/11/12 17:43
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultVO login(String username, String password,Boolean rememberMe) {
        System.out.println(username+password);
        // 密码MD5加密
        UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return new ResultVO(1,"成功");
        } catch (UnknownAccountException e) {
            return new ResultVO(-1,e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return new ResultVO(-1,e.getMessage());
        } catch (LockedAccountException e) {
            return new ResultVO(-1,e.getMessage());
        } catch (AuthenticationException e) {
            return new ResultVO(-1,"认证失败");
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user.toString());
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }
}
