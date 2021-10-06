package com.nestor.tiendamusicalentities.entities;

import javax.persistence.*;
import java.util.List;

/**
 * @author Nestor
 * Clase que representa entidades de Facturas al realizar la compra de un carrito.
 */
@Entity
@Table(name = "factura")
public class Factura extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFactura")
    private Long idFactura;

    @Column(name = "orderId", length = 50, nullable = false)
    private String orderId;

    @Column(name = "impuestoTotal", nullable = false)
    private double impuestoTotal;

    @Column(name = "envio", nullable = false)
    private double envio;

    @Column(name = "envioDescuento", nullable = false)
    private double envioDescuento;

    @Column(name = "handling", nullable = false)
    private double handling;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "direccion", length = 500, nullable = false)
    private String direccion;

    @Column(name = "codigoPostal", length = 5, nullable = false)
    private String codigoPostal;

    @Column(name = "pais", length = 45, nullable = false)
    private String pais;

    @Column(name = "ciudad", length = 45, nullable = false)
    private String ciudad;

    @Column(name = "divisa", length = 45, nullable = false)
    private String divisa;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @OneToMany(mappedBy = "factura")
    private List<CarritoAlbum> carritosAlbum;

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getImpuestoTotal() {
        return impuestoTotal;
    }

    public void setImpuestoTotal(double impuestoTotal) {
        this.impuestoTotal = impuestoTotal;
    }

    public double getEnvio() {
        return envio;
    }

    public void setEnvio(double envio) {
        this.envio = envio;
    }

    public double getEnvioDescuento() {
        return envioDescuento;
    }

    public void setEnvioDescuento(double envioDescuento) {
        this.envioDescuento = envioDescuento;
    }

    public double getHandling() {
        return handling;
    }

    public void setHandling(double handling) {
        this.handling = handling;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<CarritoAlbum> getCarritosAlbum() {
        return carritosAlbum;
    }

    public void setCarritosAlbum(List<CarritoAlbum> carritosAlbum) {
        this.carritosAlbum = carritosAlbum;
    }
}
