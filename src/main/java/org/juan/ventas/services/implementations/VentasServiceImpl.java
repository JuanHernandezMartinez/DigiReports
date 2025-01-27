package org.juan.ventas.services.implementations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.juan.ventas.repositories.DoctosVentasRepository;
import org.juan.ventas.services.VentasService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VentasServiceImpl implements VentasService {

    @Inject
    private DoctosVentasRepository doctosVentasRepository;

    @Override
    public List<?> getVentas() throws Exception {
        System.out.println("buscando doctos ve");
        try {
            var doctos = doctosVentasRepository.finDoctosVentas();
            System.out.println("docto: " + doctos.get(0));
            return doctos;
        } catch (Exception e) {
            System.out.println("Error al buscar doctos: " + e.getMessage());
            throw new Exception("Ha ocurrido un error al buscar los documentos venta");
        }

    }

    @Override
    public List<?> getSoldsByDates(LocalDate inicio, LocalDate fin) throws Exception {
        try {
            var fechaInicio = LocalDateTime.of(inicio.getYear(), inicio.getMonth(), inicio.getDayOfMonth(), 0, 0, 0);
            var fechaFin = LocalDateTime.of(fin.getYear(), fin.getMonth(), fin.getDayOfMonth(), 23, 59, 59);

            return doctosVentasRepository.finDoctosVesByDates(fechaInicio, fechaFin);
        } catch (Exception e) {
           System.out.println("Error al buscar documentos ventas por fechas: " + e.getMessage());
           throw new Exception(e.getMessage());
        }
    }

    
    
}
