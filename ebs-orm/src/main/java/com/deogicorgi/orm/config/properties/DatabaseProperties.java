package com.deogicorgi.orm.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {

    private String host;
    private Integer port;
    private String db;
    private String username;
    private String password;
    private String maxSize;
}
