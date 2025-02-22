package org.juan.ventas.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.juan.ventas.dtos.TotalFormaPago;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TotalFormaPagoRepository {

    @Inject
    EntityManager entityManager;

    public List<TotalFormaPago> findTotalesByFechas(LocalDate inicio, LocalDate fin){
        String sql =
                "SELECT\n" +
                        "\tCASE\n" +
                        "\t\tWHEN cc.CUENTA_ID = 8110 THEN 'EFECTIVO'\n" +
                        "\t\tWHEN cc.CUENTA_ID = 23648 THEN 'FALTANTES'\n" +
                        "\t\tWHEN cc.CUENTA_ID = 23646 THEN 'TARJETA'\n" +
                        "\t\tWHEN cc.CUENTA_ID = 23647 THEN 'TARJETA'\n" +
                        "\tWHEN cc.CUENTA_PADRE_ID = 7611 THEN 'CREDITO'\n" +
                        "\tEND AS formaPago,\n" +
                        "\tSUM(dcd.IMPORTE_MN) AS total\n" +
                        "FROM\n" +
                        "\tDOCTOS_CO_DET dcd\n" +
                        "JOIN CUENTAS_CO cc ON\n" +
                        "\tdcd.CUENTA_ID = cc.CUENTA_ID\n" +
                        "WHERE\n" +
                        "\tdcd.DOCTO_CO_ID IN (\n" +
                        "\tSELECT\n" +
                        "\t\tdc.DOCTO_CO_ID\n" +
                        "\tFROM\n" +
                        "\t\tDOCTOS_CO dc\n" +
                        "\tWHERE\n" +
                        "\t\tdc.FECHA BETWEEN :inicio AND :fin\n" +
                        "\t\tAND dc.DESCRIPCION LIKE 'VENTA%')\n" +
                        "\tAND dcd.TIPO_ASIENTO = 'C'\n" +
                        "\tAND (cc.CUENTA_ID IN (8110, 23648, 23646, 23647) \n" +
                        "\tOR cc.CUENTA_PADRE_ID = 7611) \n" +
                        "GROUP BY\n" +
                        "\tCASE\n" +
                        "\tWHEN cc.CUENTA_ID = 8110 THEN 'EFECTIVO'\n" +
                        "\tWHEN cc.CUENTA_ID = 23648 THEN 'FALTANTES'\n" +
                        "\tWHEN cc.CUENTA_ID = 23646 THEN 'TARJETA'\n" +
                        "\tWHEN cc.CUENTA_ID = 23647 THEN 'TARJETA'\n" +
                        "\tWHEN cc.CUENTA_PADRE_ID = 7611 THEN 'CREDITO'\n" +

                        "\tEND\n";



        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("inicio", inicio);
        query.setParameter("fin", fin);
        List<Object[]> resultados = query.getResultList();
        List<TotalFormaPago> totales = new ArrayList<>();

        for(Object[] r:resultados){
            TotalFormaPago total = new TotalFormaPago();
            total.setForma((String) r[0]);
            total.setTotal((BigDecimal) r[1]);
            totales.add(total);
        }

        return totales;
    }
}
