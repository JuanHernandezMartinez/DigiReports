package org.juan.bancos.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.juan.bancos.models.Movimiento;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MovimientoRepository {

    @Inject
    private EntityManager entityManager;

    public List<Movimiento> buscarMovimientosFechas(LocalDate start, LocalDate end){

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
                "\t\t\"FECHA\" BETWEEN :start AND :end) db\n" +
                "JOIN CUENTAS_BANCARIAS cb ON\n" +
                "\tdb.CUENTA_BAN_ID = cb.CUENTA_BAN_ID\n" +
                "GROUP BY\n" +
                "\tcb.CUENTA_BAN_ID," +
                "\tcb.NOMBRE" +
                "\tORDER BY cb.CUENTA_BAN_ID ASC";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("start", start);
        query.setParameter("end", end);
        List<Object[]> resultados = query.getResultList();
        List<Movimiento> movimientos = new ArrayList<>();

        PARSERESULTS : for(Object[] r:resultados){
            Movimiento movimiento = new Movimiento();
            movimiento.cuentaBancoId = (Integer) r[0];
            movimiento.banco = (String) r[1];
            movimiento.depositos = (BigDecimal) r[2];
            movimiento.retiros = (BigDecimal) r[3];
            movimientos.add(movimiento);
        }

        return movimientos;
    }
}
