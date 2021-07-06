package com.example.kpsec.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()){
            logger.info("URL: " + connection.getMetaData().getURL() + ", USER: " + connection.getMetaData().getUserName());
            Statement statement = connection.createStatement();
            // test_create table, insert data
            String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID) )";
            statement.executeUpdate(sql);
        }
        jdbcTemplate.execute("INSERT INTO USER VALUES(1, 'testuser')");
    }
}