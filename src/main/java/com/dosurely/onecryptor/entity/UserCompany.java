package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_company database table.
 * 
 */
@Entity
@Table(name="user_company")
@NamedQuery(name="UserCompany.findAll", query="SELECT u FROM UserCompany u")
public class UserCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_company_id")
	private int userCompanyId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;

	public UserCompany() {
	}

	public int getUserCompanyId() {
		return this.userCompanyId;
	}

	public void setUserCompanyId(int userCompanyId) {
		this.userCompanyId = userCompanyId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}