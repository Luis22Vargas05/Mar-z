package com.jdc.web2026ii.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Rectores")
public class RectorEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrector")
    private Integer idrector;

    @NotNull
    @Column(name = "primerapellido")
    @Size(min = 1, max = 50)
    private String primerapellido;

    @NotNull
    @Column(name = "segundoapellido")
    @Size(min = 1, max = 50)
    private String segundoapellido;

    @NotNull
    @Column(name = "nombre")
    @Size(min = 1, max = 50)
    private String nombre;

    @NotNull
    @Column(name = "numdocumento")
    @Size(min = 1, max = 50)
    private String numdocumento;

    @NotNull
    @Column(name = "tipo")
    private Integer tipo;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "fechadenacimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechadenacimiento;

    @OneToOne
    @JoinColumn(name = "iduniversidad", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UniversidadEntity universidad;

    public Integer getIdrector() {
        return idrector;
    }

    public void setIdrector(Integer idrector) {
        this.idrector = idrector;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(String numdocumento) {
        this.numdocumento = numdocumento;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Date getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(Date fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public UniversidadEntity getUniversidad() {
        return universidad;
    }

    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
    }
}