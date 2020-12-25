package kr.co.santapanda.config.swagger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocket(){
        List globalParameters = new ArrayList();
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(globalParameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.product.boilerplate.task"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    // 추후 Configuration 서버에서 관리되는 항목
    private ApiInfo getApiInfo(){
        return new ApiInfo(
                "BoilerPlate REST Service",
                "개발 공통 설정 서비스",
                "0.1.0",
                "",
                new Contact("yullin", "yullin.com", "chshin@yullin.com"),
                "",
                "",
                Collections.emptyList());
    }
}