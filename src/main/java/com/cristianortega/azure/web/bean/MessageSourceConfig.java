package com.cristianortega.azure.web.bean;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MessageSourceConfig implements WebMvcConfigurer {

    private static final String PATH = "classpath:messages";
    private static final String UTF8 = "UTF-8";

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(PATH);
        messageSource.setDefaultEncoding(UTF8);
        return messageSource;
    }
}