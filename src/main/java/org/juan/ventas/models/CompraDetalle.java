package org.juan.ventas.models;


import java.math.BigDecimal;
import java.util.Objects;

//@Entity
//@Table(name = "DOCTOS_CO_DET")
public class CompraDetalle {

//    @Id
//    @Column(name = "DOCTO_CO_DET_ID")
    private Integer id;

//    @Column(name = "DOCTO_CO_ID")
    private Integer compraId;

//    @Column(name = "CUENTA_ID")
    private Integer cuentaId;

//    @Column(name = "IMPORTE")
    private BigDecimal importe;

//    @Column(name = "TIPO_ASIENTO")
    private char tipoAsiento;

    public CompraDetalle() {}

    public CompraDetalle(Integer id, Integer compraId, Integer cuentaId, BigDecimal importe, char tipoAsiento) {
        this.id = id;
        this.compraId = compraId;
        this.cuentaId = cuentaId;
        this.importe = importe;
        this.tipoAsiento = tipoAsiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public char getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(char tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    @Override
    public String toString() {
        return "CompraDetalle{" +
                "id=" + id +
                ", compraId=" + compraId +
                ", cuentaId=" + cuentaId +
                ", importe=" + importe +
                ", tipoAsiento=" + tipoAsiento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompraDetalle that = (CompraDetalle) o;
        return tipoAsiento == that.tipoAsiento && Objects.equals(id, that.id) && Objects.equals(compraId, that.compraId) && Objects.equals(cuentaId, that.cuentaId) && Objects.equals(importe, that.importe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, compraId, cuentaId, importe, tipoAsiento);
    }
}
