package org.juan.ventas.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.annotations.Param;
import org.juan.ventas.dtos.TotalFormaPago;
import org.juan.ventas.services.TotalFormaPagoService;

import java.time.LocalDate;
import java.util.List;

@Path("/formas-pago")
public class TotalFormaPagoController {

    @Inject
    private TotalFormaPagoService service;

    @GET
    @Path("/fechas/{inicio}/{fin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TotalFormaPago> getTotalFormasPagoFechasHandler(@Param() LocalDate inicio, @Param() LocalDate fin){
        return service.TotalPorFormaDePagoYFechas(inicio, fin);
    }

}
