package com.uco.desafio2.dominio;

public class Vendedor extends Directo {
    protected long ventasDelMes;

    public Vendedor(String nombre, long salario, long ventasDelMes) {
        super(nombre, salario);
        this.ventasDelMes = ventasDelMes;
    }

    @Override
    public long calcularComision() {
        if (salario <= 1500000) {
            return (long) (ventasDelMes * 0.045);
        } else {
            return (long) (ventasDelMes * 0.035);
        }
    }

    @Override
    public long calcularSalario() {
        return super.calcularSalario() + calcularComision();
    }
}
