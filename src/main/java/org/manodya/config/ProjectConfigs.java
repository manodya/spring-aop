package org.manodya.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.manodya.*")
@EnableAspectJAutoProxy
public class ProjectConfigs {
}
