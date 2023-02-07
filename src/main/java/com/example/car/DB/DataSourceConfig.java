package com.example.car.DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource FirstDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("database1.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("database1.datasource.url"));
        dataSource.setUsername(env.getProperty("database1.datasource.username"));
        dataSource.setPassword(env.getProperty("database1.datasource.password"));
        return dataSource;
    }

    @Bean
    public DataSource SecondDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("database2.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("database2.datasource.url"));
        dataSource.setUsername(env.getProperty("database2.datasource.username"));
        dataSource.setPassword(env.getProperty("database2.datasource.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplateOne(@Qualifier("FirstDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }

    @Bean
    public JdbcTemplate jdbcTemplateTwo(@Qualifier("SecondDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }

}
