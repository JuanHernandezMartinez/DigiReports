package org.juan.ventas.services.implementations;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.ventas.dtos.TotalFormaPago;
import org.juan.ventas.repositories.TotalFormaPagoRepository;
import org.juan.ventas.services.CompraService;
import org.juan.ventas.services.TotalFormaPagoService;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class TotalFormaPagoServiceImpl implements TotalFormaPagoService  {

    @Inject
    private TotalFormaPagoRepository repository;

    @Override
    public List<TotalFormaPago> TotalPorFormaDePagoYFechas(LocalDate inicio, LocalDate fin){
        Log.info("Buscando totales por forma de pago, fechas: " + inicio + " y " + fin);
        return repository.findTotalesByFechas(inicio,fin);
    }

}
