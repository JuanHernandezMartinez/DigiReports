package org.juan.ventas.repositories;

import java.time.LocalDateTime;
import java.util.List;
import org.juan.ventas.models.DoctosVenta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DoctosVentasRepository implements PanacheRepository<DoctosVenta>  {

    public List<DoctosVenta> finDoctosVentas(){
        return listAll();
    }

    public List<DoctosVenta> finDoctosVesByDates(LocalDateTime inicio, LocalDateTime fin){
        return list("fechaHoraCreacion BETWEEN ?1 AND ?2", inicio, fin);
    }

    //consulta para obtener unidades por ARTICULO_ID
    //SELECT * FROM DOCTOS_VE_DET dvd WHERE dvd.DOCTO_VE_ID in (3147559, 3147580, 3147615, 3147642) AND dvd.ARTICULO_ID = 11856;

    //consulta para seleccionar DOCTOS_VE por fecha
    //SELECT * FROM DOCTOS_VE dv WHERE dv.FECHA = '2024-10-02'

    //se puede consultar el docto ve por fechas, una vez encontrado los doctos ve, ahora hay que encontrar los detalles doctos ve, y con esto encontramos los articulos, unidades y totales
    //al sumar las unidades si cuadran con los resultados unidades de la tabla, sin embargo no cuandran los resultados de los totales de la tabla, no se si se debe aplicar IVA O ALGO EXTRA?
    
}
