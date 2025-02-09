package org.juan.ventas.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.annotations.Param;
import org.juan.ventas.services.TotalFormaPagoService;

import java.time.LocalDate;

@Path("/formas-pago")
public class TotalFormaPagoController {

    @Inject
    private TotalFormaPagoService service;

    @Path("/fechas/{inicio}/{fin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getTotalFormasPagoFechasHandler(@Param() LocalDate inicio, @Param() LocalDate fin){
        return new Object();
    }

}
