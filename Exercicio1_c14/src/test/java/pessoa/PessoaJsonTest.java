package pessoa;

import org.example.dados.ContaBancaria;
import org.example.dados.Endereco;
import org.example.pessoa.Pessoa;
import org.example.pessoa.PessoaJson;
import org.junit.Test;

import static org.junit.Assert.*;

public class PessoaJsonTest {

    @Test
    public void deveConverterPessoaParaJson() {
        ContaBancaria conta = new ContaBancaria("123", 1500.50);
        Endereco endereco = new Endereco("Rua A", "Cidade B", "SP", "12345-678");
        Pessoa pessoa = new Pessoa("Ana", 30, conta, endereco);

        String json = PessoaJson.toJson(pessoa);

        assertTrue(json.contains("\"nome\":\"Ana\""));
        assertTrue(json.contains("\"idade\":30"));
        assertTrue(json.contains("\"numero\":\"123\""));
        assertTrue(json.contains("\"rua\":\"Rua A\""));
    }

    @Test
    public void deveConverterJsonParaPessoa() {
        String json = "{"
                + "\"nome\":\"Carlos\","
                + "\"idade\":40,"
                + "\"conta\":{\"numero\":\"999\",\"saldo\":2500.0},"
                + "\"endereco\":{\"rua\":\"Rua X\",\"cidade\":\"Cidade Y\",\"estado\":\"MG\",\"cep\":\"30000-000\"}"
                + "}";

        Pessoa pessoa = PessoaJson.fromJson(json);

        assertEquals("Carlos", pessoa.getNome());
        assertEquals(40, pessoa.getIdade());
        assertEquals("999", pessoa.getConta().getNumero());
        assertEquals(2500.0, pessoa.getConta().getSaldo(), 0.01);
        assertEquals("Rua X", pessoa.getEndereco().getRua());
        assertEquals("MG", pessoa.getEndereco().getEstado());
    }
}