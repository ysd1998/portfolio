package com.example.demo.entity.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "types")
@Data
public class Types {

	@Id
	@Column(name = "type_id")
	@Getter
	@Setter
	private String typeid;

	@Column(name = "name")
	@Getter
	@Setter
	private String name;

}
