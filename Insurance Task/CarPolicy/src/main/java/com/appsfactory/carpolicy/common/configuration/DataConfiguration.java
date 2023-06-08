package com.appsfactory.carpolicy.common.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.appsfactory.carpolicy.infrastructure")
public class DataConfiguration {
}
