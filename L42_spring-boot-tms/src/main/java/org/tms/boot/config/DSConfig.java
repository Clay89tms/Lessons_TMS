package org.tms.boot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring")
@Getter @Setter
public class DSConfig {

    private Data datasource;

    @Getter @Setter
    public static class Data{
        private String url;
        private String username;
        private String password;
    }
}
