package com.brodniak.coderslabcrud.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "user_table")
@Data
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long userId;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;

	@Column(name = "addresses")
	@OneToMany(cascade = CascadeType.ALL,  mappedBy = "user")
	private List<Address> addressList;

}
