package org.juan.ventas.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "DOCTOS_CO_DET")
public class ComprasDetalles {

    @Id
    @Column(name = "DOCTO_CO_DET_ID")
    private Integer id;

    @Column(name = "CUENTA_ID")
    private Integer cuentaId;

    @Column(name = "IMPORTE")
    private BigDecimal importe;

    @Column(name = "TIPO_ASIENTO")
    private char tipoAsiento;
}
