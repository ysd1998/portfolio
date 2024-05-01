package com.example.demo.entity.primary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Data
public class Clients {

	@Id
	@Column(name = "client_id")
	@Getter
	@Setter
	private String loginid;

	@Column(name = "name")
	@Getter
	@Setter
	private String name;

	@Column(name = "password")
	@Getter
	@Setter
	private String password;

}
