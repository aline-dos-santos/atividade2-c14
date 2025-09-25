package org.example.pessoa;

public class PessoaService {

    public boolean sacar(Pessoa pessoa, double valor) {
        try {
            pessoa.getConta().sacar(valor);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public void depositar(Pessoa pessoa, double valor) {
        pessoa.getConta().depositar(valor);
    }
}
