package com.tdl.dutic2.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        Dotenv dotenv = Dotenv.load();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        String url = """
                jdbc:postgresql://%s:%s/%s?prepareThreshold=0
                """.formatted(
                        dotenv.get("DATABASE_HOST"),
                        dotenv.get("DATABASE_PORT"),
                        dotenv.get("DATABASE_NAME")
        );

        dataSource.setUrl(url);
        dataSource.setUsername(dotenv.get("DATABASE_USER"));
        dataSource.setPassword(dotenv.get("DATABASE_PASSWORD"));
        dataSource.setDriverClassName("org.postgresql.Driver");

        return dataSource;
    }
}
