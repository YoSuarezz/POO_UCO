package com.uco.banco.dominio;

import java.util.List;

public class Persona {
    private String nombre;
    private String identificacion;
    private List<Credito> creditos;
    private List<CuentaBancaria> cuentas;

    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public List<Credito> getCreditos() {
        return creditos;
    }

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(List<Credito> creditos) {
        this.creditos = creditos;
    }

    public void setCuentas(List<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }
}
