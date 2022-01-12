package com.forum.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forum.forum.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
	
}
