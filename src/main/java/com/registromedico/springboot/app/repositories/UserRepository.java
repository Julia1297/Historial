package com.registromedico.springboot.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.registromedico.springboot.app.entities.User;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}