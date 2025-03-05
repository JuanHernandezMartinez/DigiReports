package org.juan.bancos.services.Implementations;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.bancos.models.Movimiento;
import org.juan.bancos.repositories.MovimientoRepository;
import org.juan.bancos.services.MovimientoService;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class MovimientoServiceImpl implements MovimientoService {

    @Inject
    private MovimientoRepository repository;

    @Override
    public List<Movimiento> buscarMovimientosPorFechas(String dbName, LocalDate start, LocalDate end) throws RuntimeException {
        return repository.buscarMovimientosFechas(dbName, start,end);
    }
}
