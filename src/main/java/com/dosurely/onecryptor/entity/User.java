package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private int userId;

	@Column(name="contact_number")
	private String contactNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	private String email;

	@Column(name="first_name")
	private String firstName;

	private int iterations;

	@Column(name="last_name")
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name="last_updated")
	private Date lastUpdated;

	private byte[] password;

	@Column(name="password_key")
	private byte[] passwordKey;

	@Column(name="rsa_private")
	private byte[] rsaPrivate;

	@Column(name="rsa_public")
	private byte[] rsaPublic;

	private byte[] salt;

	@Column(name="wrapping_key")
	private byte[] wrappingKey;

	//bi-directional many-to-one association to UserStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private UserStatus userStatus;

	//bi-directional many-to-one association to AccountRepository
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to UserCompany
	@OneToMany(mappedBy="user")
	private List<UserCompany> userCompanies;

	//bi-directional many-to-one association to UserTeam
	@OneToMany(mappedBy="user")
	private List<UserTeam> userTeams;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getIterations() {
		return this.iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public byte[] getPassword() {
		return this.password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public byte[] getPasswordKey() {
		return this.passwordKey;
	}

	public void setPasswordKey(byte[] passwordKey) {
		this.passwordKey = passwordKey;
	}

	public byte[] getRsaPrivate() {
		return this.rsaPrivate;
	}

	public void setRsaPrivate(byte[] rsaPrivate) {
		this.rsaPrivate = rsaPrivate;
	}

	public byte[] getRsaPublic() {
		return this.rsaPublic;
	}

	public void setRsaPublic(byte[] rsaPublic) {
		this.rsaPublic = rsaPublic;
	}

	public byte[] getSalt() {
		return this.salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public byte[] getWrappingKey() {
		return this.wrappingKey;
	}

	public void setWrappingKey(byte[] wrappingKey) {
		this.wrappingKey = wrappingKey;
	}

	public UserStatus getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<UserCompany> getUserCompanies() {
		return this.userCompanies;
	}

	public void setUserCompanies(List<UserCompany> userCompanies) {
		this.userCompanies = userCompanies;
	}

	public UserCompany addUserCompany(UserCompany userCompany) {
		getUserCompanies().add(userCompany);
		userCompany.setUser(this);

		return userCompany;
	}

	public UserCompany removeUserCompany(UserCompany userCompany) {
		getUserCompanies().remove(userCompany);
		userCompany.setUser(null);

		return userCompany;
	}

	public List<UserTeam> getUserTeams() {
		return this.userTeams;
	}

	public void setUserTeams(List<UserTeam> userTeams) {
		this.userTeams = userTeams;
	}

	public UserTeam addUserTeam(UserTeam userTeam) {
		getUserTeams().add(userTeam);
		userTeam.setUser(this);

		return userTeam;
	}

	public UserTeam removeUserTeam(UserTeam userTeam) {
		getUserTeams().remove(userTeam);
		userTeam.setUser(null);

		return userTeam;
	}

}