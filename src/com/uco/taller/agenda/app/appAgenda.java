package com.uco.taller.agenda.app;

import com.uco.taller.agenda.dominio.Agenda;
import com.uco.taller.agenda.dominio.Contacto;

import java.util.List;
import java.util.Scanner;

public class appAgenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("      Agenda de Contactos      ");
            System.out.println("1. Crear Contacto");
            System.out.println("2. Eliminar Contacto");
            System.out.println("3. Buscar Contacto por Nombre");
            System.out.println("4. Buscar Contacto por Apellido");
            System.out.println("5. Buscar Contacto por Celular");
            System.out.println("6. Cambiar Número de Celular");
            System.out.println("7. Mostrar Contactos Ordenados Alfabéticamente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese el número de celular del contacto: ");
                    long celular = scanner.nextLong();
                    scanner.nextLine();

                    agenda.crearContacto(nombre, apellido, celular);
                    break;
                case 2:
                    System.out.print("Ingrese el número de celular del contacto a eliminar: ");
                    long celularAEliminar = scanner.nextLong();
                    scanner.nextLine();

                    if (agenda.eliminarContacto(celularAEliminar)) {
                        System.out.println("Contacto eliminado con éxito.");
                    } else {
                        System.out.println("No se encontró un contacto con ese número de celular.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    String nombreABuscar = scanner.nextLine();
                    List<Contacto> contactosPorNombre = agenda.buscarPorNombre(nombreABuscar);

                    if (!contactosPorNombre.isEmpty()) {
                        System.out.println("Contactos encontrados:");
                        for (Contacto contacto : contactosPorNombre) {
                            System.out.println("Nombre: " + contacto.getNombre() + " " + contacto.getApellido() + ", Celular: " + contacto.getCelular());
                        }
                    } else {
                        System.out.println("No se encontraron contactos con ese nombre.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el apellido del contacto a buscar: ");
                    String apellidoABuscar = scanner.nextLine();
                    List<Contacto> contactosPorApellido = agenda.buscarPorApellido(apellidoABuscar);

                    if (!contactosPorApellido.isEmpty()) {
                        System.out.println("Contactos encontrados:");
                        for (Contacto contacto : contactosPorApellido) {
                            System.out.println("Nombre: " + contacto.getNombre() + " " + contacto.getApellido() + ", Celular: " + contacto.getCelular());
                        }
                    } else {
                        System.out.println("No se encontraron contactos con ese apellido.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el número de celular del contacto a buscar: ");
                    long celularABuscar = scanner.nextLong();
                    scanner.nextLine();

                    Contacto contactoPorCelular = agenda.buscarPorCelular(celularABuscar);

                    if (contactoPorCelular != null) {
                        System.out.println("Contacto encontrado:");
                        System.out.println("Nombre: " + contactoPorCelular.getNombre() + " " + contactoPorCelular.getApellido() + ", Celular: " + contactoPorCelular.getCelular());
                    } else {
                        System.out.println("No se encontró un contacto con ese número de celular.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el número de celular del contacto cuyo número desea cambiar: ");
                    long celularActual = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Ingrese el nuevo número de celular: ");
                    long nuevoCelular = scanner.nextLong();
                    scanner.nextLine();

                    agenda.cambiarCelular(celularActual, nuevoCelular);
                    break;
                case 7:
                    List<Contacto> contactosOrdenados = agenda.ordenarAlfabeticamente();
                    System.out.println("Contactos ordenados alfabéticamente:");
                    for (Contacto contacto : contactosOrdenados) {
                        System.out.println("Nombre: " + contacto.getNombre() + " " + contacto.getApellido() + ", Celular: " + contacto.getCelular());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
