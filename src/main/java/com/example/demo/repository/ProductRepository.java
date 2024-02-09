package com.example.demo.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;


public class ProductRepository {
	private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(@Qualifier("masterDataSource") DataSource dataSource) { // configクラスで設定したメソッド名と同じものを@Qualifierに
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List getAll() {
        String sql = "SELECT * FROM products";  // がんばってSQLを書く
        return jdbcTemplate.queryForList(sql, Product.class);
    }


}
