package org.juan.ventas.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "IMPUESTOS_DOCTOS_VE_DET")
public class Impuesto {

    @Id
    @Column(name = "DOCTO_VE_DET_ID")
    public Integer id;

    @Column(name = "IMPORTE_IMPUESTO_BRUTO")
    public BigDecimal importeImpuesto;
    

    public Impuesto() {
    }

    

    public Impuesto(Integer id, BigDecimal importeImpuesto) {
        this.id = id;
        this.importeImpuesto = importeImpuesto;
    }

    @Override
    public String toString() {
        return "Impuesto [id=" + id + ", importeImpuesto=" + importeImpuesto + "]";
    }

    
    
}
