package com.registromedico.springboot.app.services;

import com.registromedico.springboot.app.entities.Categoria;

public interface CategoriaService {
    Iterable<Categoria> listAllCategories();

    void saveCategoria(Categoria categoria);

    Categoria getCategoria(Integer id);

    void deleteCategoria(Integer id);
}