package org.juan.ventas.models;

import java.math.BigDecimal;
import java.util.Objects;

//@Entity
//@Table(name = "DOCTOS_VE_DET")
public class DoctosVentaDetalles {

//    @Id
//    @Column(name = "DOCTO_VE_DET_ID")
    public Integer doctoVeDetId;

//    @Column(name = "DOCTO_VE_ID")
    public Integer doctoVeId;

//    @Column(name = "ARTICULO_ID")
    public Integer articuloId;

//    @Column(name = "UNIDADES")
    public BigDecimal unidades;

//    @Column(name = "PRECIO_TOTAL_NETO")
    public BigDecimal precioTotalNeto;

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

    @Override
    public String toString() {
        return "DoctosVentaDetalles{" +
                "doctoVeDetId=" + doctoVeDetId +
                ", doctoVeId=" + doctoVeId +
                ", articuloId=" + articuloId +
                ", unidades=" + unidades +
                ", precioTotalNeto=" + precioTotalNeto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DoctosVentaDetalles detalles = (DoctosVentaDetalles) o;
        return Objects.equals(doctoVeDetId, detalles.doctoVeDetId) && Objects.equals(doctoVeId, detalles.doctoVeId) && Objects.equals(articuloId, detalles.articuloId) && Objects.equals(unidades, detalles.unidades) && Objects.equals(precioTotalNeto, detalles.precioTotalNeto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctoVeDetId, doctoVeId, articuloId, unidades, precioTotalNeto);
    }
}
