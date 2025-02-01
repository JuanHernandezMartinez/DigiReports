package org.juan.ventas.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.juan.ventas.models.Articulo;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VentaDto  {

    public Articulo articulo;

    public BigDecimal unidades;

    public BigDecimal total;

    public String formaDePago;
}
