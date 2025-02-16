package org.juan.ventas.dtos;

import java.math.BigDecimal;

public class TotalFormaPago {

    private String forma;

    private BigDecimal total;

    public TotalFormaPago(){}

    public TotalFormaPago(String forma, BigDecimal total) {
        this.forma = forma;
        this.total = total;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
