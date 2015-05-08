package com.github.rmnasri.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;

/**
 * Created by riadh on 07/05/15.
 */
@Configuration
public class DatasourceConfiguration {

    @Bean
    @Autowired
    public DataSource dataSourceRecettes() {
        return fakeDataSource();
    }

    private DataSource fakeDataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/recettesDB");
        dataSource.setUsername("sa");
        dataSource.setMaxActive(1);
        return dataSource;
    }
}
