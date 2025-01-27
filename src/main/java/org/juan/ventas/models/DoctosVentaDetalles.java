package org.juan.ventas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "DOCTOS_VE_DET")
public class DoctosVentaDetalles {
    @Id
    @Column(nullable = false)
    public Integer doctoVeDetId;

    @Column(nullable = false)
    public Integer doctoVeId;

    public Integer articuloId;

    public BigDecimal unidades;

    public BigDecimal pctjeDscto;

    public BigDecimal dsctoArt;

    public BigDecimal pctjeDsctoCli;

    public BigDecimal dsctoExtra;

    public BigDecimal pctjeDsctoVol;

}
