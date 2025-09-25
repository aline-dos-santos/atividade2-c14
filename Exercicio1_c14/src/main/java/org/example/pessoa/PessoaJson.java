package org.example.pessoa;

import com.google.gson.Gson;

public class PessoaJson {
    private static Gson gson = new Gson();

    public static String toJson(Pessoa pessoa) { return gson.toJson(pessoa); }
    public static Pessoa fromJson(String json) { return gson.fromJson(json, Pessoa.class); }
}
