package org.example;

public class ContaBancaria {
    private String numero;
    private double saldo;

    public ContaBancaria(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() { return numero; }
    public double getSaldo() { return saldo; }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
        } else {
            throw new RuntimeException("Seu saldo é insuficiente para esse saque. Por favor, tente novamente.");
        }
    }
}
