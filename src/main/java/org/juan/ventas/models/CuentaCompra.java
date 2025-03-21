package org.juan.ventas.models;

import java.util.Objects;

//@Entity
//@Table(name = "CUENTAS_CO")
public class CuentaCompra {

//    @Id
//    @Column(name = "CUENTA_ID")
    private Integer id;

//    @Column(name = "CUENTA_PT")
    private String formaPago;

    public CuentaCompra() {}

    public CuentaCompra(Integer id, String formaPago) {
        this.id = id;
        this.formaPago = formaPago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public String toString() {
        return "CuentaCompra{" +
                "id=" + id +
                ", formaPago='" + formaPago + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CuentaCompra that = (CuentaCompra) o;
        return Objects.equals(id, that.id) && Objects.equals(formaPago, that.formaPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, formaPago);
    }
}
