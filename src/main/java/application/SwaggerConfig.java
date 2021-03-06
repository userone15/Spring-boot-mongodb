package application;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
                .apis(RequestHandlerSelectors.basePackage("application.controller"))
                .paths(regex("/product.*"))
                .build()
				.apiInfo(metaData());
				
	}
		
	@SuppressWarnings("deprecation")
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Rest API").description("Rest API implementation reference")
				.termsOfServiceUrl("").contact("").license("").licenseUrl("").version("1.0").build();
	}
}
