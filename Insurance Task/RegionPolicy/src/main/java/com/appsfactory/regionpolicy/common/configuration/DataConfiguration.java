package com.appsfactory.regionpolicy.common.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.appsfactory.regionpolicy.infrastructure")
public class DataConfiguration {
}
