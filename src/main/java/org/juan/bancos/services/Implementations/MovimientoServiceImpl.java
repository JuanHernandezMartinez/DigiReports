package org.juan.bancos.services.Implementations;

import jakarta.inject.Inject;
import org.juan.bancos.models.Movimiento;
import org.juan.bancos.repositories.MovimientoRepository;
import org.juan.bancos.services.MovimientoService;

import java.time.LocalDate;
import java.util.List;

public class MovimientoServiceImpl implements MovimientoService {

    @Inject
    private MovimientoRepository repository;

    @Override
    public List<Movimiento> buscarMovimientosPorFechas(LocalDate start, LocalDate end) {
        return repository.buscarMovimientosFechas(start,end);
    }
}
