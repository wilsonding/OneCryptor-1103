package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="team_id")
	private int teamId;

	private String description;

	@Column(name="rsa_private")
	private byte[] rsaPrivate;

	@Column(name="rsa_public")
	private byte[] rsaPublic;

	@Column(name="team_name")
	private String teamName;

	@Column(name="wrapping_key")
	private byte[] wrappingKey;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;

	//bi-directional many-to-one association to UserTeam
	@OneToMany(mappedBy="team")
	private List<UserTeam> userTeams;

	public Team() {
	}

	public int getTeamId() {
		return this.teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public byte[] getWrappingKey() {
		return this.wrappingKey;
	}

	public void setWrappingKey(byte[] wrappingKey) {
		this.wrappingKey = wrappingKey;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<UserTeam> getUserTeams() {
		return this.userTeams;
	}

	public void setUserTeams(List<UserTeam> userTeams) {
		this.userTeams = userTeams;
	}

	public UserTeam addUserTeam(UserTeam userTeam) {
		getUserTeams().add(userTeam);
		userTeam.setTeam(this);

		return userTeam;
	}

	public UserTeam removeUserTeam(UserTeam userTeam) {
		getUserTeams().remove(userTeam);
		userTeam.setTeam(null);

		return userTeam;
	}

}