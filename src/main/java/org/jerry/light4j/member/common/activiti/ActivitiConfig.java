/*package org.jerry.light4j.member.common.activiti;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

*//**
 * 配置activiti工作流引擎
 * @author jian
 *
 *//*
@Configuration
public class ActivitiConfig {

	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	private DataSource dataSource;
	  
	
	@Bean
	public SpringProcessEngineConfiguration getProcessEngineConfiguration(){
	  SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
      config.setDataSource(dataSource);
	  config.setTransactionManager(transactionManager);
	  config.setDatabaseType("mysql");
	  config.setDatabaseSchemaUpdate("true");
	  return config;
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
*/