package com.pyb.tcpserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author pyb
 * @date 2021年05月22日 14:40
 */
@Configuration
@EnableSwagger2
@Import(taskConfig.class)
public class Swagger2Config {
    @Bean
    public Docket creatRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pyb.tcpserver.controller"))
                .paths(PathSelectors.regex("/cd.*")).build();
    }
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().
                title("A301常德市电磁锁项目后端接口")
                .description("测试接口")
                .termsOfServiceUrl("http://127.0.0.1:8080/")
                .version("V1.0")
                .build();
    }
}
