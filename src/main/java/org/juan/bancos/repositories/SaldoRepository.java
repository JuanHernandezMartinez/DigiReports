package org.juan.bancos.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.juan.bancos.models.Saldo;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SaldoRepository {

    @Inject
    private EntityManager entityManager;

    public Saldo buscarMovimientosFechas(Integer cuentaId, LocalDate fecha) {

        String sql = "select CUENTA_BAN_ID, SALDO from CALC_SALDO_CTABAN(:cuentaId, :fecha, 'N');";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("cuentaId", cuentaId);
        query.setParameter("fecha", fecha);
        Object[] restult = ( Object[]) query.getSingleResult();
        Saldo saldo = new Saldo();
        saldo.cuentaBancoId = (Integer) restult[0];
        saldo.saldoInicial = (BigDecimal) restult[1];
        return saldo;
    }
}
