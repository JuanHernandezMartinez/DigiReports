package org.juan.bancos.services;

import org.juan.bancos.dtos.DetalleBanco;

import java.time.LocalDate;
import java.util.List;

public interface BancoService {

    List<DetalleBanco> obtenerDetallesPorFechas(LocalDate start, LocalDate end) throws Exception;
}
