package com.bccoder.web.config;

import io.swagger.annotations.Api;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.FileReader;
import java.io.IOException;

@Configurable
public class SwaggerConfig {
    @Bean
    public Docket api() throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model =  reader.read(new FileReader("pom.xml"));
        ApiInfoBuilder builder = new ApiInfoBuilder()
                .title("Person Service Api Documentation")
                .description("Documentation automatically generated")
                .version(model.getVersion())
                .contact(new Contact("bccoder swagger","bccoder.com","1527587297@qq.com"));
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.bccoder.web.controller"))
                .paths(PathSelectors.any()).build()
                .apiInfo(builder.build());
    }
}
