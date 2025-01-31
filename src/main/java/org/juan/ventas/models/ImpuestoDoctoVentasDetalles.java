package org.juan.ventas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "IMPUESTOS_DOCTOS_VE_DET")
public class ImpuestoDoctoVentasDetalles {

    @Id
    @Column(name = "DOCTO_VE_DET_ID")
    public Integer id;


}
