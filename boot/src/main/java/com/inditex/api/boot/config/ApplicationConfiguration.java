package com.inditex.api.boot.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.inditex.api")
@Configuration
@EntityScan(basePackageClasses = {com.inditex.api.application.h2.entity.PricesEntity.class})
@EnableJpaRepositories(basePackageClasses = { com.inditex.api.application.h2.repository.PricesRepository.class })
public class ApplicationConfiguration {
}
