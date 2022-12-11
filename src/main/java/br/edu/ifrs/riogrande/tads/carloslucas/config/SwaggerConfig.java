package br.edu.ifrs.riogrande.tads.carloslucas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apidoc() {
		return new Docket(DocumentationType.SWAGGER_2)
			.useDefaultResponseMessages(false)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex(
						"/api/v1/*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
						.description("API teste de ACL")
						.title("ACL - Access Control List")
						.version("1.0.0")
						.build();
	}

}
