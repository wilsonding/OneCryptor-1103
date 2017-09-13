package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="account")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="account_id")
	private int accountId;

	@Column(name="account_name")
	private String accountName;

	//bi-directional many-to-one association to PaymentMethod
	@ManyToOne
	@JoinColumn(name="payment_method_id")
	private PaymentMethod paymentMethod;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="account")
	private List<User> users;

	public Account() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAccount(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAccount(null);

		return user;
	}

}