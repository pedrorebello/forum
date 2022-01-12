package com.forum.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forum.forum.dto.TopicDTO;
import com.forum.forum.services.TopicService;

@RestController
@RequestMapping(value = "/topics")
public class TopicController {

	@Autowired
	private TopicService service;
	
	@GetMapping
	public ResponseEntity<List<TopicDTO>> findAll() {
		List<TopicDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
