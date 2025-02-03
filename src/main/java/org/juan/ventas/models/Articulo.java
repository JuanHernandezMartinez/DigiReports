package org.juan.ventas.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ARTICULOS")
public class Articulo {

    @Id
    @Column(name = "ARTICULO_ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Transient
    private BigDecimal unidades = BigDecimal.ZERO;

    @Transient
    private BigDecimal total = BigDecimal.ZERO;

    public  Articulo(){}

    public Articulo(Integer id, String nombre, BigDecimal unidades, BigDecimal total) {
        this.id = id;
        this.nombre = nombre;
        this.unidades = unidades;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getUnidades() {
        return unidades;
    }

    public void setUnidades(BigDecimal unidades) {
        this.unidades = unidades;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", unidades=" + unidades +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(id, articulo.id) && Objects.equals(nombre, articulo.nombre) && Objects.equals(unidades, articulo.unidades) && Objects.equals(total, articulo.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, unidades, total);
    }
}
