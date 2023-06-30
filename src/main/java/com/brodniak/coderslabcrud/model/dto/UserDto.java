package com.brodniak.coderslabcrud.model.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private Long id;
	private String firstName;
	private String lastName;
	private List<AddressDto> addressList;
}
