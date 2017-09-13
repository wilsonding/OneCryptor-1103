package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_status database table.
 * 
 */
@Entity
@Table(name="user_status")
@NamedQuery(name="UserStatus.findAll", query="SELECT u FROM UserStatus u")
public class UserStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="status_id")
	private int statusId;

	private String description;

	@Column(name="status_name")
	private String statusName;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="userStatus")
	private List<User> users;

	public UserStatus() {
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUserStatus(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUserStatus(null);

		return user;
	}

}