package org.juan.ventas.repositories;

import io.agroal.api.AgroalDataSource;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.juan.datasource.DynamicDatasourceService;
import org.juan.ventas.dtos.TotalFormaPago;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class TotalFormaPagoRepository {

    @Inject
    DynamicDatasourceService datasourceService;

    public List<TotalFormaPago> findTotalesByFechas(String dbName, LocalDate startDate, LocalDate endDate) throws RuntimeException {

        AgroalDataSource dataSource = datasourceService.getDataSource(dbName);

        String sql =
                "SELECT\n" +
                        "\tCASE\n" +
                        "\t\tWHEN cc.CUENTA_ID = 8110 THEN 'EFECTIVO'\n" +
                        "\t\tWHEN cc.CUENTA_ID = 23648 THEN 'FALTANTES'\n" +
                        "\t\tWHEN cc.CUENTA_ID = 23646 THEN 'TARJETA'\n" +
                        "\t\tWHEN cc.CUENTA_ID = 23647 THEN 'TARJETA'\n" +
                        "\tWHEN cc.CUENTA_PADRE_ID = 7611 THEN 'CREDITO'\n" +
                        "\tEND AS FORMAPAGO,\n" +
                        "\tSUM(dcd.IMPORTE_MN) AS TOTAL\n" +
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
                        "\t\tdc.FECHA BETWEEN ? AND ?\n" +
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

        List<TotalFormaPago> totales = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(startDate));
            stmt.setDate(2, Date.valueOf(endDate));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TotalFormaPago total = new TotalFormaPago();
                    total.setForma(rs.getString("FORMAPAGO"));
                    total.setTotal(rs.getBigDecimal("TOTAL"));
                    totales.add(total);
                }
            }
            return totales;
        } catch (Exception e) {
            Log.info(e);
            throw new RuntimeException(e);
        }
    }
}
