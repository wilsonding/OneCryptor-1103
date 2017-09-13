package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_id")
	private int companyId;

	private String address;

	private String city;

	@Column(name="company_name")
	private String companyName;

	@Column(name="contact_name")
	private String contactName;

	@Column(name="contact_number")
	private String contactNumber;

	@Column(name="country_code")
	private String countryCode;

	@Column(name="zip_code")
	private String zipCode;

	//bi-directional many-to-one association to Province
	@ManyToOne
	@JoinColumn(name="province_id")
	private Province province;

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="company")
	private List<Team> teams;

	//bi-directional many-to-one association to UserCompany
	@OneToMany(mappedBy="company")
	private List<UserCompany> userCompanies;

	public Company() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team addTeam(Team team) {
		getTeams().add(team);
		team.setCompany(this);

		return team;
	}

	public Team removeTeam(Team team) {
		getTeams().remove(team);
		team.setCompany(null);

		return team;
	}

	public List<UserCompany> getUserCompanies() {
		return this.userCompanies;
	}

	public void setUserCompanies(List<UserCompany> userCompanies) {
		this.userCompanies = userCompanies;
	}

	public UserCompany addUserCompany(UserCompany userCompany) {
		getUserCompanies().add(userCompany);
		userCompany.setCompany(this);

		return userCompany;
	}

	public UserCompany removeUserCompany(UserCompany userCompany) {
		getUserCompanies().remove(userCompany);
		userCompany.setCompany(null);

		return userCompany;
	}

}