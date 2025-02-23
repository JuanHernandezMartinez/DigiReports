package org.juan.bancos.services.Implementations;

import jakarta.enterprise.context.ApplicationScoped;
import org.juan.bancos.models.DetalleBanco;
import org.juan.bancos.services.BancoService;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class BancoServiceImpl implements BancoService {

    @Override
    public List<DetalleBanco> obtenerDetallesPorFechas(LocalDate start, LocalDate end) {
        return List.of();
    }
}
