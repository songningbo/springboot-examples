package com.bccoder.annotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:test-import-resource.xml")
public class ImportResourceConfig {
}
