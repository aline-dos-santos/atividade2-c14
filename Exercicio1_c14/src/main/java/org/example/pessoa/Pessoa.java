package org.example.pessoa;

import org.example.dados.ContaBancaria;
import org.example.dados.Endereco;

public class Pessoa {
    private String nome;
    private int idade;
    private ContaBancaria conta;
    private Endereco endereco;

    public Pessoa(String nome, int idade, ContaBancaria conta, Endereco endereco) {
        if (idade < 0) throw new IllegalArgumentException("Idade não pode ser negativa");
        this.nome = nome;
        this.idade = idade;
        this.conta = conta;
        this.endereco = endereco;
    }

    public void fazerAniversario() { idade++; }
    public boolean isMaiorDeIdade() { return idade >= 18; }

    // Getters
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public ContaBancaria getConta() { return conta; }
    public Endereco getEndereco() { return endereco; }
}
