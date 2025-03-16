package org.juan.clientes.models;

import java.math.BigDecimal;

public class SaldoCliente {

    public Integer clienteId;

    public String nombre;

    public BigDecimal pago = BigDecimal.ZERO;

    public BigDecimal cargo = BigDecimal.ZERO;

    public BigDecimal saldo = BigDecimal.ZERO;

}
