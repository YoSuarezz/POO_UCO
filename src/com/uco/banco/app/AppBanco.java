package com.uco.banco.app;

import com.uco.banco.dominio.Banco;
import com.uco.banco.dominio.CuentaBancaria;

public class AppBanco {
    public static void main(String[] args) {
        Banco banco = new Banco("Bancolombia");

        CuentaBancaria miCuenta = new CuentaBancaria(123);
        CuentaBancaria miCuenta2 = new CuentaBancaria(345);

        System.out.println(miCuenta);
        System.out.println(miCuenta.getNumero());
        System.out.println(miCuenta2.getNumero());
    }
}
