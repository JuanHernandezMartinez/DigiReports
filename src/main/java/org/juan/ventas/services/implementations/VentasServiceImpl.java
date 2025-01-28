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
            return doctosVentasRepository.finDoctosVentas();
        } catch (Exception e) {
            System.out.println("Error al buscar doctos: " + e.getMessage());
            throw new Exception("Ha ocurrido un error al buscar los documentos venta");
        }

    }

    @Override
    public List<?> getSoldsByDates(LocalDate inicio, LocalDate fin) throws Exception {
        try {
            return doctosVentasRepository.finDoctosVesByDates(inicio, fin);
        } catch (Exception e) {
           System.out.println("Error al buscar documentos ventas por fechas: " + e.getMessage());
           throw new Exception(e.getMessage());
        }
    }

    
    
}
