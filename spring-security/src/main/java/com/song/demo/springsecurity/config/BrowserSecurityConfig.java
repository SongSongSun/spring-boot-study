package com.song.demo.springsecurity.config;

import com.song.demo.springsecurity.filter.ValidateCodeFilter;
import com.song.demo.springsecurity.validate.smscode.SmsAuthenticationConfig;
import com.song.demo.springsecurity.validate.smscode.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @Author Song
 * @Date 2019/11/25 11:55
 * @Version 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private MyAuthenticationSucessHandler authenticationSucessHandler;
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private SmsCodeFilter smsCodeFilter;
    @Autowired
    private SmsAuthenticationConfig smsAuthenticationConfig;
    @Autowired
    private MySessionExpiredStrategy sessionExpiredStrategy;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 添加验证码校验过滤器
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                // 添加短信验证码校验过滤器
            .addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin() // 表单登录
                    // http.httpBasic() // HTTP Basic
                    .loginPage("/authentication/require")
                    .loginProcessingUrl("/login")
                    // 处理登录成功
                    .successHandler(authenticationSucessHandler)
                    // 处理登录失败
                    .failureHandler(authenticationFailureHandler)
                    .and()
                .rememberMe()
                    // 配置 token 持久化仓库
                    .tokenRepository(persistentTokenRepository())
                    // remember 过期时间，单为秒
                    .tokenValiditySeconds(3600)
                    // 处理自动登录逻辑
                    .userDetailsService(userDetailService)
                    .and()
                .authorizeRequests() // 授权配置
                    .antMatchers("/authentication/require","/login.html","/css/**","/image/*","/code/image","/code/sms","/signout/success","/session/invalid")
                        .permitAll()
                    .anyRequest()  // 所有请求
                    .authenticated() // 都需要认证
                    .and()
                .sessionManagement() // 添加 Session管理器
                // Session失效后跳转到这个链接
                    .invalidSessionUrl("/session/invalid")
                    .maximumSessions(1)
                    //当到达最大session个数后，将不再允许后面的session登录
                    .maxSessionsPreventsLogin(true)
                    .expiredSessionStrategy(sessionExpiredStrategy)
                    .and()
                .and()
                .logout()
                .logoutUrl("/signout")
                .logoutSuccessUrl("/signout/success")
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable()
                // 将短信验证码认证配置加到 Spring Security 中
                .apply(smsAuthenticationConfig);
    }
}
