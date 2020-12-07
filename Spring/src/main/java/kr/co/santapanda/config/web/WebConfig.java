package kr.co.santapanda.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Component("corsConfigBean")
public class WebConfig implements WebMvcConfigurer {
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        	.allowedOrigins("*")
        	.allowedMethods(
        	    	HttpMethod.GET.name(),
        	    	HttpMethod.HEAD.name(),
        	    	HttpMethod.POST.name(),
        	    	HttpMethod.PUT.name(),
        	    	HttpMethod.DELETE.name());
    }


}
