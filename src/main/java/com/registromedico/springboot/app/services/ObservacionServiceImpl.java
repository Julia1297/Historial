package com.registromedico.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.registromedico.springboot.app.entities.Observacion;
import com.registromedico.springboot.app.repositories.ObservacionRepository;

@Service
public class ObservacionServiceImpl implements ObservacionService {
    private ObservacionRepository observacionRepository;

    @Autowired
    @Qualifier(value = "observacionRepository")
    public void setObservacionRepository(ObservacionRepository observacionRepository){
        this.observacionRepository = observacionRepository;
    }

    @Override
    public Iterable<Observacion> listAllObservacion() {
        return observacionRepository.findAll();
    }

    @Override
    public Observacion getObservacionById(Integer id) { return observacionRepository.findOne(id); }

    @Override
    public Observacion saveObservacion(Observacion observacion) {
        return observacionRepository.save(observacion);
    }

    @Override
    public void deleteObservacion(Integer id) {
        observacionRepository.delete(id);
    }
}