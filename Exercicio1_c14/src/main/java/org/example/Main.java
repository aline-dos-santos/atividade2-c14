package org.example;

import org.example.dados.ContaBancaria;
import org.example.dados.Endereco;
import org.example.pessoa.Pessoa;
import org.example.pessoa.PessoaJson;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Quantas pessoas deseja cadastrar? ");
        int qtd = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtd; i++) {
            System.out.println("\nCadastro da pessoa " + (i + 1));
            Pessoa pessoa = lerPessoa(sc); // chamada da função local
            pessoas.add(pessoa);
        }

        System.out.println("\nLista em JSON:");
        pessoas.forEach(p -> System.out.println(PessoaJson.toJson(p)));

        sc.close();
    }

    private static Pessoa lerPessoa(Scanner sc) {
        try {
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Idade: ");
            int idade = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            System.out.print("Número da conta: ");
            String numero = sc.nextLine();

            System.out.print("Saldo: ");
            double saldo = sc.nextDouble();
            sc.nextLine();

            System.out.print("Rua: ");
            String rua = sc.nextLine();

            System.out.print("Cidade: ");
            String cidade = sc.nextLine();

            System.out.print("Estado: ");
            String estado = sc.nextLine();

            System.out.print("CEP: ");
            String cep = sc.nextLine();

            ContaBancaria conta = new ContaBancaria(numero, saldo);
            Endereco endereco = new Endereco(rua, cidade, estado, cep);

            return new Pessoa(nome, idade, conta, endereco);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida!");
            sc.nextLine();
            return lerPessoa(sc); // recursão para tentar novamente
        }
    }
}
