package com.forum.forum.dto;

import java.io.Serializable;
import java.util.Date;

import com.forum.forum.entities.Topic;

public class TopicDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Date createdAt;
	private Long user;

	public TopicDTO() {
	}

	public TopicDTO(Long id, String name, Date createdAt, Long user) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.user = user;
	}

	public TopicDTO(Topic entity) {
		this(entity.getId(), entity.getName(), entity.getCreatedAt(), entity.getUser().getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}
	
	

}
