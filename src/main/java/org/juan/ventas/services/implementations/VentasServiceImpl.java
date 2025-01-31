package org.juan.ventas.services.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.juan.ventas.dtos.VentaDto;
import org.juan.ventas.models.Articulo;
import org.juan.ventas.models.DoctosVentaDetalles;
import org.juan.ventas.repositories.ArticulosRepository;
import org.juan.ventas.repositories.DoctosVentaDetallesRepository;
import org.juan.ventas.repositories.DoctosVentasRepository;
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
    public List<?> obtenerVentasPorFechas(LocalDate inicio, LocalDate fin) throws Exception {

        List<Integer> doctosVentaIds = doctosVentasRepository.findDoctosVesByDates(inicio, fin);
        System.out.println("Cantidad de ids encontrados: " + doctosVentaIds.toString());

        List<DoctosVentaDetalles> detalles = detallesRepository.findDetallesByDoctosVeIds(doctosVentaIds);
        System.out.println("Cantidad de detalles encontrados: " + detalles.size());

        List<Integer> articlesIds = new ArrayList<>();
        detalles.forEach((d) -> {
            articlesIds.add(d.articuloId);
        });

        List<Articulo> articulos = articulosRepository.findArticlesByIds(articlesIds);

        var dto = VentaDto.builder().build();
        Map<Integer, VentaDto> detallesArticulos = new HashMap<>();

        for(DoctosVentaDetalles docto: detalles){

        }

        return articulos;
    }


}
