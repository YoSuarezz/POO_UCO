package com.uco.taller.agenda.dominio;

public class Contacto {
    private String nombre;
    private String apellido;
    protected long celular;

    public Contacto(String nombre, String apellido, long celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getCelular() {
        return celular;
    }
}
