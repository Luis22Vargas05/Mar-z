package com.jdc.web2026ii.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seccionales")
public class SeccionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseccional")
    private Integer idseccional;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "iduniversidad")
    private UniversidadEntity universidad;

    public Integer getIdseccional() {
        return idseccional;
    }

    public void setIdseccional(Integer idseccional) {
        this.idseccional = idseccional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public UniversidadEntity getUniversidad() {
        return universidad;
    }

    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
    }
}