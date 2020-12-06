package com.example.app_encuentralo.entidades;

public class Producto {
    String codProducto;
    String descripcion;
    String categoria;
    String cadena;
    double precio;

    public Producto(String codProducto, String descripcion, String categoria, String cadena, double precio) {
        this.codProducto = codProducto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.cadena = cadena;
        this.precio = precio;
    }

    public Producto(){

    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
