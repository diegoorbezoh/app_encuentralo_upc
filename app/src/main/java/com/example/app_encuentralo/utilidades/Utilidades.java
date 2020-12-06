package com.example.app_encuentralo.utilidades;

public class Utilidades {

    //Constantes tabla Usuario
    public static final String TABLA_USUARIO ="usuario";
    public static final String TABLA_USUARIO_NOMBRE = "nombre";
    public static final String TABLA_USUARIO_CONTRASENIA ="contrasenia";
    public static final String TABLA_USUARIO_EMAIL = "email";
    public static final String TABLA_USUARIO_EDAD = "edad";

    //Constantes tabla Producto
    public static final String TABLA_PRODUCTO = "producto";
    public static final String TABLA_PRODUCTO_CODIGO = "codProducto";
    public static final String TABLA_PRODUCTO_DESCRIPCION = "descripcion";
    public static final String TABLA_PRODUCTO_CATEGORIA = "categoria";
    public static final String TABLA_PRODUCTO_CADENA = "cadena";
    public static final String TABLA_PRODUCTO_PRECIO = "precio";




    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+ TABLA_USUARIO+ " ("+TABLA_USUARIO_NOMBRE+ " TEXT, "+TABLA_USUARIO_CONTRASENIA +" TEXT, " +TABLA_USUARIO_EMAIL+" TEXT, "+ TABLA_USUARIO_EDAD +" integer)";
    public static final String CREAR_TABLA_PRODUCTO="CREATE TABLE "+ TABLA_PRODUCTO+ " ("+TABLA_PRODUCTO_CODIGO+" TEXT, "+TABLA_PRODUCTO_DESCRIPCION+" TEXT, "+TABLA_PRODUCTO_CATEGORIA+" TEXT, "+ TABLA_PRODUCTO_CADENA + " TEXT, "+ TABLA_PRODUCTO_PRECIO+" REAL)";

    //insert tabla usuario
    //public static final String INSERT_TABLA_PRODUCTO="INSERT INTO producto VALUES ('PV001105','alitas de pollo sadia bolsa 1kg','POLLO','PLAZA VEA',11.6)";

}
