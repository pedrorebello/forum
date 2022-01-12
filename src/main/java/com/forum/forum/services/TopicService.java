package com.forum.forum.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.forum.dto.TopicDTO;
import com.forum.forum.entities.Topic;
import com.forum.forum.repositories.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository repository;

	@Transactional(readOnly = true)
	public List<TopicDTO> findAll() {
		List<Topic> list = repository.findAll();
		return list.stream().map(x -> new TopicDTO(x)).collect(Collectors.toList());
	}
}
