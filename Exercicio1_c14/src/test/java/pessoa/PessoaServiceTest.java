package pessoa;

import org.example.dados.ContaBancaria;
import org.example.dados.Endereco;
import org.example.pessoa.Pessoa;
import org.example.pessoa.PessoaService;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaServiceTest {
    @Test
    public void deveSacarComSucesso() {
        ContaBancaria conta = new ContaBancaria("123", 1000.0);
        Endereco endereco = new Endereco("Rua", "Cidade", "UF", "00000-000");
        Pessoa pessoa = new Pessoa("João", 30, conta, endereco);
        PessoaService service = new PessoaService();

        boolean sucesso = service.sacar(pessoa, 300.0);

        assertTrue(sucesso);
        assertEquals(700.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void deveFalharAoSacarSaldoInsuficiente() {
        ContaBancaria conta = new ContaBancaria("123", 200.0);
        Endereco endereco = new Endereco("Rua", "Cidade", "UF", "00000-000");
        Pessoa pessoa = new Pessoa("Maria", 25, conta, endereco);
        PessoaService service = new PessoaService();

        boolean sucesso = service.sacar(pessoa, 300.0);

        assertFalse(sucesso);
        assertEquals(200.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void deveDepositarComSucesso() {
        ContaBancaria conta = new ContaBancaria("123", 500.0);
        Endereco endereco = new Endereco("Rua", "Cidade", "UF", "00000-000");
        Pessoa pessoa = new Pessoa("Carlos", 40, conta, endereco);
        PessoaService service = new PessoaService();

        service.depositar(pessoa, 250.0);

        assertEquals(750.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void naoDeveDepositarValorNegativoViaService() {
        ContaBancaria conta = new ContaBancaria("123", 500.0);
        Endereco endereco = new Endereco("Rua", "Cidade", "UF", "00000-000");
        Pessoa pessoa = new Pessoa("Carlos", 40, conta, endereco);
        PessoaService service = new PessoaService();

        service.depositar(pessoa, -100.0);

        assertEquals(500.0, conta.getSaldo(), 0.01); // saldo inalterado
    }
}
