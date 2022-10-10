package ru.awg.dao_spring_framework.dao.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.awg.dao_spring_framework")
public class SpringJdbcConfig {

    @Value("${dblogin}")
    private String login;

    @Value("${dbname}")
    private String name;

    @Value("${dbpassword}")
    private String password;

    @Value("${dbport}")
    private String port;

    @Value("${dbhost}")
    private String host;

    @Value("${dbdriver}")
    private String driver;

    @Value("${sqltype}")
    private String type;

    @Bean
    DataSource dataSource(){
        BasicDataSource dataSourceConfig = new BasicDataSource();
        dataSourceConfig.setDriverClassName(driver);
        dataSourceConfig.setUrl("jdbc:" + type + "://" + host + ":" + port + "/" + name);
        dataSourceConfig.setUsername(login);
        dataSourceConfig.setPassword(password);

        return dataSourceConfig;
    }
}