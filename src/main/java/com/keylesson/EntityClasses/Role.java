package com.keylesson.EntityClasses;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	private int role_ID;
	private String role;
	private Timestamp created_at;
	private Timestamp updated_at;
	private int user_ID;
	private User_Registration user_registration;

	public int getRole_ID() {
		return role_ID;
	}

	public void setRole_ID(int role_ID) {
		this.role_ID = role_ID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public User_Registration getUser_registration() {
		return user_registration;
	}

	public void setUser_registration(User_Registration user_registration) {
		this.user_registration = user_registration;
	}
}
