package com.registromedico.springboot.app.repositories;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.registromedico.springboot.app.entities.Categoria;


@Transactional
public interface CategoriaRepository extends CrudRepository<Categoria,Integer> {
}
