package org.juan.clientes.repository;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.clientes.models.SaldoCliente;
import org.juan.datasource.DynamicDatasourceService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClienteRepository {

    @Inject
    DynamicDatasourceService datasourceService;

    public List<SaldoCliente> getSaldoClientesByFechas(String dbName, LocalDate startDate, LocalDate endDate) throws RuntimeException {
        AgroalDataSource dataSource = datasourceService.getDataSource(dbName);
        String sql = "SELECT\n" +
                "\tcc.CUENTA_ID,\n" +
                "\tcc.NOMBRE,\n" +
                "\tCOALESCE(SUM(CASE WHEN dcd.TIPO_ASIENTO = 'A' THEN dcd.IMPORTE_MN END), 0) AS PAGO,\n" +
                "\tCOALESCE(SUM(CASE WHEN dcd.TIPO_ASIENTO = 'C' THEN dcd.IMPORTE_MN END), 0) AS CARGO\n" +
                "FROM\n" +
                "\tDOCTOS_CO_DET dcd\n" +
                "\tJOIN CUENTAS_CO cc ON dcd.CUENTA_ID = cc.CUENTA_ID \n" +
                "WHERE\n" +
                "\tdcd.\"FECHA\" BETWEEN ? AND ?\n" +
                "\tAND cc.CUENTA_PADRE_ID = 7611\n" +
                "\tGROUP BY cc.CUENTA_ID, cc.NOMBRE";
        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(startDate));
            stmt.setDate(2, Date.valueOf(endDate));

            try(ResultSet rs = stmt.executeQuery()){
                List<SaldoCliente> saldoClientes = new ArrayList<>();
                while (rs.next()){
                    SaldoCliente saldoCliente = new SaldoCliente();
                    saldoCliente.clienteId = rs.getInt("CUENTA_ID");
                    saldoCliente.nombre = rs.getString("NOMBRE");
                    saldoCliente.pago = rs.getBigDecimal("PAGO");
                    saldoCliente.cargo = rs.getBigDecimal("CARGO");
                    if (saldoCliente.clienteId != 7615) saldoClientes.add(saldoCliente);
                }
                return saldoClientes;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
