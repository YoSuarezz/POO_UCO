package com.uco.desafio2.dominio;

public abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public abstract long calcularSalario();


    public long calcularComision() {
        return 0;
    }
}
