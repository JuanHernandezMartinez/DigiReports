package org.juan.bancos.services;

import org.juan.bancos.models.Movimiento;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoService {

    List<Movimiento> buscarMovimientosPorFechas(LocalDate start, LocalDate end);
}
