package com.dosurely.onecryptor.repository;

import org.springframework.data.repository.CrudRepository;

import com.dosurely.onecryptor.entity.UserStatus;

public interface UserStatusRepository extends CrudRepository<UserStatus, Integer> {
	
	public UserStatus findByStatusId(Integer statusId);
	
}
