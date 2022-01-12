package com.forum.forum.dto;

import java.io.Serializable;
import java.util.Date;

import com.forum.forum.entities.Post;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String body;
	private Date createdAt;
	private Long topic;
	private Long user;

	public PostDTO() {
	}

	public PostDTO(Long id, String body, Date createdAt, Long topic, Long user) {
		this.id = id;
		this.body = body;
		this.createdAt = createdAt;
		this.topic = topic;
		this.user = user;
	}

	public PostDTO(Post entity) {
		this(entity.getId(), entity.getBody(), entity.getCreatedAt(), entity.getTopic().getId(), entity.getUser().getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getTopic() {
		return topic;
	}

	public void setTopic(Long topic) {
		this.topic = topic;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}
	
}
