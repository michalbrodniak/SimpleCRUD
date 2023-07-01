package com.brodniak.coderslabcrud.model.mapper;

import com.brodniak.coderslabcrud.model.Address;
import com.brodniak.coderslabcrud.model.User;
import com.brodniak.coderslabcrud.model.dto.AddressDto;
import com.brodniak.coderslabcrud.model.dto.UserDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserMapper {

	public static User mapToUser(final UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());

		List<Address> addresses = mapToAddresses(userDto.getAddressList());
		addresses.forEach(address -> address.setUser(user));

		user.setAddressList(addresses);
		return user;
	}

	public static UserDto mapToUserDto(final User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getUserId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setAddressList(mapToAddressesDto(user.getAddressList()));
		return userDto;
	}

	public static List<Address> mapToAddresses(final List<AddressDto> addressDtoList) {
		return Optional.ofNullable(addressDtoList)
				.orElse(List.of())
				.stream()
				.map(UserMapper::mapToAddress)
				.collect(Collectors.toList());

	}

	private static AddressDto mapToAddressDto(final Address address) {
		AddressDto addressDto = new AddressDto();
		addressDto.setCity(address.getCity());
		addressDto.setStreetName(address.getStreetName());
		addressDto.setStreetNumber(address.getStreetNumber());
		return addressDto;
	}

	private static List<AddressDto> mapToAddressesDto(final List<Address> addressList) {
		return Optional.ofNullable(addressList)
				.orElse(List.of())
				.stream()
				.map(UserMapper::mapToAddressDto)
				.collect(Collectors.toList());

	}

	private static Address mapToAddress(final AddressDto addressDto) {
		Address address = new Address();
		address.setCity(addressDto.getCity());
		address.setStreetName(addressDto.getStreetName());
		address.setStreetNumber(addressDto.getStreetNumber());
		return address;
	}

	private static User updateUser(final UserDto userDto){
		return mapToUser(userDto);
	}
}
