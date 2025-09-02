import org.example.Endereco;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnderecoTeste {

    @Test
    public void deveCriarEnderecoCorretamente() {
        Endereco endereco = new Endereco("Rua A", "Cidade B", "Estado C", "12345-678");

        assertEquals("Rua A", endereco.getRua());
        assertEquals("Cidade B", endereco.getCidade());
        assertEquals("Estado C", endereco.getEstado());
        assertEquals("12345-678", endereco.getCep());
    }

    @Test
    public void deveRetornarEnderecoCompleto() {
        Endereco endereco = new Endereco("Rua das Flores", "Inconfidentes", "MG", "37576-000");

        String esperado = "Rua das Flores, Inconfidentes - MG, CEP: 37576-000";
        assertEquals(esperado, endereco.enderecoCompleto());
    }

    @Test
    public void deveAceitarCamposVazios() {
        Endereco endereco = new Endereco("", "", "", "");

        assertEquals("", endereco.getRua());
        assertEquals("", endereco.getCidade());
        assertEquals("", endereco.getEstado());
        assertEquals("", endereco.getCep());

        String esperado = ",  - , CEP: ";
        assertEquals(esperado, endereco.enderecoCompleto());
    }
}
