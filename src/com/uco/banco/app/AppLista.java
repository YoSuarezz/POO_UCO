package com.uco.banco.app;

import com.uco.banco.dominio.Banco;
import com.uco.banco.dominio.Persona;

import java.util.Arrays;

public class AppLista {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco de Occidente");
        Persona alejandro = new Persona("Alejandro", "123");
        Persona camila = new Persona("Camila", "836");
        Persona andres = new Persona("Andrés", "321");
        Persona vanessa = new Persona("Vanessa", "666");
        Persona jairo = new Persona("Jairo", "555");
        Persona valeria = new Persona("Valeria", "890");

        banco.getClientes().addAll(Arrays.asList(alejandro, valeria));

        System.out.println("Tamaño de la lista: " + banco.getClientes().size());
        banco.agregarCliente(camila);
        banco.agregarCliente(andres);
        banco.agregarCliente(vanessa);
        banco.agregarCliente(jairo);
        System.out.println("Tamaño de la lista: " + banco.getClientes().size());

        banco.getClientes().remove(4);

        banco.getClientes().forEach(p -> {
            System.out.println(p.getIdentificacion() + "-> " + p.getNombre());
        });

        Persona personaBuscada = banco.obtenerClienteFuncional("123");
        System.out.println(personaBuscada.getNombre());

//        for (Persona p : banco.getClientes()) {
//            System.out.println(p.getIdentificacion() + "-> " + p.getNombre());
//        }

//        for (int i = 0; i < banco.getClientes().size(); i++) {
//            Persona p = banco.getClientes().get(i);
//            System.out.println(p.getIdentificacion() + "- " + p.getNombre());
//        }

    }
}
