package org.juan.ventas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "DOCTOS_CO")
public class Compra {

    @Id
    @Column(name = "DOCTO_CO_ID")
    private Integer id;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "TIPO_POLIZA_ID")
    private Integer polizaId;

    public Compra() {
    }

    public Compra(Integer id, LocalDate fecha, String descripcion, Integer polizaId) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.polizaId = polizaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPolizaId() {
        return polizaId;
    }

    public void setPolizaId(Integer polizaId) {
        this.polizaId = polizaId;
    }
}
