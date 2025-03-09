package org.juan.clientes.services.implementations;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.clientes.models.SaldoCliente;
import org.juan.clientes.repository.ClienteRepository;
import org.juan.clientes.services.ClienteService;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    ClienteRepository repository;

    public List<SaldoCliente> getSaldoClientesByFechas(String dbName, LocalDate startDate, LocalDate endDate) throws  RuntimeException{
        return repository.getSaldoClientesByFechas(dbName, startDate, endDate);
    }
}
