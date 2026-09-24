package com.jdc.web2026ii.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "telefonos")
public class TelefonoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtelefono")
    private Integer idtelefono;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "numero")
    private Long numero;

    @ManyToOne
    @JoinColumn(name = "idseccional")
    private SeccionalEntity seccional;

    public Integer getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(Integer idtelefono) {
        this.idtelefono = idtelefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public SeccionalEntity getSeccional() {
        return seccional;
    }

    public void setSeccional(SeccionalEntity seccional) {
        this.seccional = seccional;
    }
}