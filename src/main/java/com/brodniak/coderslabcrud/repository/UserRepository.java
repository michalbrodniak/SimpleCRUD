package com.brodniak.coderslabcrud.repository;

import com.brodniak.coderslabcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
