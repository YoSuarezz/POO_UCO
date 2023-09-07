package com.uco.banco.dominio;

public class Credito {
    private long monto;
    private int plazo;

    public Credito(long monto, int plazo) {
        this.monto = monto;
        this.plazo = plazo;
    }

    public long getMonto() {
        return monto;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
}
