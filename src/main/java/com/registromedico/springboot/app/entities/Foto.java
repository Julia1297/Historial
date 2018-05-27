package com.registromedico.springboot.app.entities;

public class Foto {
    private Integer id;
    private String def;

    public Foto(Integer id, String def) {
        this.id = id;
        this.def = def;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getDef() { return def; }

    public void setDef(String def) { this.def = def; }
}