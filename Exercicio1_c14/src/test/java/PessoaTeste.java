import org.example.ContaBancaria;
import org.example.Endereco;
import org.example.Pessoa;
import org.junit.Test;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

public class PessoaTeste {
    @Test
    public void testeConverterListaParaJson() {
        Gson gson = new Gson();
        List<Pessoa> pessoas = new ArrayList<>();
        ContaBancaria conta = new ContaBancaria("453434", 4534);
        Endereco endereco = new Endereco("alvarenga peixoto", "inconfidentes", "mg", "37576000");
        pessoas.add(new Pessoa("Maria", 30, conta, endereco));

        String json = gson.toJson(pessoas);

        // Verifica se contém os dados esperados
        assertTrue(json.contains("Maria"));
        assertTrue(json.contains("30"));
        assertTrue(json.contains("453434")); // número da conta
        assertTrue(json.contains("alvarenga peixoto")); // rua do endereço
    }

    @Test
    public void testeCriaPessoa(){
        ContaBancaria conta = new ContaBancaria("999999", 1000);
        Endereco endereco = new Endereco("Rua X", "Cidade Y", "Estado Z", "12345-678");

        Pessoa pessoa = new Pessoa("Maria", 30, conta, endereco);

        assertEquals("Maria", pessoa.getNome());
        assertEquals(30, pessoa.getIdade());
        assertEquals("999999", pessoa.getConta().getNumero());
        assertEquals("Rua X", pessoa.getEndereco().getRua());
    }

    // Teste de exceção
    @Test
    public void deveLancarExcecaoQuandoIdadeNegativa() {
        ContaBancaria conta = new ContaBancaria("888888", 500);
        Endereco endereco = new Endereco("Rua Teste", "Cidade Teste", "MG", "00000-000");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa("Carlos", -5, conta, endereco);
        });

        assertEquals("Idade não pode ser negativa", exception.getMessage());
    }
}
