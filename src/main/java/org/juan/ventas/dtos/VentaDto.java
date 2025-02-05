package org.juan.ventas.dtos;

import org.juan.ventas.models.Articulo;
import java.math.BigDecimal;

public class VentaDto  {

    public Articulo articulo;

    public BigDecimal unidades;

    public BigDecimal total;

    public String formaDePago;
}
