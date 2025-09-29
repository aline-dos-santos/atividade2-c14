package pessoa;

import org.example.dados.ContaBancaria;
import org.example.dados.Endereco;
import org.example.pessoa.Pessoa;
import org.example.pessoa.PessoaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceMockTest {

    @Mock
    private ContaBancaria contaMock;

    private PessoaService pessoaService;
    private Endereco endereco;
    private Pessoa pessoa;

    @Before
    public void setup() {
        this.pessoaService = new PessoaService();
        this.endereco = new Endereco("Rua Teste", "Cidade Teste", "TT", "00000-000");
        this.pessoa = new Pessoa("Ana", 30, contaMock, endereco);
    }

    @Test
    public void deveSacarComSucessoQuandoContaPermite() {
        Mockito.doNothing().when(contaMock).sacar(100.0);

        boolean sucesso = pessoaService.sacar(pessoa, 100.0);

        assertTrue(sucesso);
        Mockito.verify(contaMock).sacar(100.0);
    }

    @Test
    public void deveFalharAoSacarQuandoContaLancaExcecao() {
        Mockito.doThrow(new RuntimeException("Saldo insuficiente"))
                .when(contaMock).sacar(200.0);

        boolean sucesso = pessoaService.sacar(pessoa, 200.0);

        assertFalse(sucesso);
        Mockito.verify(contaMock).sacar(200.0);
    }

    @Test
    public void deveDepositarComSucessoAoChamarServico() {
        Mockito.doNothing().when(contaMock).depositar(150.0);

        pessoaService.depositar(pessoa, 150.0);

        Mockito.verify(contaMock).depositar(150.0);
    }

}