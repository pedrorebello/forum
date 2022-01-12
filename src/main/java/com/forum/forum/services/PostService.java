package com.forum.forum.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.forum.dto.PostDTO;
import com.forum.forum.entities.Post;
import com.forum.forum.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;

	@Transactional(readOnly = true)
	public List<PostDTO> findAll() {
		List<Post> list = repository.findAll();
		return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
}
