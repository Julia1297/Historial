package com.registromedico.springboot.app.services;

import com.registromedico.springboot.app.entities.Observacion;

public interface ObservacionService {
    Iterable<Observacion> listAllObservacion();

    Observacion getObservacionById(Integer id);

    Observacion saveObservacion(Observacion observacion);

    void deleteObservacion(Integer id);
}
