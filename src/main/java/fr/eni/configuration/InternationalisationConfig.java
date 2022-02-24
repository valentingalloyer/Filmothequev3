package fr.eni.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class InternationalisationConfig implements WebMvcConfigurer {

    @Bean
    LocaleResolver localeResolver() {
        SessionLocaleResolver res = new SessionLocaleResolver();
        res.setDefaultLocale(Locale.FRENCH);
        return res;
    }

    @Bean
    LocaleChangeInterceptor changeInterceptor() {
        LocaleChangeInterceptor inter = new LocaleChangeInterceptor();
        inter.setParamName("lang");
        return inter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(changeInterceptor());
    }

}