package org.juan.ventas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.lang.model.element.Name;
import java.math.BigDecimal;

@Entity
@Table(name = "DOCTOS_VE_DET")
public class DoctosVentaDetalles {

    @Id
    @Column(name = "DOCTO_VE_DET_ID")
    public Integer doctoVeDetId;

    @Column(name = "DOCTO_VE_ID")
    public Integer doctoVeId;

    @Column(name = "ARTICULO_ID")
    public Integer articuloId;

    @Column(name = "UNIDADES")
    public BigDecimal unidades;

    @Column(name = "PRECIO_UNITARIO")
    public BigDecimal precioUnitario;

    @Column(name = "PCTJE_DSCTO")
    public BigDecimal pctjeDscto;

//    @Column(name = "")
//    public BigDecimal dsctoArt;
//
//    @Column(name = "")
//    public BigDecimal pctjeDsctoCli;
//
//    @Column(name = "")
//    public BigDecimal dsctoExtra;
//
//    @Column(name = "")
//    public BigDecimal pctjeDsctoVol;

    @Column(name = "PRECIO_TOTAL_NETO")
    public BigDecimal precioTotalNeto;

}
