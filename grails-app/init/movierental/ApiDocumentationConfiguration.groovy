package movierental

import groovy.transform.PackageScope
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger2.annotations.EnableSwagger2
import static springfox.documentation.builders.PathSelectors.regex

@Configuration
@EnableSwagger2
@PackageScope
class ApiDocumentationConfiguration {
    //http://localhost:8080/v2/api-docs
    @Bean
    Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/.*"))
                .build().pathMapping("/")
                .apiInfo(metadata())
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Grails 3 SpringFox test API")
                .description("Grails 3 SpringFox test API")
                .version("1.0")
                .contact("")
                .build()
    }
}