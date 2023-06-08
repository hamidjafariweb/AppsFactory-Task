package com.appsfactory.mileagepolicy.common.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.appsfactory.mileagepolicy.infrastructure")
public class DataConfiguration {
}
