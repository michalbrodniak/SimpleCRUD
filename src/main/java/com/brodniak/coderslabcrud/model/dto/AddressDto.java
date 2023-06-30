package com.brodniak.coderslabcrud.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressDto {

	private String city;
	private String streetName;
	private Integer streetNumber;
}
