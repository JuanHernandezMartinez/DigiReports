package org.juan.ventas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ARTICULOS")
public class Articulo {

    @Id
    @Column(name = "ARTICULO_ID")
    public Integer id;

}
