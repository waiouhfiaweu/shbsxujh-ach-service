package com.cobis.core.ach.application;

import com.banistmo.service.bsl.serv.config.BisAutoConfiguration;
import com.cobis.core.ach.achrest.AchServiceAppConfig;
import com.cobis.core.ach.processing.ProcessingAppConfig;
import com.cobis.core.ach.transform.TransformAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TransformAppConfig.class, ProcessingAppConfig.class, AchServiceAppConfig.class})
@ComponentScan(basePackageClasses = BisAutoConfiguration.class)
public class AchApplication {
    public static void main(String[] args) {
        SpringApplication.run(AchApplication.class, args);
    }
}
