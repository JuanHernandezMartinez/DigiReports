package org.juan.ventas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import io.agroal.api.AgroalDataSource;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import org.juan.datasource.DynamicDatasourceService;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class DoctosVentasRepository {

    private static final Logger log = LoggerFactory.getLogger(DoctosVentasRepository.class);
    @Inject
    DynamicDatasourceService dataSourceService;

    public List<Integer> findDoctosVesByDates(String dbName, LocalDate inicio, LocalDate fin){

        AgroalDataSource dataSource = dataSourceService.getDataSource(dbName);
        var sql = "SELECT d.DOCTO_VE_ID FROM DOCTOS_VE d WHERE d.FECHA BETWEEN ? AND ?";


        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, inicio.toString());
            stmt.setString(2,fin.toString());

            try(ResultSet rs = stmt.executeQuery()){
                List<Integer> articulos = new ArrayList<>();
                while (rs.next()){
                    articulos.add(rs.getInt("DOCTO_VE_ID"));
                }
                return articulos;
            }

        } catch (Exception e) {
            Log.info(e);
            throw new RuntimeException(e);
        }
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
