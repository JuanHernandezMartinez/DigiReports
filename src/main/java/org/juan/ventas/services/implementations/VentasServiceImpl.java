package org.juan.ventas.services.implementations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.juan.ventas.dtos.ArticuloTotal;
import org.juan.ventas.models.Articulo;
import org.juan.ventas.models.DoctosVentaDetalles;
import org.juan.ventas.models.Impuesto;
import org.juan.ventas.repositories.ArticulosRepository;
import org.juan.ventas.repositories.DoctosVentaDetallesRepository;
import org.juan.ventas.repositories.DoctosVentasRepository;
import org.juan.ventas.repositories.ImpuestosDetallesRepository;
import org.juan.ventas.services.VentasService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VentasServiceImpl implements VentasService {

    @Inject
    private DoctosVentasRepository doctosVentasRepository;

    @Inject
    private DoctosVentaDetallesRepository detallesRepository;

    @Inject
    private ArticulosRepository articulosRepository;

    @Inject
    private ImpuestosDetallesRepository impuestosDetallesRepository;

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
    public List<ArticuloTotal> obtenerVentasPorFechas(LocalDate inicio, LocalDate fin) throws Exception {

        try {
            List<ArticuloTotal> articulosTotal = detallesRepository.findTotalesArticulos(inicio, fin);
            System.out.println("Cantidad de ids encontrados: " + articulosTotal);
        return articulosTotal;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("Errorazo");
        }

    }

}
