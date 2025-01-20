package org.juan.ventas.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCTOS_VE")
public class DoctosVe extends PanacheEntity {
   
    @Column(name ="DOCTO_VE_ID")
    private Long doctoVeId;

    @Column(name ="TIPO_DOCTO")
    private String tipoDocto;


    @Column(name ="SUBTIPO_DOCTO")
    private String subtipoDocto;

    @Column(name ="SUCURSAL_ID")
    private Long sucursalId;

    @Column(name ="FOLIO")
    private String folio;

    @Column(name ="FECHA")
    private LocalDate fecha;

    @Column(name ="HORA")
    private LocalTime hora;

    @Column(name ="CLAVE_CLIENTE")
    private String claveCliente;

    @Column(name ="CLIENTE_ID")
    private Long clienteId;

    @Column(name ="DIR_CLI_ID")
    private Long dirCliId;

    @Column(name ="DIR_CONSIG_ID")
    private Long dirConsigId;

    @Column(name ="ALMACEN_ID")
    private Long almacenId;

    @Column(name ="LUGAR_EXPEDICION_ID")
    private Long lugarExpedicionId;

    @Column(name ="MONEDA_ID")
    private Long monedaId;

    @Column(name ="TIPO_CAMBIO")
    private Long tipoCambio;

    @Column(name ="TIPO_DSCTO")
    private String tipoDescuento;

    @Column(name ="DSCTO_PCTJE")
    private Long descuentoPorcentaje;

    @Column(name ="DSCTO_IMPORTE")
    private Long descuentoImporte;

    @Column(name ="ESTATUS")
    private String estatus;

    @Column(name ="APLICADO")
    private String aplicado;

    @Column(name ="FECHA_VIGENCIA_ENTREGA")
    private LocalDate fechaVigenciaEntrega;

    @Column(name ="ORDEN_COMPRA")
    private String ordenCompra;

    @Column(name ="FECHA_ORDEN_COMPRA")
    private LocalDate fechaOrdenCompra;

    @Column(name ="FOLIO_RECIBO_MERCANCIA")
    private String folioReciboMercancia;

    @Column(name ="FECHA_RECIBO_MERCANCIA")
    private LocalDate fechaReciboMercancia;

    @Column(name ="DESCRIPCION")
    private String descripcion;

    @Column(name ="IMPORTE_NETO")
    private Long importeNeto;

    @Column(name ="FLETES")
    private Long fletes;

    @Column(name ="OTROS_CARGOS")
    private Long otrosCargos;


    @Column(name ="TOTAL_IMPUESTOS")
    private Long totalImpuestos;

    @Column(name ="TOTAL_RETENCIONES")
    private Long totalRetenciones;

    @Column(name ="TOTAL_ANTICIPOS")
    private Long totalAnticipos;

    @Column(name ="PESO_EMBARQUE")
    private Long pesoEmbarque;

    @Column(name ="FORMA_EMITIDA")
    private String formaEmitida;

    @Column(name ="CONTABILIZADO")
    private String contabilizado;

    @Column(name ="ACREDITAR_CXC")
    private String acreditarCxc;

    @Column(name ="SISTEMA_ORIGEN")
    private String sistemaOrigen;

    @Column(name ="COND_PAGO_ID")
    private Integer condPagoId;

    @Column(name ="FECHA_DSCTO_PPAG")
    private LocalDate fechaDescuentoPPago;

    @Column(name ="PCTJE_DSCTO_PPAG")
    private Long porcentajeDescuentoPPago;

    @Column(name ="VENDEDOR_ID")
    private Long vendedorId;

    @Column(name ="PCTJE_COMIS")
    private Long porcentajeComision;

    @Column(name ="VIA_EMBARQUE_ID")
    private Long viaEmbarqueId;

    @Column(name ="IMPORTE_COBRO")
    private Long importeCobro;

    @Column(name ="DESCRIPCION_COBRO")
    private String descripcionCobro;

    @Column(name ="IMPUESTO_SUSTITUIDO_ID")
    private Long impuestoSustituidoId;

    @Column(name ="IMPUESTO_SUSTITUTO_ID")
    private Long impuestoSustitutoId;

    @Column(name ="USUARIO_CREADOR")
    private String usuarioCreador;

    @Column(name ="ES_CFD")
    private String esCfd;

    @Column(name ="MODALIDAD_FACTURACION")
    private String modalidadFacturacion;

    @Column(name ="ENVIADO")
    private String enviado;

    @Column(name ="FECHA_HORA_ENVIO")
    private LocalDateTime fechaHoraEnvio;

}
