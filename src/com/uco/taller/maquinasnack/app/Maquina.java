package com.uco.taller.maquinasnack.app;

import com.uco.taller.maquinasnack.dominio.MaquinaDispensadora;
import com.uco.taller.maquinasnack.dominio.Snack;

import java.util.List;
import java.util.Scanner;

public class Maquina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaquinaDispensadora maquina = new MaquinaDispensadora(12, 6);

        while (true) {
            System.out.println("     Máquina Dispensadora    ");
            System.out.println("1. Agregar Snack");
            System.out.println("2. Sacar Unidad");
            System.out.println("3. Aumentar Unidades");
            System.out.println("4. Quitar Snack");
            System.out.println("5. Consultar Cantidad de Unidades");
            System.out.println("6. Snacks Agotados");
            System.out.println("7. Snacks por Valor (Descendente)");
            System.out.println("8. Snacks por Cantidad (Ascendente)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del snack: ");
                    String nombre = scanner.next();
                    scanner.nextLine();
                    System.out.print("Ingrese el codigo del snack: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Ingrese la cantidad de unidades: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el valor del snack: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    Snack snack = new Snack(codigo, nombre, valor, cantidad);
                    if (maquina.agregarSnack(snack)) {
                        System.out.println("Snack agregado con éxito.");
                    } else {
                        System.out.println("No se pudo agregar el snack. La máquina está llena.");
                    }
                    break;

                case 2:
                    System.out.println("Si desea sacar unidades por codigo escriba 1, si desea sacar por nombre escriba 2" );
                    int respuestaSacar = scanner.nextInt();
                    if (respuestaSacar==1){
                        System.out.print("Ingrese el código del snack a sacar unidad: ");
                        int codigoSacar = scanner.nextInt();
                        scanner.nextLine();
                        if (maquina.sacarUnidadPorCodigo(codigoSacar)) {
                            System.out.println("Se sacó una unidad del snack con código " + codigoSacar);
                        } else {
                            System.out.println("No se pudo sacar una unidad. El snack no existe o está agotado.");
                        }
                        break;
                    }
                    else {
                        System.out.print("Ingrese el nombre del snack a sacar unidad: ");
                        String nombreSacar = scanner.next();
                        scanner.nextLine();
                        if (maquina.sacarUnidadPorNombre(nombreSacar)) {
                            System.out.println("Se sacó una unidad del snack con código " + nombreSacar);
                        } else {
                            System.out.println("No se pudo sacar una unidad. El snack no existe o está agotado.");
                        }
                        break;
                    }

                case 3:
                    System.out.println("Si desea aumentar unidades por codigo escriba 1, si desea aumentar por nombre escriba 2" );
                    int respuestaAumentar = scanner.nextInt();
                    if (respuestaAumentar==1){
                        System.out.print("Ingrese el código del snack para aumentar unidades: ");
                        int codigoAumentar = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese la cantidad de unidades a aumentar: ");
                        int cantidadAumentar = scanner.nextInt();
                        scanner.nextLine();
                        if (maquina.aumentarUnidadesPorCodigo(codigoAumentar, cantidadAumentar)) {
                            System.out.println("Se aumentaron " + cantidadAumentar + " unidades al snack con código " + codigoAumentar);
                        } else {
                            System.out.println("No se pudo aumentar unidades. El snack no existe.");
                        }
                        break;
                    }
                    else {
                        System.out.print("Ingrese el nombre del snack para aumentar unidades: ");
                        String nombreAumentar = scanner.next();
                        scanner.nextLine();
                        System.out.print("Ingrese la cantidad de unidades a aumentar: ");
                        int cantidadAumentar = scanner.nextInt();
                        scanner.nextLine();
                        if (maquina.aumentarUnidadesPorNombre(nombreAumentar, cantidadAumentar)) {
                            System.out.println("Se aumentaron " + cantidadAumentar + " unidades al snack con nombre " + nombreAumentar);
                        } else {
                            System.out.println("No se pudo aumentar unidades. El snack no existe.");
                        }
                        break;
                    }

                case 4:
                    System.out.print("Ingrese el código del snack a quitar: ");
                    int codigoQuitar = scanner.nextInt();
                    scanner.nextLine();
                    if (maquina.quitarSnack(codigoQuitar)) {
                        System.out.println("Se quitó el snack con código " + codigoQuitar);
                    } else {
                        System.out.println("No se pudo quitar el snack. El snack no existe.");
                    }
                    break;

                case 5:
                    System.out.println("Si desea consultar unidades por codigo escriba 1, si desea consultar por nombre escriba 2" );
                    int respuestaConsultar = scanner.nextInt();
                    if (respuestaConsultar==1){
                        System.out.print("Ingrese el código del snack para consultar cantidad de unidades: ");
                        int codigoConsultar = scanner.nextInt();
                        scanner.nextLine();
                        int cantidadUnidades = maquina.obtenerCantidadUnidades(codigoConsultar);
                        System.out.println("Cantidad de unidades del snack con código " + codigoConsultar + ": " + cantidadUnidades);
                        break;
                    }
                    else {
                        System.out.print("Ingrese el nombre del snack para consultar cantidad de unidades: ");
                        String nombreConsultar = scanner.next();
                        scanner.nextLine();
                        int cantidadUnidades = maquina.obtenerCantidadUnidadesPorNombre(nombreConsultar);
                        System.out.println("Cantidad de unidades del snack con código " + nombreConsultar + ": " + cantidadUnidades);
                        break;
                    }

                case 6:
                    List<Snack> agotados = maquina.obtenerSnacksAgotados();
                    System.out.println("Snacks agotados:");
                    for (Snack snack1 : agotados) {
                        System.out.println("Código: " + snack1.getCodigo() + ", Nombre: " + snack1.getNombre());
                    }
                    break;

                case 7:
                    List<Snack> snacksPorValorDesc = maquina.obtenerSnacksPorValorDesc();
                    System.out.println("Snacks por valor (descendente):");
                    for (Snack snack2 : snacksPorValorDesc) {
                        System.out.println("Nombre: " + snack2.getNombre() + ", Valor: " + snack2.getValor());
                    }
                    break;

                case 8:
                    List<Snack> snacksPorCantidadAsc = maquina.obtenerSnacksPorCantidadAsc();
                    System.out.println("Snacks por cantidad (ascendente):");
                    for (Snack snack3 : snacksPorCantidadAsc) {
                        System.out.println("Nombre: " + snack3.getNombre() + ", Cantidad: " + snack3.getCantidad());
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



