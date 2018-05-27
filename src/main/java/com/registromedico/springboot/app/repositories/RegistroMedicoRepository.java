package com.registromedico.springboot.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.registromedico.springboot.app.entities.RegistroMedico;

import javax.transaction.Transactional;

@Transactional
public interface RegistroMedicoRepository extends CrudRepository<RegistroMedico,Integer> {
}
