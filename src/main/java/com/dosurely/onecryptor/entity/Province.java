package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the province database table.
 * 
 */
@Entity
@NamedQuery(name="Province.findAll", query="SELECT p FROM Province p")
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="province_id")
	private short provinceId;

	@Column(name="province_code")
	private String provinceCode;

	@Column(name="province_name")
	private String provinceName;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="province")
	private List<Company> companies;

	public Province() {
	}

	public short getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(short provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setProvince(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setProvince(null);

		return company;
	}

}