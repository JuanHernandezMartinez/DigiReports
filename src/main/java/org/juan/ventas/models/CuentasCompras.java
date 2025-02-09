package org.juan.ventas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUENTAS_CO")
public class CuentasCompras {

    @Id
    @Column(name = "CUENTA_ID")
    private Integer id;

    @Column(name = "CUENTA_PT")
    private Integer formaPago;
}
