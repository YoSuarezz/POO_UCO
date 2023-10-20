package com.uco.desafio2.app;
import com.uco.desafio2.dominio.*;

public class AppNomina {
    public static void main(String[] args) {

        Nomina nomina = new Nomina();


        Directo juan = new Directo("Juan", 4840000);
        Vendedor julian = new Vendedor("Julián", 2500000, 45510000);
        Freelance johanna = new Freelance("Johanna", 71000, 89);
        Vendedor claudia = new Vendedor("Claudia", 1380000, 35989000);
        Directo david = new Directo("David", 3975000);
        Freelance gustavo = new Freelance("Gustavo", 42500, 65);


        nomina.agregarEmpleado(juan);
        nomina.agregarEmpleado(julian);
        nomina.agregarEmpleado(johanna);
        nomina.agregarEmpleado(claudia);
        nomina.agregarEmpleado(david);
        nomina.agregarEmpleado(gustavo);


        System.out.println("Salarios de los empleados:");
        nomina.calcularNomina();

        System.out.println("\nLista de empleados directos:");
        nomina.listarDirectos();

        System.out.println("\nLista de freelancers:");
        nomina.listarFreelancers();

        System.out.println("\nComisiones de los vendedores:");
        nomina.listarComisiones();
    }
}
