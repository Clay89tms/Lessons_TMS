package org.tms.boot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties (prefix = "file")
@Getter @Setter
public class PathConfig {

    private CreatePath createPath;

    @Getter @Setter
    public static class CreatePath{
        private String path;
        private String name;
    }

}
