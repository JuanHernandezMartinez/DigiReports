package org.juan.bancos.repositories;

import io.agroal.api.AgroalDataSource;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.bancos.models.Movimiento;
import org.juan.datasource.DynamicDatasourceService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MovimientoRepository {

    @Inject
    DynamicDatasourceService datasourceService;

    public List<Movimiento> buscarMovimientosFechas(String dbName, LocalDate start, LocalDate end) throws RuntimeException {

        AgroalDataSource dataSource = datasourceService.getDataSource(dbName);
        String sql = "SELECT\n" +
                "\tcb.CUENTA_BAN_ID,\n"+
                "\tcb.NOMBRE,\n" +
                "\tSUM(CASE WHEN db.TIPO_MOVTO = 'D' THEN db.IMPORTE ELSE 0 END) AS DEPOSITO,\n" +
                "\tSUM(CASE WHEN db.TIPO_MOVTO = 'R' THEN db.IMPORTE ELSE 0 END) AS RETIRO\n" +
                "FROM\n" +
                "\t(\n" +
                "\tSELECT\n" +
                "\t\t*\n" +
                "\tFROM\n" +
                "\t\tDOCTOS_BA\n" +
                "\tWHERE\n" +
                "\t\t\"FECHA\" BETWEEN ? AND ?) db\n" +
                "JOIN CUENTAS_BANCARIAS cb ON\n" +
                "\tdb.CUENTA_BAN_ID = cb.CUENTA_BAN_ID\n" +
                "GROUP BY\n" +
                "\tcb.CUENTA_BAN_ID," +
                "\tcb.NOMBRE" +
                "\tORDER BY cb.CUENTA_BAN_ID ASC";

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(start));
            stmt.setDate(2, Date.valueOf(end));

            try(ResultSet rs = stmt.executeQuery()){
                List<Movimiento> movimientos = new ArrayList<>();
                while (rs.next()){
                    Movimiento movimiento = new Movimiento();
                    movimiento.cuentaBancoId= rs.getInt("CUENTA_BAN_ID");
                    movimiento.banco = rs.getString("NOMBRE");
                    movimiento.depositos = rs.getBigDecimal("DEPOSITO");
                    movimiento.retiros = rs.getBigDecimal("RETIRO");
                    movimientos.add(movimiento);
                }
                return movimientos;
            }
        } catch (Exception e) {
            Log.error("Error al buscar movimientos por fechas", e);
            throw new RuntimeException(e);
        }


//        Query query = entityManager.createNativeQuery(sql);
//        query.setParameter("start", start);
//        query.setParameter("end", end);
//        List<Object[]> resultados = query.getResultList();
//        List<Movimiento> movimientos = new ArrayList<>();
//
//        PARSERESULTS : for(Object[] r:resultados){
//            Movimiento movimiento = new Movimiento();
//            movimiento.cuentaBancoId = (Integer) r[0];
//            movimiento.banco = (String) r[1];
//            movimiento.depositos = (BigDecimal) r[2];
//            movimiento.retiros = (BigDecimal) r[3];
//            movimientos.add(movimiento);
//        }
//
//        return movimientos;
    }
}
