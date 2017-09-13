package com.dosurely.onecryptor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dosurely.onecryptor.entity.UserStatus;
import com.dosurely.onecryptor.repository.UserStatusRepository;

@Service
public class UserStatusServiceImpl implements UserStatusService {
	
	@Autowired
	UserStatusRepository userStatusRepository;

	@Override
	public UserStatus getUserStatusById(Integer statusId) {
		UserStatus userStatus = userStatusRepository.findByStatusId(statusId);
		return userStatus;
	}

}
