package com.forum.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forum.forum.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
}
