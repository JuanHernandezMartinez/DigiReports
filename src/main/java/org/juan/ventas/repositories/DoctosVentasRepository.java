package org.juan.ventas.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.juan.ventas.models.DoctosVenta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DoctosVentasRepository implements PanacheRepository<DoctosVenta>  {

    public List<DoctosVenta> finDoctosVentas(){
        return listAll();
    }

    public List<Integer> findDoctosVesByDates(LocalDate inicio, LocalDate fin){
        return getEntityManager()
                .createQuery("SELECT d.doctoVeId FROM DoctosVenta d WHERE d.fecha BETWEEN :inicio AND :fin", Integer.class)
                .setParameter("inicio", inicio)
                .setParameter("fin", fin)
                .getResultList();
    }

    //listo
    //consulta para seleccionar DOCTOS_VE por fecha
    //SELECT * FROM DOCTOS_VE dv WHERE dv.FECHA = '2024-10-02'

    //listo
    //consulta para obtener unidades por ARTICULO_ID
    //SELECT * FROM DOCTOS_VE_DET dvd WHERE dvd.DOCTO_VE_ID in (3147559, 3147580, 3147615, 3147642) AND dvd.ARTICULO_ID = 11856;

    //se puede consultar el docto ve por fechas, una vez encontrado los doctos ve, ahora hay que encontrar los detalles doctos ve, y con esto encontramos los articulos, unidades y totales
    //al sumar las unidades si cuadran con los resultados unidades de la tabla, sin embargo no cuandran los resultados de los totales de la tabla, no se si se debe aplicar IVA O ALGO EXTRA?

    //para que cuadrer el TOTAL DE VENTAS hay que sumar los totales netos y ademas el IMPORTE_IMPUESTO_BRUTO por cada DOCTO_DETALLE_VE por cada articulo
    //SELECT * FROM IMPUESTOS_DOCTOS_VE_DET idvd WHERE  idvd.DOCTO_VE_DET_ID  in (3147585, 3147618, 3147643);
    
}
