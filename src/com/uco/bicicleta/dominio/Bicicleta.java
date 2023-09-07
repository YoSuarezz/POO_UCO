package com.uco.bicicleta.dominio;

public class Bicicleta {
    public String marca;
    public String color;
    public int modelo;
    public double velocidad;
    public int cambioActual;

    public void acelerar(double valorAceleracion) {
        this.velocidad += valorAceleracion;
    }

    public void frenar(double valorFrenado) {
        if (this.velocidad - valorFrenado > 0) {
            this.velocidad -= valorFrenado;
        } else {
            System.out.println("La velocidad despues de la frenada, debe ser superior a 0 km/h.");
        }
    }

    public String verVelocidadActual() {
        return "La bici va a " + this.velocidad + "km/h.";
    }

    public void cambiarPinon(int nuevoPinon) {
        this.cambioActual = nuevoPinon;
    }
}
