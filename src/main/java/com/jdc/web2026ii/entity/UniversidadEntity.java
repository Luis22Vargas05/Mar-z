package com.jdc.web2026ii.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name= "universidades")
public class UniversidadEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniversidad")
    private Integer iduniversidad;

    @NotNull
    @Size(min =0, max=50)
    @Column(name ="nombre")
    private String nombre;

    @NotNull
    @Size(min =0, max= 14)
    @Column(name="nit")
    private String nit;

    @Column(name ="estado")
    private boolean estado;

    @NotNull
    @Column(name= "descripcion")
    @Size(min =0, max=100)
    private String descripcion;


    public Integer getIduniversidad() {
        return iduniversidad;
    }

    public void setIduniversidad(Integer iduniversidad) {
        this.iduniversidad = iduniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
