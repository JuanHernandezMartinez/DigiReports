package org.juan.bancos.services.Implementations;

import jakarta.inject.Inject;
import org.juan.bancos.models.Saldo;
import org.juan.bancos.repositories.SaldoRepository;
import org.juan.bancos.services.SaldoService;

import java.time.LocalDate;

public class SaldoServiceImpl implements SaldoService {

    @Inject
    private SaldoRepository repository;

    @Override
    public Saldo buscarSaldoCuentaBancoAndFecha(Integer cuentaBancoId, LocalDate fecha) {
        return repository.buscarSaldosFechas(cuentaBancoId,fecha);
    }
}
