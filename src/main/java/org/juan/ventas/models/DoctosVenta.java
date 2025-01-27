package org.juan.ventas.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCTOS_VE")
public class DoctosVenta {
   
    @Id
    @Column(name ="DOCTO_VE_ID")
    public Integer doctoVeId;

    @Column(name ="TIPO_DOCTO")
    public char tipoDocto;


    @Column(name ="SUBTIPO_DOCTO")
    public char subtipoDocto;

    @Column(name ="SUCURSAL_ID")
    public Integer sucursalId;

    @Column(name ="FOLIO")
    public char folio;

    @Column(name ="FECHA")
    public LocalDate fecha;

    @Column(name ="HORA")
    public LocalTime hora;

    @Column(name ="CLAVE_CLIENTE")
    public String claveCliente;

    @Column(name ="CLIENTE_ID")
    public Integer clienteId;

    @Column(name ="DIR_CLI_ID")
    public Integer dirCliId;

    @Column(name ="DIR_CONSIG_ID")
    public Integer dirConsigId;

    @Column(name ="ALMACEN_ID")
    public Integer almacenId;

    @Column(name ="LUGAR_EXPEDICION_ID")
    public Integer lugarExpedicionId;

    @Column(name ="MONEDA_ID")
    public Integer monedaId;

    @Column(name ="TIPO_CAMBIO")
    public BigDecimal tipoCambio;

    @Column(name ="TIPO_DSCTO")
    public char tipoDescuento;

    @Column(name ="DSCTO_PCTJE")
    public BigDecimal descuentoPorcentaje;

    @Column(name ="DSCTO_IMPORTE")
    public BigDecimal descuentoImporte;

    @Column(name ="ESTATUS")
    public char estatus;

    @Column(name ="APLICADO")
    public char aplicado;

    @Column(name ="FECHA_VIGENCIA_ENTREGA")
    public LocalDate fechaVigenciaEntrega;

    @Column(name ="ORDEN_COMPRA")
    public String ordenCompra;

    @Column(name ="FECHA_ORDEN_COMPRA")
    public LocalDate fechaOrdenCompra;

    @Column(name ="FOLIO_RECIBO_MERCANCIA")
    public String folioReciboMercancia;

    @Column(name ="FECHA_RECIBO_MERCANCIA")
    public LocalDate fechaReciboMercancia;

    @Column(name ="DESCRIPCION")
    public String descripcion;

    @Column(name ="IMPORTE_NETO")
    public BigDecimal importeNeto;

    @Column(name ="FLETES")
    public BigDecimal fletes;

    @Column(name ="OTROS_CARGOS")
    public BigDecimal otrosCargos;


    @Column(name ="TOTAL_IMPUESTOS")
    public BigDecimal totalImpuestos;

    @Column(name ="TOTAL_RETENCIONES")
    public BigDecimal totalRetenciones;

    @Column(name ="TOTAL_ANTICIPOS")
    public BigDecimal totalAnticipos;

    @Column(name ="PESO_EMBARQUE")
    public BigDecimal pesoEmbarque;

    @Column(name ="FORMA_EMITIDA")
    public char formaEmitida;

    @Column(name ="CONTABILIZADO")
    public char contabilizado;

    @Column(name ="ACREDITAR_CXC")
    public char acreditarCxc;

    @Column(name ="SISTEMA_ORIGEN")
    public char sistemaOrigen;

    @Column(name ="COND_PAGO_ID")
    public Integer condPagoId;

    @Column(name ="FECHA_DSCTO_PPAG")
    public LocalDate fechaDescuentoPPago;

    @Column(name ="PCTJE_DSCTO_PPAG")
    public BigDecimal porcentajeDescuentoPPago;

    @Column(name ="VENDEDOR_ID")
    public Integer vendedorId;

    @Column(name ="PCTJE_COMIS")
    public BigDecimal porcentajeComision;

    @Column(name ="VIA_EMBARQUE_ID")
    public Integer viaEmbarqueId;

    @Column(name ="IMPORTE_COBRO")
    public BigDecimal importeCobro;

    @Column(name ="DESCRIPCION_COBRO")
    public String descripcionCobro;

    @Column(name ="IMPUESTO_SUSTITUIDO_ID")
    public Integer impuestoSustituidoId;

    @Column(name ="IMPUESTO_SUSTITUTO_ID")
    public Integer impuestoSustitutoId;

    @Column(name ="USUARIO_CREADOR")
    public String usuarioCreador;

    @Column(name ="ES_CFD")
    public char esCfd;

    @Column(name ="MODALIDAD_FACTURACION")
    public String modalidadFacturacion;

    @Column(name ="ENVIADO")
    public char enviado;

    @Column(name ="FECHA_HORA_ENVIO")
    public LocalDateTime fechaHoraEnvio;

    @Column(name ="EMAIL_ENVIO")
    public String emailEnvio;

    @Column(name ="CFD_ENVIO_ESPECIAL")
    public char cfdEnvioEspecial;

    @Column(name = "USO_CFDI")
    public Character usoCfdi;

    @Column(name ="METODO_PAGO_SAT")
    public Character metodoPagoSat;

    @Column(name ="CFDI_CERTIFICADO")
    public char cfdiCertificado;

    @Column(name ="CFDI_FACT_DEVUELTA_ID")
    public Integer cfdiFactDevueltaId;

    @Column(name ="FECHA_HORA_CREACION")
    public LocalDateTime fechaHoraCreacion;

    @Column(name ="USUARIO_ULT_MODIF")
    public String usuarioUltModif;

    @Column(name ="USUARIO_AUT_CREACION")
    public String usuarioAutCreacion;

    @Column(name ="FECHA_HORA_ULT_MODIF")
    public LocalDateTime fechaHoraUltModif;

    @Column(name ="CARGAR_SUN")
    public char cargarSun;

    @Column(name ="USUARIO_AUT_MODIF")
    public String usuarioAutModif;

    @Column(name ="USUARIO_CANCELACION")
    public String usuarioCancelacion;

    @Column(name ="FECHA_HORA_CANCELACION")
    public LocalDateTime fechaHoraCancelacion;

    @Column(name ="USUARIO_AUT_CANCELACION")
    public String usuarioAutCancelacion;

    public DoctosVenta() {
    }


}
