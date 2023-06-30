package com.brodniak.coderslabcrud.controller;

import com.brodniak.coderslabcrud.model.dto.UserDto;
import com.brodniak.coderslabcrud.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {

	private final UserService service;

	@GetMapping(path = "/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(service.getAllUsers());
	}

	@GetMapping(path = "/getUserBy")
	public ResponseEntity<UserDto> getUserById(@RequestParam Long id){
		return ResponseEntity.ok(service.getUserBy(id));
	}

	@PostMapping(path = "/saveUser")
	public void saveUser(@RequestBody UserDto user){
		service.saveUser(user);
	}

}
