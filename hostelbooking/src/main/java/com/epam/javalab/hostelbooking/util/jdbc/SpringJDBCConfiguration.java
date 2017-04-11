package com.epam.javalab.hostelbooking.util.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

@Configuration
@ImportResource("classpath:Spring.xml")
public class SpringJDBCConfiguration {
    private static final String DATABASE_BUNDLE = "properties.db";
    private static final String DATABASE_DRIVER = "jdbc.driverClassName";
    private static final String DATABASE_URL = "jdbc.url";
    private static final String DATABASE_USERNAME = "jdbc.username";
    private static final String DATABASE_PASSWORD = "jdbc.password";

    @Bean
    public DataSource dataSource() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(DATABASE_BUNDLE);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(resourceBundle.getString(DATABASE_DRIVER));
        dataSource.setUrl(resourceBundle.getString(DATABASE_URL));
        dataSource.setUsername(resourceBundle.getString(DATABASE_USERNAME));
        dataSource.setPassword(resourceBundle.getString(DATABASE_PASSWORD));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

}
