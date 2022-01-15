package com.forum.forum.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.forum.dto.PostDTO;
import com.forum.forum.dto.TopicDTO;
import com.forum.forum.entities.Post;
import com.forum.forum.entities.Topic;
import com.forum.forum.repositories.TopicRepository;
import com.forum.forum.repositories.UserRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<TopicDTO> findAll() {
		List<Topic> list = repository.findAll();
		return list.stream().map(x -> new TopicDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public TopicDTO insert(TopicDTO dto) {
		try {
			Topic Topic = new Topic(null, dto.getName(), null, userRepository.getById(dto.getUser()));
			Topic = repository.save(Topic);
			return new TopicDTO(Topic);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public TopicDTO update(Long id, TopicDTO dto) {
		try {
			Topic topic = repository.getById(id);
			
			topic.setName(dto.getName());
			
			topic = repository.save(topic);
			return new TopicDTO(topic);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public TopicDTO delete(Long id) {
		
		try {
			Topic topic = repository.getById(id);
			repository.delete(topic);
			return new TopicDTO(topic);
		} catch(EntityNotFoundException e)  {
			e.printStackTrace();
			return null;
		}
		
	}
}
