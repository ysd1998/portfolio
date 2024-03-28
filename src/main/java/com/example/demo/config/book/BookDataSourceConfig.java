package com.example.demo.config.book;

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
    basePackages = "com.example.demo.repository.book",
    entityManagerFactoryRef = "bookEntityManager",
    transactionManagerRef = "bookTransactionManager"
)
public class BookDataSourceConfig {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.book")
  public DataSourceProperties bookProperties() {
    return new DataSourceProperties();
  }

  @Bean
  @Autowired
  public DataSource bookDataSource(@Qualifier("bookProperties")
      DataSourceProperties properties) {
    return properties.initializeDataSourceBuilder().build();
  }

  @Bean
  @Autowired
  public LocalContainerEntityManagerFactoryBean bookEntityManager(EntityManagerFactoryBuilder builder,@Qualifier("bookDataSource") DataSource dataSource){
    return builder.dataSource(dataSource)
        .packages("com.example.demo.entity.book")
        .persistenceUnit("book")
        .build();
  }

  @Bean
  @Autowired
  public JpaTransactionManager bookTransactionManager(@Qualifier("bookEntityManager") LocalContainerEntityManagerFactoryBean bookEntityManager) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(bookEntityManager.getObject());
    return transactionManager;
  }
  
}
