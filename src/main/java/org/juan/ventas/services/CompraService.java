package org.juan.ventas.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.juan.ventas.dtos.TotalFormaPago;
import org.juan.ventas.models.Compra;
import java.time.LocalDate;
import java.util.List;

public interface CompraService {

    List<TotalFormaPago> findByFechas(LocalDate inicio, LocalDate fin);
}
