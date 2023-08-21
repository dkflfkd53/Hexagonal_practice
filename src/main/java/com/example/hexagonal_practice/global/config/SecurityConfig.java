package com.example.hexagonal_practice.global.config;

import com.example.hexagonal_practice.global.error.GlobalExceptionFilter;
import com.example.hexagonal_practice.global.security.auth.PrincipalOauth2UserService;
import com.example.hexagonal_practice.global.security.jwt.JwtFilter;
import com.example.hexagonal_practice.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    private final ObjectMapper objectMapper;

    private final PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

        JwtFilter jwtTokenFilter = new JwtFilter(jwtTokenProvider);
        GlobalExceptionFilter globalExceptionFilter = new GlobalExceptionFilter(objectMapper);

        httpSecurity
                .csrf().disable()
                .cors().and()
                .exceptionHandling()

                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/login", "/signup", "/refresh").permitAll()
                .antMatchers("/board/**", "/user/**", "/pot/**", "/security-login/info").authenticated()
                .anyRequest().permitAll()
                .and()

                .formLogin()

                .usernameParameter("loginId")
                .passwordParameter("password")
                .loginPage("/security-login/login")
                .defaultSuccessUrl("/security-login")
                .failureUrl("/security-login/login")
                .and()
                .logout()
                .logoutUrl("/security-login/logout")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID")


                .and()
                .oauth2Login()
                .loginPage("/security-login/login")
                .defaultSuccessUrl("/security-login")
                .userInfoEndpoint()
                .userService(principalOauth2UserService);

        httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.addFilterAfter(globalExceptionFilter, JwtFilter.class);

        return httpSecurity.build();
    }

}
