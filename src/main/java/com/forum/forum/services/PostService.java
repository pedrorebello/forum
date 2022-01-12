package com.forum.forum.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.forum.dto.PostDTO;
import com.forum.forum.dto.TopicDTO;
import com.forum.forum.entities.Post;
import com.forum.forum.entities.Topic;
import com.forum.forum.repositories.PostRepository;
import com.forum.forum.repositories.TopicRepository;
import com.forum.forum.repositories.UserRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TopicRepository topicRepository;

	@Transactional(readOnly = true)
	public List<PostDTO> findAll() {
		List<Post> list = repository.findAll();
		return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public PostDTO insert(PostDTO dto) {
		Post Post = new Post(null, dto.getBody(), null, topicRepository.getById(dto.getTopic()), userRepository.getById(dto.getUser()));
		Post = repository.save(Post);
		return new PostDTO(Post);
	}
	
	@Transactional
	public PostDTO update(Long id, PostDTO dto) {
		Post post = repository.getById(id);
		
		post.setBody(dto.getBody());
		
		post = repository.save(post);
		return new PostDTO(post);
	}
}
