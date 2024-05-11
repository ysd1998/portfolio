package com.example.demo.config.clients;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.repository.clients", entityManagerFactoryRef = "clientsEntityManager", transactionManagerRef = "clientsTransactionManager")
public class UserDataSourceConfig {
	//データソース
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.clients")
	public DataSourceProperties clientsProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Autowired
	public DataSource clientsDataSource(@Qualifier("clientsProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean clientsEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("clientsDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("com.example.demo.entity.clients")
				.persistenceUnit("clients")
				.build();
	}

	@Bean
	@Autowired
	public JpaTransactionManager clientsTransactionManager(
			@Qualifier("clientsEntityManager") LocalContainerEntityManagerFactoryBean clientsEntityManager) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(clientsEntityManager.getObject());
		return transactionManager;
	}

}
