package com.ghj.hound.config;


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
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.ghj.hound.api"))
                .paths(PathSelectors.any()).build();
    }

    @SuppressWarnings("deprecation")
    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("mediation")
                .description("mediation api-docs")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

}

//"com.utstar.mediation.controller"
/*
@Configuration
@EnableSwagger
@ComponentScan("com.utstar.mediation.controller")
public class SwaggerConfig {


    private SpringSwaggerConfig springSwaggerConfig;

    */
/**
     * Required to autowire SpringSwaggerConfig
     *//*

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)
    {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    */
/**
     * Every SwaggerSpringMvcPlugin bean is picked up by the config-mvc
     * framework - allowing for multiple config groups i.e. same code base
     * multiple config resource listings.
     *//*

    @Bean
    public SwaggerSpringMvcPlugin customImplementation()
    {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(".*?");
    }

    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "ut-mediation",
                "ut-mediation api",
                "",
                "hjgan@utstar.com",
                "",
                "");

        return apiInfo;
    }
}
*/

