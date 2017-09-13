package com.dosurely.onecryptor.repository;

import org.springframework.data.repository.CrudRepository;

import com.dosurely.onecryptor.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
