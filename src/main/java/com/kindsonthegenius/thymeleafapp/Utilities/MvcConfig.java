package com.kindsonthegenius.thymeleafapp.Utilities;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/",
            "classpath:/resources/",
            "classpath:/static/",
            "classpath:/public/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/").resourceChain(false);

        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/","/resources/static/css/","/resources/static/js/","/resources/static/summernote/","/resources/static/fonts/");
    }

}