package com.forum.forum.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<PostDTO> insert(@RequestBody PostDTO dto) {
		dto = service.insert(dto);

		if(dto != null) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
		}

		return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDTO> update(@PathVariable Long id, @RequestBody PostDTO dto) {
		dto = service.update(id, dto);

		if(dto != null)
			return ResponseEntity.ok(dto);

		return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PostDTO> delete(@PathVariable Long id) {
		PostDTO dto = service.delete(id);
		
		if(dto != null)
			return ResponseEntity.ok(dto);

		return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
		
	}
}
