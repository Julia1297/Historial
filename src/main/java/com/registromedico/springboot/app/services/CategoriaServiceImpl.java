package com.registromedico.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.registromedico.springboot.app.entities.Categoria;
import com.registromedico.springboot.app.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private CategoriaRepository categoriaRepository;

    @Autowired
    @Qualifier(value = "categoriaRepository")
    public void setCategoriaRepository(CategoriaRepository categoriaRepository) { this.categoriaRepository = categoriaRepository; }

    @Override
    public Iterable<Categoria> listAllCategories() {
        return categoriaRepository.findAll();
    }

    @Override
    public void saveCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public Categoria getCategoria(Integer id) {
        return categoriaRepository.findOne(id);
    }

    @Override
    public void deleteCategoria(Integer id) {
        categoriaRepository.delete(id);
    }
}