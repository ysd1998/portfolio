package com.example.demo.entity.book;

import java.io.File;
import java.nio.file.Files;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
	@Size(min = 0, max = 10)
	@Column(name = "book_id")
	@Getter
	@Setter
	private String bookid;

	@Column(name = "title")
	@Length(min = 0, max = 10)
	@Getter
	@Setter
	private String title;

	@Column(name = "auther")
	@Length(min = 0, max = 10)
	@Getter
	@Setter
	private String auther;

	@Column(name = "price")
	@Length(min = 0, max = 10)
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
	@Length(min = 0, max = 8)
	@Getter
	@Setter
	private String publisher;

	@Column(name = "year")
	@Getter
	@Setter
	private String year;

	@Column(name = "ex")
	@Length(min = 0, max = 1000)
	@Getter
	@Setter
	private String ex;

	@Column(name = "other")
	@Length(min = 0, max = 1000)
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
	@Lob
	private byte[] photo;

	@Transient
	private MultipartFile photoFile;

	//	@Getter
	//	@Setter
	//	private String base64;
	//
	public String base64photo() throws Exception {
		String base64;
		String result;
		StringBuffer data = new StringBuffer();
		if (this.photo == null) {
			File fileImg = new File("src/main/resources/templates/picture/20200501_noimage.png");
			byte[] byteImg = Files.readAllBytes(fileImg.toPath());
			base64 = new String(Base64.encodeBase64(byteImg, true), "ASCII");
			data.append("data:image/png;base64,");
			data.append(base64);
		} else {
			base64 = new String(Base64.encodeBase64(this.photo, true), "ASCII");

			data.append("data:image/png;base64,");
			data.append(base64);
		}
		result = data.toString();
		return result;
	}

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
