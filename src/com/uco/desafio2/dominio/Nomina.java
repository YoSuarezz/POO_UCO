package com.uco.desafio2.dominio;

import java.util.ArrayList;

public class Nomina {
    protected ArrayList<Empleado> empleados;

    public Nomina() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void listarDirectos() {
        for (Empleado empleado : empleados) {
            if (empleado instanceof Directo) {
                System.out.println(empleado.nombre);
            }
        }
    }

    public void listarFreelancers() {
        for (Empleado empleado : empleados) {
            if (empleado instanceof Freelance) {
                System.out.println(empleado.nombre);
            }
        }
    }

    public void calcularNomina() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.nombre + ": $" + empleado.calcularSalario());
        }
    }
}
