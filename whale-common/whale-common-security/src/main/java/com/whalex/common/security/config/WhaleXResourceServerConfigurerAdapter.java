package com.whalex.common.security.config;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@AllArgsConstructor
@Configuration
public class WhaleXResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {


    private final WhaleXIgnorPermissionsUrls whaleXIgnorPermissionsUrls;

    @Override
    @SneakyThrows
    public void configure(HttpSecurity httpSecurity) {
        // 允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
        httpSecurity.headers().frameOptions().disable();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        whaleXIgnorPermissionsUrls.getIgnoreUrls().forEach(url -> registry.antMatchers(url).permitAll());
        registry.anyRequest().authenticated().and().csrf().disable();
    }
}
