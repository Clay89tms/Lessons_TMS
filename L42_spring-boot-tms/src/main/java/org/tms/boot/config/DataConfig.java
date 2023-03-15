package org.tms.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.tms.boot.service.BookService;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class DataConfig {

    @Value(value = "${car.types[0]}")
    private String types;

    @Value("${spring.datasource.ur:world}")
    private String url;
    @Value("${spring.datasource.username:world}")
    private String username;
    @Value("${spring.datasource.password:world}")
    private String password;

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setUrl(url);
        source.setUsername(username);
        source.setPassword(password);
        return source;
    }

    @Bean
//    @ConditionalOnMissingClass(value = "org.example")
    @ConditionalOnProperty(value = "book.service", havingValue = "true")
    BookService bookService(){
        return new BookService();
    }
}
