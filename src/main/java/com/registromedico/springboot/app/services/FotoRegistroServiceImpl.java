package com.registromedico.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.registromedico.springboot.app.entities.FotoRegistro;
import com.registromedico.springboot.app.repositories.FotoRegistroRepository;

@Service
public class FotoRegistroServiceImpl implements FotoRegistroService {

    private FotoRegistroRepository fotoRegistroRepository;

    @Autowired
    @Qualifier(value = "fotoRegistroRepository")
    public void setFotoRegistroRepository(FotoRegistroRepository fotoRegistroRepository) { this.fotoRegistroRepository = fotoRegistroRepository; }

    @Override
    public Iterable<FotoRegistro> listAllFotos() {
        return fotoRegistroRepository.findAll();
    }

    @Override
    public void saveFotoRegistro(FotoRegistro fotoRegistro) {
        fotoRegistroRepository.save(fotoRegistro);
    }

    @Override
    public FotoRegistro getFotoRegistro(Integer id) {
        return fotoRegistroRepository.findOne(id);
    }

    @Override
    public void deleteFotoRegistro(Integer id) {
        fotoRegistroRepository.delete(id);
    }
}