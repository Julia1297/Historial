package com.registromedico.springboot.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.registromedico.springboot.app.entities.FotoRegistro;

import javax.transaction.Transactional;

@Transactional
public interface FotoRegistroRepository extends CrudRepository<FotoRegistro,Integer> {
}