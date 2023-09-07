package com.uco.taller.agenda.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
public class Agenda {
    public static List<Contacto> contactos;
    public Agenda() {
        this.contactos = new ArrayList<>();
    }
    public void crearContacto(String nombre, String apellido, long celular) {

        if (this.contactos.size() < 50 && this.buscarPorCelular(celular) == null) {
            Contacto contactoAAgregar = new Contacto(nombre, apellido, celular);
            this.contactos.add(contactoAAgregar);
        } else {
            System.out.println("El contacto no se pudo crear.");
        }
    }
    public boolean eliminarContacto(long celularAEliminar) {
        Contacto contactoExistente = this.buscarPorCelular(celularAEliminar);

        if (contactoExistente != null) {
            this.contactos.remove(contactoExistente);
            return true;
        }

        return false;
    }
    public List<Contacto> buscarPorNombre(String nombreABuscar) {
        return this.contactos.stream().filter(contact -> contact.getNombre().equalsIgnoreCase(nombreABuscar)).toList();
    }
    public List<Contacto> buscarPorApellido(String apellidoABuscar) {
        List<Contacto> contactosPorApellido = new ArrayList<>();

        for (Contacto contacto : this.contactos) {
            if (contacto.getApellido().equalsIgnoreCase(apellidoABuscar)) {
                contactosPorApellido.add(contacto);
            }
        }
        return contactosPorApellido;
    }
    public Contacto buscarPorCelular(long celularABuscar) {
        return this.contactos.stream().filter(contacto -> contacto.getCelular() == celularABuscar).findFirst().orElse(null);
    }
    public void cambiarCelular(long celularActual, long nuevoCelular) {
        Contacto contactoExistente = this.buscarPorCelular(celularActual);

        if (contactoExistente != null) {
            contactoExistente.celular = nuevoCelular;
            System.out.println("El número se cambio exitosamente");
        }
        else {
            System.out.println("El número a cambiar no fue encontrado");
        }
    }
    public List<Contacto> ordenarAlfabeticamente() {
        Collections.sort(contactos, Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER));
        return contactos;
    }

}

