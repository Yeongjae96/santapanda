package kr.co.santapanda.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

	private static final String[] EXCLUDE_PATHS = {
			"/api/user/**",
            "/error/**"
	};
	
	private final JwtInterceptor jwtInerceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInerceptor)
				.addPathPatterns("/**")
				.excludePathPatterns(EXCLUDE_PATHS);
	}
}
