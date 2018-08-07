package org.jerry.light4j.member.common.dataSource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DataSourceConfig {

	@Bean(name = "memberDataSource")
    @Qualifier("memberDataSource")
    @ConfigurationProperties(prefix="spring.datasource.member")
    public DataSource memberDataSource() {
        return DataSourceBuilder.create().build();
    }
	
	@Bean(name = "systemDataSource")
    @Qualifier("systemDataSource")
    @ConfigurationProperties(prefix="spring.datasource.system")
    public DataSource systemDataSource() {
        return DataSourceBuilder.create().build();
    }
}
