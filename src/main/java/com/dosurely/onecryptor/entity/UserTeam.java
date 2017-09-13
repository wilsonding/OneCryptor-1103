package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_team database table.
 * 
 */
@Entity
@Table(name="user_team")
@NamedQuery(name="UserTeam.findAll", query="SELECT u FROM UserTeam u")
public class UserTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_team_id")
	private int userTeamId;

	@Column(name="team_key")
	private byte[] teamKey;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team team;

	public UserTeam() {
	}

	public int getUserTeamId() {
		return this.userTeamId;
	}

	public void setUserTeamId(int userTeamId) {
		this.userTeamId = userTeamId;
	}

	public byte[] getTeamKey() {
		return this.teamKey;
	}

	public void setTeamKey(byte[] teamKey) {
		this.teamKey = teamKey;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}