/**
 * Author       : Ramesh Gouru
 * Created date : 26/3/2022
 * Description  : this class describes the swagger configuration to test apis
 */

package com.hcl.hackaton.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.hcl.hackaton"))
                .build().apiInfo(apiInfo());
    }
    private ApiInfo apiInfo(){
        return new ApiInfo("portfolio api info", "PORTFOLIO ENDPOINTS","0.0.1",
                "", new Contact("","",""),"","", Collections.emptyList());
    }

}
