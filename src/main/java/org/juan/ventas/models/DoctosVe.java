package org.juan.ventas.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DOCTOS_VE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctosVe {
   
    @Id
    @Column(name ="DOCTO_VE_ID")
    private Integer doctoVeId;

    @Column(name ="TIPO_DOCTO")
    private char tipoDocto;


    @Column(name ="SUBTIPO_DOCTO")
    private char subtipoDocto;

    @Column(name ="SUCURSAL_ID")
    private Integer sucursalId;

    @Column(name ="FOLIO")
    private char folio;

    @Column(name ="FECHA")
    private LocalDate fecha;

    @Column(name ="HORA")
    private LocalTime hora;

    @Column(name ="CLAVE_CLIENTE")
    private String claveCliente;

    @Column(name ="CLIENTE_ID")
    private Integer clienteId;

    @Column(name ="DIR_CLI_ID")
    private Integer dirCliId;

    @Column(name ="DIR_CONSIG_ID")
    private Integer dirConsigId;

    @Column(name ="ALMACEN_ID")
    private Integer almacenId;

    @Column(name ="LUGAR_EXPEDICION_ID")
    private Integer lugarExpedicionId;

    @Column(name ="MONEDA_ID")
    private Integer monedaId;

    @Column(name ="TIPO_CAMBIO")
    private BigDecimal tipoCambio;

    @Column(name ="TIPO_DSCTO")
    private char tipoDescuento;

    @Column(name ="DSCTO_PCTJE")
    private BigDecimal descuentoPorcentaje;

    @Column(name ="DSCTO_IMPORTE")
    private BigDecimal descuentoImporte;

    @Column(name ="ESTATUS")
    private char estatus;

    @Column(name ="APLICADO")
    private char aplicado;

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
    private BigDecimal importeNeto;

    @Column(name ="FLETES")
    private BigDecimal fletes;

    @Column(name ="OTROS_CARGOS")
    private BigDecimal otrosCargos;


    @Column(name ="TOTAL_IMPUESTOS")
    private BigDecimal totalImpuestos;

    @Column(name ="TOTAL_RETENCIONES")
    private BigDecimal totalRetenciones;

    @Column(name ="TOTAL_ANTICIPOS")
    private BigDecimal totalAnticipos;

    @Column(name ="PESO_EMBARQUE")
    private BigDecimal pesoEmbarque;

    @Column(name ="FORMA_EMITIDA")
    private char formaEmitida;

    @Column(name ="CONTABILIZADO")
    private char contabilizado;

    @Column(name ="ACREDITAR_CXC")
    private char acreditarCxc;

    @Column(name ="SISTEMA_ORIGEN")
    private char sistemaOrigen;

    @Column(name ="COND_PAGO_ID")
    private Integer condPagoId;

    @Column(name ="FECHA_DSCTO_PPAG")
    private LocalDate fechaDescuentoPPago;

    @Column(name ="PCTJE_DSCTO_PPAG")
    private BigDecimal porcentajeDescuentoPPago;

    @Column(name ="VENDEDOR_ID")
    private Integer vendedorId;

    @Column(name ="PCTJE_COMIS")
    private BigDecimal porcentajeComision;

    @Column(name ="VIA_EMBARQUE_ID")
    private Integer viaEmbarqueId;

    @Column(name ="IMPORTE_COBRO")
    private BigDecimal importeCobro;

    @Column(name ="DESCRIPCION_COBRO")
    private String descripcionCobro;

    @Column(name ="IMPUESTO_SUSTITUIDO_ID")
    private Integer impuestoSustituidoId;

    @Column(name ="IMPUESTO_SUSTITUTO_ID")
    private Integer impuestoSustitutoId;

    @Column(name ="USUARIO_CREADOR")
    private String usuarioCreador;

    @Column(name ="ES_CFD")
    private char esCfd;

    @Column(name ="MODALIDAD_FACTURACION")
    private String modalidadFacturacion;

    @Column(name ="ENVIADO")
    private char enviado;

    @Column(name ="FECHA_HORA_ENVIO")
    private LocalDateTime fechaHoraEnvio;

    @Column(name ="EMAIL_ENVIO")
    private String emailEnvio;

    @Column(name ="CFD_ENVIO_ESPECIAL")
    private char cfdEnvioEspecial;

    @Column(name = "USO_CFDI")
    private Character usoCfdi;

    @Column(name ="METODO_PAGO_SAT")
    private Character metodoPagoSat;

    @Column(name ="CFDI_CERTIFICADO")
    private char cfdiCertificado;

    @Column(name ="CFDI_FACT_DEVUELTA_ID")
    private Integer cfdiFactDevueltaId;

    @Column(name ="FECHA_HORA_CREACION")
    private LocalDateTime fechaHoraCreacion;

    @Column(name ="USUARIO_ULT_MODIF")
    private String usuarioUltModif;

    @Column(name ="USUARIO_AUT_CREACION")
    private String usuarioAutCreacion;

    @Column(name ="FECHA_HORA_ULT_MODIF")
    private LocalDateTime fechaHoraUltModif;

    @Column(name ="CARGAR_SUN")
    private char cargarSun;

    @Column(name ="USUARIO_AUT_MODIF")
    private String usuarioAutModif;

    @Column(name ="USUARIO_CANCELACION")
    private String usuarioCancelacion;

    @Column(name ="FECHA_HORA_CANCELACION")
    private LocalDateTime fechaHoraCancelacion;

    @Column(name ="USUARIO_AUT_CANCELACION")
    private String usuarioAutCancelacion;
}
