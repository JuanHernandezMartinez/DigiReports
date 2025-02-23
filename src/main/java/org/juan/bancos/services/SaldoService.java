package org.juan.bancos.services;

import org.juan.bancos.models.Saldo;

import java.time.LocalDate;

public interface SaldoService {

    Saldo buscarSaldoCuentaBancoAndFecha(Integer cuentaBancoId, LocalDate fecha);
}
