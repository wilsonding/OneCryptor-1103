package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the payment_method database table.
 * 
 */
@Entity
@Table(name="payment_method")
@NamedQuery(name="PaymentMethod.findAll", query="SELECT p FROM PaymentMethod p")
public class PaymentMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_method_id")
	private int paymentMethodId;

	private String description;

	@Column(name="payment_method_name")
	private String paymentMethodName;

	//bi-directional many-to-one association to AccountRepository
	@OneToMany(mappedBy="paymentMethod")
	private List<Account> accounts;

	public PaymentMethod() {
	}

	public int getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaymentMethodName() {
		return this.paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setPaymentMethod(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setPaymentMethod(null);

		return account;
	}

}