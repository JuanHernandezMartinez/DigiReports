package org.juan.ventas.dtos;

import java.math.BigDecimal;

public class ArticuloTotal {

    private String articulo;

    private Integer articuloId;

    private BigDecimal totalneto;

    public ArticuloTotal() {
    }

    public ArticuloTotal(String articulo, Integer articuloId, BigDecimal totalneto) {
        this.articulo = articulo;
        this.articuloId = articuloId;
        this.totalneto = totalneto;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Integer getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Integer articuloId) {
        this.articuloId = articuloId;
    }

    public BigDecimal getTotalneto() {
        return totalneto;
    }

    public void setTotalneto(BigDecimal totalneto) {
        this.totalneto = totalneto;
    }

    @Override
    public String toString() {
        return "ArticuloTotal [articulo=" + articulo + ", articuloId=" + articuloId + ", totalneto=" + totalneto + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((articulo == null) ? 0 : articulo.hashCode());
        result = prime * result + ((articuloId == null) ? 0 : articuloId.hashCode());
        result = prime * result + ((totalneto == null) ? 0 : totalneto.hashCode());
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
        ArticuloTotal other = (ArticuloTotal) obj;
        if (articulo == null) {
            if (other.articulo != null)
                return false;
        } else if (!articulo.equals(other.articulo))
            return false;
        if (articuloId == null) {
            if (other.articuloId != null)
                return false;
        } else if (!articuloId.equals(other.articuloId))
            return false;
        if (totalneto == null) {
            if (other.totalneto != null)
                return false;
        } else if (!totalneto.equals(other.totalneto))
            return false;
        return true;
    }

    
    
    
}
