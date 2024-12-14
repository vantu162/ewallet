package com.example.vimass_e_wallet.security;


import com.example.vimass_e_wallet.services.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import java.util.Collections;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/static/**","/acc", API.instance.login,
//                        "/bank/**","/donvi/**",API.instance.chi_ho,API.instance.vpb_chi_ho).permitAll()
//                                .requestMatchers(HttpMethod.GET, "/transaction").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/loginv1").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/login").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/logout").permitAll()
//                        .requestMatchers("/aa").hasRole("ADMIN")
//                        .requestMatchers("/quantri","/quantri/vi/","/", "/vi/").hasRole("ADMIN")
//
//                        .requestMatchers("/", "/vi/").hasRole("USER")
//                        .requestMatchers("/bb").hasRole("USER")
//                        .requestMatchers("/saokeqr").hasRole("USER")
//                        .anyRequest().authenticated()
//
//                )
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // hoặc SessionCreationPolicy.ALWAYS
////                .maximumSessions(1) // Giới hạn số lượng session cho mỗi người dùng
////                .expiredUrl("/login?expired") // URL khi session hết hạn
////                .and()
//                .and()
//                .formLogin()
//                .loginPage("/acc") // Thay đổi URL trang đăng nhập tùy chỉnh
//                .permitAll()
//                .and()
//
//                .logout()
//                .logoutUrl("/logout") // Sử dụng logout URL tùy chỉnh
//
//                .logoutSuccessHandler(new CustomLogoutSuccessHandler())
//                .invalidateHttpSession(true) // Xóa phiên làm việc
//                .clearAuthentication(true) // Xóa thông tin xác thực
//                .permitAll(); // Cho phép tất cả người dùng thực hiện logout
//
//        return http.build();
//    }
//
//    @Bean
//    public SecurityContextRepository securityContextRepository() {
//        return new HttpSessionSecurityContextRepository();
//    }
//}

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers("/static/**","/acc","/", "/vi/", API.instance.login,
                        "/bank/**","/donvi/**",API.instance.chi_ho,API.instance.vpb_chi_ho).permitAll()
                                .antMatchers(HttpMethod.GET, "/transaction").permitAll()
                                .antMatchers(HttpMethod.POST, "/login").permitAll()
                                .antMatchers(HttpMethod.POST, "/logout").permitAll()
                        .antMatchers("/aa").hasRole("ADMIN")
                        .antMatchers("/quantri","/quantri/vi/","/index", "/index/vi/").hasRole("ADMIN")
                        .antMatchers("/bb").hasRole("USER")
                        .antMatchers("/saokeqr").hasRole("USER")
                        .antMatchers().authenticated()

                )
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // hoặc SessionCreationPolicy.ALWAYS
//                .maximumSessions(1) // Giới hạn số lượng session cho mỗi người dùng
//                .expiredUrl("/login?expired") // URL khi session hết hạn
//                .and()
                .and()
                .formLogin()
                .loginPage("/") // Thay đổi URL trang đăng nhập tùy chỉnh
                .permitAll()
                .and()

                .logout()
                .logoutUrl("/logout") // Sử dụng logout URL tùy chỉnh

                .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                .invalidateHttpSession(true) // Xóa phiên làm việc
                .clearAuthentication(true) // Xóa thông tin xác thực
                .permitAll(); // Cho phép tất cả người dùng thực hiện logout

    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }
}


