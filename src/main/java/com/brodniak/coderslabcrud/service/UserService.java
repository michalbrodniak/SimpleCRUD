package com.brodniak.coderslabcrud.service;

import com.brodniak.coderslabcrud.model.Address;
import com.brodniak.coderslabcrud.model.User;
import com.brodniak.coderslabcrud.model.dto.UserDto;
import com.brodniak.coderslabcrud.model.mapper.UserMapper;
import com.brodniak.coderslabcrud.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	@Transactional
	public void saveUser(final UserDto userDto){
		userRepository.save(UserMapper.mapToUser(userDto));
	}

	public List<UserDto> getAllUsers(){
		return userRepository.findAll()
				.stream()
				.map(UserMapper::mapToUserDto)
				.toList();
	}

	public UserDto getUserBy(final Long id){
			final User user = userRepository.findById(id)
					.orElseThrow(() -> new RuntimeException(String.format("User with id: %s does not exist", id)));
			return UserMapper.mapToUserDto(user);
	}

	public UserDto updateUser(final UserDto userDto){
		User user = userRepository.findById(userDto.getId())
				.orElse(new User());

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());

		List<Address> addresses = UserMapper.mapToAddresses(userDto.getAddressList());

		addresses.forEach(address -> address.setUser(user));
		user.setAddressList(addresses);

		return UserMapper.mapToUserDto(userRepository.save(user));
	}

	@Transactional
	public void deleteUserBy(final Long id){
		userRepository.deleteById(id);
	}
}
