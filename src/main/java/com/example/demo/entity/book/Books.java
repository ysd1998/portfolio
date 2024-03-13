package com.example.demo.entity.book;


import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Data
public class Books {
	
	@Id
//	@EmbeddedId
	@Column(name = "book_id")
//	(generator = "idGenerator")
//	@UuidGenerator
	@Getter
	@Setter
	private String bookid;
	
	
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
	@OneToOne
	@JoinColumn(name = "type_id")
	private String typeid;
	
	
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
	@CreatedDate
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
	private String delete_day;
	
//	@Override
//	  @Deprecated
//	  public int getId() {
//	    return null;
//	  }
//
//	  @Override
//	  public boolean isNew() {
//	    // save時のSELECT防止のため、新規エンティティとして認識させるためにtrueを返す。
//	    return true;
//	  }


}
