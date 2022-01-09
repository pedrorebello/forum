package com.forum.forum.dto;

import java.io.Serializable;

import com.forum.forum.entities.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String imgUrl;

	public UserDTO() {
	}

	public UserDTO(Long id, String name, String imgUrl) {
		this.id = id;
		this.name = name;
		this.imgUrl = imgUrl;
	}

	public UserDTO(User entity) {
		this(entity.getId(), entity.getName(), entity.getImgUrl());
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
