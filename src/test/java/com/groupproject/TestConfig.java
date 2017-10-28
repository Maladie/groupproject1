package com.groupproject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import pl.sdacademy.repository.CarRepository;
import pl.sdacademy.repository.ClientRepository;

/**
 * Created by RENT on 2017-10-28.
 */
@Configuration
@ComponentScan(basePackages = "pl", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {CarRepository.class, ClientRepository.class}))
public class TestConfig {
}
