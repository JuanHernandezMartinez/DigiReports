package org.juan.clientes.services;

import org.juan.clientes.models.SaldoCliente;

import java.time.LocalDate;
import java.util.List;

public interface ClienteService {
    List<SaldoCliente> getSaldoClientesByFechas(String dbName, LocalDate startDate, LocalDate endDate) throws RuntimeException;

}
