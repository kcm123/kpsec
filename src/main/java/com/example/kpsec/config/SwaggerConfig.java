package com.example.kpsec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;

@Configuration // http://localhost:8080/swagger-ui.html
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("특정 고객 거래내역 조회 서비스")
                .description("고객을 타겟팅 하기 위한 지점 마케팅 API를 개발하려 합니다.<br>데이타에는 거래내역, 고객, 지점정보가 있습니다. 각 데이타를 활용하여 아래 기능명세에 대한 API를 개발하고 각 기능별 Unit Test 코드를 개발하세요.")
                .build();
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())//스웨거 설명
                .groupName("swg-group1")//빈설정을 여러개 해줄경우 구분하기 위한 구분자.
                .select()//apis, paths를 사용하주기 위한 builder
                .apis(RequestHandlerSelectors.basePackage("com.example.kpsec.apiService.web"))//탐색할 클래스 필터링
                .paths(PathSelectors.any())//스웨거에서 보여줄 api 필터링
                .build();
    }
}
