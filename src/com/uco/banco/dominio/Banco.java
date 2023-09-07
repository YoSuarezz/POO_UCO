package com.uco.banco.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Banco {
    private String nombre;
    private List<Persona> clientes;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Persona persona) {
        this.clientes.add(persona);
    }

    public Persona obtenerClienteFuncional(String identificacion) {
        return this.clientes.stream()
                .filter(cli -> cli.getIdentificacion().equals(identificacion))
                .findFirst()
                .orElse(null);
    }

    public Persona obtenerCliente(String identificacion) {
        Persona personaBuscada = null;

        for (Persona cli : this.clientes) {
            if (cli.getIdentificacion().equals(identificacion)) {
                personaBuscada = cli;
                break;
            }
        }

        return personaBuscada;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Persona> getClientes() {
        return clientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
