package org.juan.ventas.services.implementations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import org.juan.ventas.models.Articulo;
import org.juan.ventas.models.DoctosVentaDetalles;
import org.juan.ventas.models.Impuesto;
import org.juan.ventas.repositories.ArticulosRepository;
import org.juan.ventas.repositories.DoctosVentaDetallesRepository;
import org.juan.ventas.repositories.DoctosVentasRepository;
import org.juan.ventas.repositories.ImpuestosDetallesRepository;
import org.juan.ventas.services.VentasService;
import jakarta.inject.Inject;

@RequestScoped
public class VentasServiceImpl implements VentasService {

    @Inject
    DoctosVentasRepository ventasRepository;

    @Inject
    DoctosVentaDetallesRepository detallesRepository;

    @Inject
    ArticulosRepository articulosRepository;

    @Inject
    ImpuestosDetallesRepository impuestosRepository;

    @Override
    public List<Articulo> obtenerVentasArticulosPorFechas(String dbName, LocalDate inicio, LocalDate fin) throws Exception {
        try {
            // Buscar las ventas segun las fechas
            List<Integer> ventas = ventasRepository.findDoctosVesByDates(dbName, inicio, fin);

            // Buscar los detalles de las ventas
            List<DoctosVentaDetalles> detallesVentas = detallesRepository.findDetallesByVentas(dbName, ventas);
            List<Integer> detallesIds = detallesVentas.stream().map(d -> d.doctoVeDetId).toList();

            // Buscar los impuestos por detalle
            List<Impuesto> impuestosDetalles = impuestosRepository.findImpuestosByDetallesIds(detallesIds);

            //Articulos que se devolveran
            Articulo diesel = articulosRepository.findArticuloByName(dbName,"DIESEL");
            Articulo magna = articulosRepository.findArticuloByName(dbName,"MAGNA");
            Articulo pemex = articulosRepository.findArticuloByName(dbName,"PEMEX PREMIUM");
            Articulo aceites = new Articulo(0, "ACEITES Y LUBRICANTES", BigDecimal.ZERO, BigDecimal.ZERO);

            for (DoctosVentaDetalles detail : detallesVentas) {
                // Sumar el impuesto al total neto a cada detalle
                for (Impuesto imp : impuestosDetalles) {
                    if (imp.getDetalleId().equals(detail.doctoVeDetId)) {
                        detail.precioTotalNeto = detail.precioTotalNeto.add(imp.getImporteImpuesto());
                    }
                }
                // Sumar las unidades y el precio neto a cada articulo
                    if (detail.articuloId.equals(diesel.getId())) {
                        diesel.setUnidades(diesel.getUnidades().add(detail.unidades));
                        diesel.setTotal(diesel.getTotal().add(detail.precioTotalNeto));
                    }
                    else if (detail.articuloId.equals(magna.getId())) {
                        magna.setUnidades(magna.getUnidades().add(detail.unidades));
                        magna.setTotal(magna.getTotal().add(detail.precioTotalNeto));
                    }
                    else if (detail.articuloId.equals(pemex.getId())) {
                        pemex.setUnidades(pemex.getUnidades().add(detail.unidades));
                        pemex.setTotal(pemex.getTotal().add(detail.precioTotalNeto));
                    }
                    else {
                        aceites.setUnidades(aceites.getUnidades().add(detail.unidades));
                        aceites.setTotal(aceites.getTotal().add(detail.precioTotalNeto));
                    }
                
            }

            List<Articulo> listaFinal = new ArrayList<Articulo>();
            listaFinal.add(diesel);
            listaFinal.add(magna);
            listaFinal.add(pemex);
            listaFinal.add(aceites);

            return listaFinal;
        } catch (Exception e) {
            Log.error("Error: " + e);
            throw new Exception("Error obteniendo ventas entre " + inicio + " y " + fin, e);
        }
    }
}
