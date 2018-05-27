package com.registromedico.springboot.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.registromedico.springboot.app.entities.Observacion;

import javax.transaction.Transactional;

@Transactional
public interface ObservacionRepository extends CrudRepository<Observacion,Integer> {
}
