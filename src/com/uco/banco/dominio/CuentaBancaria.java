package com.uco.banco.dominio;

public class CuentaBancaria {
    private int numero;
    private long saldo;
    private boolean activa;
    private Banco banco;
    private Persona propietario;

    public CuentaBancaria(int numero) {
        this.numero = numero;
        this.activa = true;
    }

    public CuentaBancaria(int numero, long saldo, Persona propietario) {
        this(numero);
        this.saldo = saldo;
        this.propietario = propietario;
    }

    public boolean consignar(long valorAConsignar) {
        if (this.activa) {
            this.saldo += valorAConsignar;
            return true;
        }

        System.out.println("No se puede consignar a " + this.numero + ". La cuenta no está activa.");
        return false;
    }

    public boolean retirar(long valorARetirar) {
        if (this.activa && this.saldo >= valorARetirar) {
            this.saldo -= valorARetirar;
            return true;
        }

        System.out.println("No se puede retirar de " + this.numero + ".");
        return false;
    }

    public boolean transferir(long valorATransferir, CuentaBancaria cuentaDestino) {
        boolean retiroCorrecto = this.retirar(valorATransferir);

        if (retiroCorrecto) {
            boolean consignoCorrecto = cuentaDestino.consignar(valorATransferir);

            if (consignoCorrecto) {
                return true;
            }

            this.saldo += valorATransferir;
            return false;
        }

        return false;
    }

    public String consultarSaldo() {
        String mensajeSaldo = "Tu saldo es " + saldo;
        return mensajeSaldo;
    }

    public int getNumero() {
        return numero;
    }

    public long getSaldo() {
        return saldo;
    }

    public boolean isActiva() {
        return activa;
    }

    public Banco getBanco() {
        return banco;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
