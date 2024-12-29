package com.tdl.dutic2.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        String url = """
                jdbc:postgresql://%s:%s/%s?prepareThreshold=0
                """.formatted(
                        EnvConfig.get("DATABASE_HOST"),
                        EnvConfig.get("DATABASE_PORT"),
                        EnvConfig.get("DATABASE_NAME")
        );

        dataSource.setUrl(url);
        dataSource.setUsername(EnvConfig.get("DATABASE_USER"));
        dataSource.setPassword(EnvConfig.get("DATABASE_PASSWORD"));
        dataSource.setDriverClassName("org.postgresql.Driver");

        return dataSource;
    }
}
