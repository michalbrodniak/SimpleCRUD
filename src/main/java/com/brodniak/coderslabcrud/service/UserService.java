package com.brodniak.coderslabcrud.service;

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
}
