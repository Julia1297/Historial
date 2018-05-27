package com.registromedico.springboot.app.services;

import com.registromedico.springboot.app.entities.RegistroMedico;

public interface RegistroMedicoService {
    Iterable<RegistroMedico> listAllRegistroMedico();

    void saveRegistroMedico(RegistroMedico registroMedico);

    RegistroMedico getRegistroMedico(Integer id);

    void deleteRegistroMedico(Integer id);
}