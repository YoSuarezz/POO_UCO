package com.uco.taller.maquinasnack.dominio;

public class Snack {
    private int codigo;
    private String nombre;
    private double valor;
    protected int cantidad;

    public Snack(int codigo, String nombre, double valor, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public double getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setValor(double precio) {
        this.valor = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}