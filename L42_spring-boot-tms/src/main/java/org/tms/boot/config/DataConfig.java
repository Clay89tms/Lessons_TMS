package org.tms.boot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequiredArgsConstructor
public class DataConfig {


    private final CarConfig config;

    private final DSConfig dsConfig;


    @Bean
    DataSource dataSource(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setUrl(dsConfig.getDatasource().getUrl());
        source.setUsername(dsConfig.getDatasource().getUsername());
        source.setPassword(dsConfig.getDatasource().getPassword());
        return source;
    }

    @Bean
//    @ConditionalOnMissingClass(value = "org.example")
    @ConditionalOnProperty(value = "book.service", havingValue = "true")
    BookService bookService(){
        return new BookService();
    }
}
