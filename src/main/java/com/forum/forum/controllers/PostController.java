package com.forum.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forum.forum.dto.PostDTO;
import com.forum.forum.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll() {
		List<PostDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
