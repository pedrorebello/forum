package com.forum.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forum.forum.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
