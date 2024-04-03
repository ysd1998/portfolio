package com.example.demo.entity.book;


import java.sql.Blob;

import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@SQLRestriction("delete_flag <> 1")
@Data
public class Books {
	
	@Id
//	@EmbeddedId
	@Size(min = 0, max = 10)
	@Column(name = "book_id")
//	(generator = "idGenerator")
//	@UuidGenerator
	@Getter
	@Setter
	private String bookid;
	
	
	@Column(name = "title")
	@Size(min = 0, max = 10)
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
	private String typeid;
//	@OneToOne
//	@JoinColumn(name = "type_id")
//	private Types typeid;
	
	
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
	private String deleteflag;
	
	@Column(name = "insert_id")
	@Getter
	@Setter
	private String insertid;
	
	@Column(name = "insert_day")
	@Getter
	@Setter
	@CreatedDate
	private String insertday;
	
	@Column(name = "update_id")
	@Getter
	@Setter
	private String updateid;
	
	@Column(name = "update_day")
	@Getter
	@Setter
	private String updateday;
	
	@Column(name = "delete_id")
	@Getter
	@Setter
	private String deleteid;
	
	
	@Column(name = "delete_day")
	@Getter
	@Setter
	private String deleteday;
	
	@Column(name = "photo")
	@Getter
	@Setter
	private Blob photo;
	
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
