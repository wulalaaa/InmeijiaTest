package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.ebean.Model;

@Entity
@Table(name = "users")
public class Users extends Model{
	@Id
	private String user_id;

	private String user_name;

	private String user_password;

	private String user_sex;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public Users() {

	}

	public Users(String user_id, String user_name, String user_password, String user_sex) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_sex = user_sex;
	}

}
