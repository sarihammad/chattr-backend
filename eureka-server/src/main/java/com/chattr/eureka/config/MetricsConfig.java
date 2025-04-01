package com.chattr.eureka.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Bean
    @ConditionalOnProperty(name = "management.metrics.binders.processor.enabled", havingValue = "true", matchIfMissing = true)
    public ProcessorMetrics processorMetrics(MeterRegistry registry) {
        return null;
    }
}