package org.juan.bancos.repositories;

import io.agroal.api.AgroalDataSource;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.bancos.models.Saldo;
import org.juan.datasource.DynamicDatasourceService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

@ApplicationScoped
public class SaldoRepository {

    @Inject
    DynamicDatasourceService datasourceService;

    public Saldo buscarSaldosFechas(String dbName, Integer cuentaId, LocalDate fecha) {

        String sql = "select CUENTA_BAN_ID, SALDO from CALC_SALDO_CTABAN(?, ?, 'N');";

        AgroalDataSource dataSource = datasourceService.getDataSource(dbName);

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cuentaId);
            stmt.setDate(2, Date.valueOf(fecha));

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    Saldo saldo = new Saldo();
                    saldo.cuentaBancoId = rs.getInt("CUENTA_BAN_ID");
                    saldo.saldo = rs.getBigDecimal("SALDO");
                    return saldo;
                }
                return null;
            }
        } catch (Exception e) {
            Log.error("Error al buscar saldo por fechas", e);
            throw new RuntimeException(e);
        }
    }
}
