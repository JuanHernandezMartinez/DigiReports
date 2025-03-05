package org.juan.ventas.services;

import org.juan.ventas.dtos.TotalFormaPago;

import java.time.LocalDate;
import java.util.List;

public interface TotalFormaPagoService {

    List<TotalFormaPago> totalPorFormaDePagoYFechas(String dbName, LocalDate startDate, LocalDate endDate) throws RuntimeException;
}
