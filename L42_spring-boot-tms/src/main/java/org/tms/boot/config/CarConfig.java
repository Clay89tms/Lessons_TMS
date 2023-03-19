package org.tms.boot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "car")
@Getter @Setter
public class CarConfig {

    private Map<String, CarType> types;

    @Getter @Setter
    public static class CarType {
        private String name;
        private Integer age;
        private Color color;
    }

    public enum Color {
        BLACK,
        WHITE,
        RED
    }
}
