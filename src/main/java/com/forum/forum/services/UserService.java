package com.forum.forum.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.forum.dto.UserDTO;
import com.forum.forum.entities.User;
import com.forum.forum.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public UserDTO insert(UserDTO dto) {
		User user = new User(null, dto.getName(), dto.getImgUrl());
		user = repository.save(user);
		return new UserDTO(user);
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		User user = repository.getById(id);
		
		user.setName(dto.getName());
		user.setImgUrl(dto.getImgUrl());
		
		user = repository.save(user);
		return new UserDTO(user);
	}
}
