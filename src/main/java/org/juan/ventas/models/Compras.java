package org.juan.ventas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "DOCTOS_CO")
public class Compras {

    @Id
    @Column(name = "DOCTO_CO_ID")
    private Integer id;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "DESCRIPCION")
    private String descripcion;
}
