package com.example.demo.config.primary;

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
@EnableJpaRepositories(
    basePackages = "com.example.demo.repository.primary",
    entityManagerFactoryRef = "primaryEntityManager",
    transactionManagerRef = "primaryTransactionManager"
)
public class BatchDataSourceConfig {
	  @Bean
	  @Primary
	  @ConfigurationProperties(prefix = "spring.datasource.primary")
	  public DataSourceProperties primaryProperties() {
	    return new DataSourceProperties();
	  }

	  @Bean
	  @Primary
	  @Autowired
	  public DataSource primaryDataSource(@Qualifier("primaryProperties")
	      DataSourceProperties properties) {
	    return properties.initializeDataSourceBuilder().build();
	  }

	  @Bean
	  @Primary
	  @Autowired
	  public LocalContainerEntityManagerFactoryBean primaryEntityManager(EntityManagerFactoryBuilder builder,@Qualifier("primaryDataSource") DataSource dataSource){
	    return builder.dataSource(dataSource)
	        .packages("com.example.demo.entity.primary")
	        .persistenceUnit("primary")
	        .build();
	  }


	  @Bean
	  @Primary
	  @Autowired
	  public JpaTransactionManager primaryTransactionManager(@Qualifier("primaryEntityManager") LocalContainerEntityManagerFactoryBean primaryEntityManager) {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(primaryEntityManager.getObject());
	    return transactionManager;
	  }
	  
//	  @Bean
//	  @Primary
//	  @Autowired
//	  public LocalContainerEntityManagerFactoryBean myEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("myDataSource") DataSource dataSource){
//		  return builder.dataSource(dataSource)
//		    .packages("\"com.example.demo.entity.primary")
//		    .properties(new HashMap<>(){
//		      {
//		        put("hibernate.physical_naming_strategy", PhysicalNamingStrategy.class.getName());
//		        put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
//		      }
//		    })
//		    .build();
//		}
}
