package org.juan.clientes.repository;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.clientes.models.SaldoCliente;
import org.juan.clientes.models.SaldoCuenta;
import org.juan.datasource.DynamicDatasourceService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SaldoCuentaRepository {

    @Inject
    DynamicDatasourceService datasourceService;

    public SaldoCuenta getSaldosCuenta(String dbName, Integer cuentaId, LocalDate date) throws RuntimeException {
        AgroalDataSource dataSource = datasourceService.getDataSource(dbName);
        String sql = "SELECT * from GET_SALDO_CUENTA(?, 0, ?, 'S')";
        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cuentaId);
            stmt.setDate(2, Date.valueOf(date));

            try(ResultSet rs = stmt.executeQuery()){
                SaldoCuenta saldoCuenta = new SaldoCuenta();
                while (rs.next()){
                    saldoCuenta.cuentaId = rs.getInt("CUENTA_ID");
                    saldoCuenta.saldo = rs.getBigDecimal("SALDO");
                }
                return saldoCuenta;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
