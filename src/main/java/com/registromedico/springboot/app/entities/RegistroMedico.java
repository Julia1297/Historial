package com.registromedico.springboot.app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
public class RegistroMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String titulo;

    private Date fecha;

    @NotNull
    private String descripcion;

    @OneToMany(mappedBy = "registroMedico",cascade = CascadeType.ALL)
    private List<FotoRegistro> fotoRegistroList;

    @OneToMany(mappedBy = "registroMedico",cascade = CascadeType.ALL)
    private List<Observacion> observacionList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public List<FotoRegistro> getFotoRegistroList() {
        return fotoRegistroList;
    }

    public void setFotoRegistroList(List<FotoRegistro> fotoRegistroList) {
        this.fotoRegistroList = fotoRegistroList;
    }

    public List<Observacion> getObservacionList() {
        return observacionList;
    }

    public void setObservacionList(List<Observacion> observacionList) {
        this.observacionList = observacionList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}