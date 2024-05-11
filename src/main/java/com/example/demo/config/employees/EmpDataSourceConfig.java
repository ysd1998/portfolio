package com.example.demo.config.employees;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.repository.employees", entityManagerFactoryRef = "employeesEntityManager", transactionManagerRef = "employeesTransactionManager")
public class EmpDataSourceConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.employees")
	public DataSourceProperties employeesProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@Autowired
	public DataSource employeesDataSource(@Qualifier("employeesProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Primary
	@Autowired
	public LocalContainerEntityManagerFactoryBean employeesEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("employeesDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("com.example.demo.entity.employees")
				.persistenceUnit("employees")
				.build();
	}

	@Bean
	@Primary
	@Autowired
	public JpaTransactionManager employeesTransactionManager(
			@Qualifier("employeesEntityManager") LocalContainerEntityManagerFactoryBean employeesEntityManager) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(employeesEntityManager.getObject());
		return transactionManager;
	}

}
