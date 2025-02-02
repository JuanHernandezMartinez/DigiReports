package org.juan.ventas.models;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "IMPUESTOS_DOCTOS_VE_DET")
public class Impuesto {

    @Id
    @Column(name = "DOCTO_VE_DET_ID")
    private Integer id;

    @Column(name = "IMPORTE_IMPUESTO_BRUTO")
    private BigDecimal importeImpuesto;

    public Impuesto() {
    }

    public Impuesto(Integer id, BigDecimal importeImpuesto) {
        this.id = id;
        this.importeImpuesto = importeImpuesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getImporteImpuesto() {
        return importeImpuesto;
    }

    public void setImporteImpuesto(BigDecimal importeImpuesto) {
        this.importeImpuesto = importeImpuesto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Impuesto impuesto = (Impuesto) o;
        return Objects.equals(id, impuesto.id) && Objects.equals(importeImpuesto, impuesto.importeImpuesto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, importeImpuesto);
    }
}
