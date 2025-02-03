package org.juan.ventas.models;

import java.math.BigDecimal;


public class Impuesto {

    private Integer id;

    private Integer detalleId;

    private BigDecimal importeImpuesto;

    public Impuesto() {
    }

    public Impuesto(Integer id, Integer detalleId, BigDecimal importeImpuesto) {
        this.id = id;
        this.detalleId = detalleId;
        this.importeImpuesto = importeImpuesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(Integer detalleId) {
        this.detalleId = detalleId;
    }

    public BigDecimal getImporteImpuesto() {
        return importeImpuesto;
    }

    public void setImporteImpuesto(BigDecimal importeImpuesto) {
        this.importeImpuesto = importeImpuesto;
    }

    

    @Override
    public String toString() {
        return "Impuesto [id=" + id + ", detalleId=" + detalleId + ", importeImpuesto=" + importeImpuesto + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((detalleId == null) ? 0 : detalleId.hashCode());
        result = prime * result + ((importeImpuesto == null) ? 0 : importeImpuesto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Impuesto other = (Impuesto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (detalleId == null) {
            if (other.detalleId != null)
                return false;
        } else if (!detalleId.equals(other.detalleId))
            return false;
        if (importeImpuesto == null) {
            if (other.importeImpuesto != null)
                return false;
        } else if (!importeImpuesto.equals(other.importeImpuesto))
            return false;
        return true;
    }

    
}
