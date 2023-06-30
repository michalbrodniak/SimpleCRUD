package com.brodniak.coderslabcrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Entity
@Table(name = "address_table")
@Data
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long addressId;
	@Column(name = "city")
	private String city;
	@Column(name = "streetName")
	private String streetName;
	@Column(name = "streetNumber")
	private Integer streetNumber;

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

}
