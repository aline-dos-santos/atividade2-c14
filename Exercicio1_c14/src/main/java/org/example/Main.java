package org.example;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Scanner sc = new Scanner(System.in);

        List<Pessoa> teste = new ArrayList<>();
        try {
            System.out.print("Quantas pessoas deseja cadastrar? ");
            int qtd = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            for (int i = 0; i < qtd; i++) {
                System.out.println("\nCadastro da pessoa " + (i + 1));
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Idade: ");
                int idade = sc.nextInt();
                sc.nextLine(); // consumir quebra de linha

                System.out.print("Numero da Conta bancaria: ");
                String numero = sc.next();
                sc.nextLine(); // consumir quebra de linha

                System.out.print("Saldo da Conta bancaria: ");
                Double saldo = sc.nextDouble();
                sc.nextLine(); // consumir quebra de linha

                ContaBancaria conta = new ContaBancaria(numero, saldo);

                System.out.print("Insira o nome da rua do endereço: ");
                String rua = sc.next();
                sc.nextLine(); // consumir quebra de linha

                System.out.print("Insira a cidade: ");
                String cidade = sc.next();
                sc.nextLine(); // consumir quebra de linha

                System.out.print("Insira o Estado: ");
                String estado = sc.next();
                sc.nextLine(); // consumir quebra de linha

                System.out.print("Insira a cep: ");
                String cep = sc.next();
                sc.nextLine(); // consumir quebra de linha

                Endereco endereco = new Endereco(rua, cidade, estado, cep);

                Pessoa p = new Pessoa(nome, idade, conta, endereco);


                teste.add(p);
            }

            // Converte a lista inteira para JSON
            String json = gson.toJson(teste);

            System.out.println("\nLista em JSON:");
            System.out.println(json);

            sc.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}