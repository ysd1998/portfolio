package com.example.demo.config.secondary;

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
@EnableJpaRepositories(basePackages = "com.example.demo.repository.secondary", entityManagerFactoryRef = "secondaryEntityManager", transactionManagerRef = "secondaryTransactionManager")
public class EmpDataSourceConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public DataSourceProperties secondaryProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@Autowired
	public DataSource secondaryDataSource(@Qualifier("secondaryProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Primary
	@Autowired
	public LocalContainerEntityManagerFactoryBean secondaryEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("secondaryDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("com.example.demo.entity.secondary")
				.persistenceUnit("secondary")
				.build();
	}

	@Bean
	@Primary
	@Autowired
	public JpaTransactionManager secondaryTransactionManager(
			@Qualifier("secondaryEntityManager") LocalContainerEntityManagerFactoryBean secondaryEntityManager) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(secondaryEntityManager.getObject());
		return transactionManager;
	}

}
