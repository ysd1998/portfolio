package com.example.demo.entity.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Data
public class Books {
	
	@Id
	@Column(name = "book_id")
	@Getter
	@Setter
	private String book_id;
	
	
	@Column(name = "title")
	@Getter
	@Setter
	private String title;
	
	
	@Column(name = "auther")
	@Getter
	@Setter
	private String auther;
	
	
	@Column(name = "price")
	@Getter
	@Setter
	private String price;
	
	
	@Column(name = "type_id")
	@Getter
	@Setter
	private String type_id;
	
	
	@Column(name = "publisher")
	@Getter
	@Setter
	private String publisher;
	
	
	@Column(name = "year")
	@Getter
	@Setter
	private String year;
	
	
	@Column(name = "ex")
	@Getter
	@Setter
	private String ex;
	
	
	@Column(name = "other")
	@Getter
	@Setter
	private String other;
	
	@Column(name = "delete_flag")
	@Getter
	@Setter
	private String delete_flag;
	
	@Column(name = "insert_id")
	@Getter
	@Setter
	private String insert_id;
	
	@Column(name = "insert_day")
	@Getter
	@Setter
	private String insert_day;
	
	@Column(name = "update_id")
	@Getter
	@Setter
	private String update_id;
	
	@Column(name = "update_day")
	@Getter
	@Setter
	private String update_day;
	
	@Column(name = "delete_id")
	@Getter
	@Setter
	private String delete_id;
	
	
	@Column(name = "delete_day")
	@Getter
	@Setter
	private String delete_day;


}
