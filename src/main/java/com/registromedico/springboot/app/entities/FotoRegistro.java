package com.registromedico.springboot.app.entities;

import javax.persistence.*;

@Entity
public class FotoRegistro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "registro_medico_id")
    private RegistroMedico registroMedico;

    @Lob
    @Column(columnDefinition="mediumblob")
    private byte[] foto = new byte[100000];

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RegistroMedico getRegistroMedico() {
        return registroMedico;
    }

    public void setRegistroMedico(RegistroMedico registroMedico) {
        this.registroMedico = registroMedico;
    }

    public byte[] getFoto() { return foto; }

    public void setFoto(byte[] foto) { this.foto = foto; }
}