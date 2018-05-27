package com.registromedico.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.registromedico.springboot.app.entities.RegistroMedico;
import com.registromedico.springboot.app.repositories.RegistroMedicoRepository;

@Service
public class RegistroMedicoServiceImpl implements RegistroMedicoService {

    private RegistroMedicoRepository registroMedicoRepository;

    @Autowired
    @Qualifier(value = "registroMedicoRepository")
    public void setRegistroMedicoRepository(RegistroMedicoRepository registroMedicoRepository) { this.registroMedicoRepository = registroMedicoRepository; }

    @Override
    public Iterable<RegistroMedico> listAllRegistroMedico() {
        return registroMedicoRepository.findAll();
    }

    @Override
    public void saveRegistroMedico(RegistroMedico registroMedico) {
        registroMedicoRepository.save(registroMedico);
    }

    @Override
    public RegistroMedico getRegistroMedico(Integer id) {
        return registroMedicoRepository.findOne(id);
    }

    @Override
    public void deleteRegistroMedico(Integer id) {
        registroMedicoRepository.delete(id);
    }
}