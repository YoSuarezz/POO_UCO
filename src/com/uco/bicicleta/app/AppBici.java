package com.uco.bicicleta.app;

import com.uco.bicicleta.dominio.Bicicleta;

public class AppBici {
    public static void main(String[] args) {
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.acelerar(65);
        bicicleta.frenar(30);
        bicicleta.frenar(36);

        System.out.println(bicicleta.verVelocidadActual());
    }
}
