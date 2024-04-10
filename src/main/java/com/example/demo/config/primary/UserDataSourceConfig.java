package com.example.demo.config.primary;

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
@EnableJpaRepositories(
    basePackages = "com.example.demo.repository.primary",
    entityManagerFactoryRef = "primaryEntityManager",
    transactionManagerRef = "primaryTransactionManager"
)
public class UserDataSourceConfig {
	
	  @Bean
	  @ConfigurationProperties(prefix = "spring.datasource.primary")
	  public DataSourceProperties primaryProperties() {
	    return new DataSourceProperties();
	  }

	  @Bean
	  @Autowired
	  public DataSource primaryDataSource(@Qualifier("primaryProperties")
	      DataSourceProperties properties) {
	    return properties.initializeDataSourceBuilder().build();
	  }

	  @Bean
	  @Autowired
	  public LocalContainerEntityManagerFactoryBean primaryEntityManager(EntityManagerFactoryBuilder builder,@Qualifier("primaryDataSource") DataSource dataSource){
	    return builder.dataSource(dataSource)
	        .packages("com.example.demo.entity.primary")
	        .persistenceUnit("primary")
	        .build();
	  }

	  @Bean
	  @Autowired
	  public JpaTransactionManager primaryTransactionManager(@Qualifier("primaryEntityManager") LocalContainerEntityManagerFactoryBean primaryEntityManager) {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(primaryEntityManager.getObject());
	    return transactionManager;
	  }
	  
}
