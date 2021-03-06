package com.dsebproj.recipesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@SpringBootApplication
public class RecipeSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeSiteApplication.class, args);
    }
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource2")
//    public DataSource secondaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }

}

