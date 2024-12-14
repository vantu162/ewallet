package com.example.vimass_e_wallet;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class LocaleConfig implements WebMvcConfigurer {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowCredentials(true); // Cho phép cookie
//    }
    @Bean
    public LocaleResolver localeResolver() {

        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        // CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        Locale vietnamLocale = new Locale("vi", "VN");
        localeResolver.setDefaultLocale(vietnamLocale);
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");  // Query parameter to switch language
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Ánh xạ các tài nguyên tĩnh trong thư mục static
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/").setCachePeriod(0);

        // Ánh xạ các tài nguyên tĩnh từ thư mục ngoài
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("file:/path/to/your/resources/");
    }

    // registry.addViewController là một phương pháp được

// sử dụng để ánh xạ một URL đến một trang tĩnh mà không cần
// thông qua một controller. Điều này rất tiện lợi khi bạn chỉ cần trả về một trang view mà không cần xử lý logic.
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/account").setViewName("account");
//    }

}
