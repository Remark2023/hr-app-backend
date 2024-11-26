package com.remark_herlan.hr_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * author: Naimul Hassan 
 * 
 * date: 11/26/2024
 */

@Entity
public class Roles {

	@Id
	private int id;
	private String title;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
