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

                Pessoa p = new Pessoa(nome, idade);


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
