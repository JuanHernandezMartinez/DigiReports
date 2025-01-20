package org.juan.ventas.services.implementations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.juan.ventas.repositories.VentasRepository;
import org.juan.ventas.services.VentasService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class VentasServiceImpl implements VentasService {

    @Inject
    private VentasRepository ventasRepository;

    @Override
    public List<?> getVentas() throws Exception {
        // TODO Auto-generated method stub
        try {
            log.info("buscando doctos ve");
            var doctos = ventasRepository.finDoctosVes();
            return doctos;
        } catch (Exception e) {
            // TODO: handle exception
            log.error("Error al buscar doctos: {}", e.getMessage());
            throw new Exception("Ha ocurrido un error al buscar los documentos venta");
        }

    }

    @Override
    public List<?> getSoldsByDates(LocalDate inicio, LocalDate fin) throws Exception {
        // TODO Auto-generated method stub
        try {
            var fechaInicio = LocalDateTime.of(inicio.getYear(), inicio.getMonth(), inicio.getDayOfMonth(), 0, 0, 0);
            var fechaFin = LocalDateTime.of(fin.getYear(), fin.getMonth(), fin.getDayOfMonth(), 23, 59, 59);

            return ventasRepository.finDoctosVesByDates(fechaInicio, fechaFin);
        } catch (Exception e) {
           log.error("Error al buscar documentos ventas por fechas: {}",e.getMessage());
           throw new Exception(e.getMessage());
        }
    }

    
    
}
