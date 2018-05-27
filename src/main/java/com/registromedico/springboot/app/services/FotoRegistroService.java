package com.registromedico.springboot.app.services;

import com.registromedico.springboot.app.entities.FotoRegistro;

public interface FotoRegistroService {
    Iterable<FotoRegistro> listAllFotos();

    void saveFotoRegistro(FotoRegistro fotoRegistro);

    FotoRegistro getFotoRegistro(Integer id);

    void deleteFotoRegistro(Integer id);
}