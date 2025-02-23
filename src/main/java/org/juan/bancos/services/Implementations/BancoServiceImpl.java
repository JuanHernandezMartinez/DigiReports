package org.juan.bancos.services.Implementations;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.bancos.models.DetalleBanco;
import org.juan.bancos.models.Movimiento;
import org.juan.bancos.models.Saldo;
import org.juan.bancos.services.BancoService;
import org.juan.bancos.services.MovimientoService;
import org.juan.bancos.services.SaldoService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BancoServiceImpl implements BancoService {

    @Inject
     private SaldoService saldoService;

    @Inject
    private MovimientoService movimientoService;

    @Override
    public List<DetalleBanco> obtenerDetallesPorFechas(LocalDate start, LocalDate end) {

        List<Movimiento> movimientos = movimientoService.buscarMovimientosPorFechas(start,end);
        List<Integer> cuentasBancoIds = movimientos.stream().map(m->m.cuentaBancoId).toList();

        Log.info("Movimientos: " + movimientos.toString());
        LocalDate diaAnterior = start.minusDays(1);
        List<Saldo> saldosIniciales = saldosPorBancos(cuentasBancoIds, diaAnterior);
        List<Saldo> saldosFinales = saldosPorBancos(cuentasBancoIds, end);
        return crearDetallesBancos(movimientos, saldosIniciales, saldosFinales);
    }

    private List<Saldo> saldosPorBancos(List<Integer> cuentasBancoIds, LocalDate fecha){
        List<Saldo> saldos = new ArrayList<>();
        for (Integer cuentaId : cuentasBancoIds){
            saldos.add(saldoService.buscarSaldoCuentaBancoAndFecha(cuentaId, fecha));
        }

        return saldos;
    }

    private List<DetalleBanco> crearDetallesBancos(List<Movimiento> movimientos, List<Saldo> saldosIniciales, List<Saldo> saldosFinales){

        List<DetalleBanco> detalles = new ArrayList<>();

        mvoimientos:
        for (Movimiento movimiento : movimientos) {
            DetalleBanco detalle = new DetalleBanco();
            saldosIniciales:
            for (Saldo saldo : saldosIniciales) {
                if (movimiento.cuentaBancoId.equals(saldo.cuentaBancoId)) {
                    detalle.cuentaBancoId = movimiento.cuentaBancoId;
                    detalle.banco = movimiento.banco;
                    detalle.depositors = movimiento.depositos;
                    detalle.retiros = movimiento.retiros;
                    detalle.saldoInicial = saldo.saldo;
                }
            }
            saldosFinales:
            for (Saldo saldo : saldosFinales) {
                if (movimiento.cuentaBancoId.equals(saldo.cuentaBancoId)) {
                    detalle.cuentaBancoId = movimiento.cuentaBancoId;
                    detalle.banco = movimiento.banco;
                    detalle.depositors = movimiento.depositos;
                    detalle.retiros = movimiento.retiros;
                    detalle.saldoFinal = saldo.saldo;
                    detalles.add(detalle);
                }
            }

        }
        return detalles;
    }
}
