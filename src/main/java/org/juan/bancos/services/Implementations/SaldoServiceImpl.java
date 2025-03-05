package org.juan.bancos.services.Implementations;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.bancos.models.Saldo;
import org.juan.bancos.repositories.SaldoRepository;
import org.juan.bancos.services.SaldoService;

import java.time.LocalDate;

@ApplicationScoped
public class SaldoServiceImpl implements SaldoService {

    @Inject
    SaldoRepository repository;

    @Override
    public Saldo buscarSaldoCuentaBancoAndFecha(String dbName, Integer cuentaBancoId, LocalDate fecha) {
        return repository.buscarSaldosFechas(dbName, cuentaBancoId,fecha);
    }
}
