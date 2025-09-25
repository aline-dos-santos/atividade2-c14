package dados;

import org.example.dados.ContaBancaria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ContaBancariaTest {
    @Test
    public void depositarTest(){
        ContaBancaria conta = new ContaBancaria("77547", 600);
        conta.depositar(500);
        assertEquals(1100.0, conta.getSaldo(), 0.001);
    }

    @Test
    public void sacarTest(){
        ContaBancaria conta = new ContaBancaria("77547", 600);
        conta.sacar(400);
        assertEquals(200.0, conta.getSaldo(), 0.001);
    }

    @Test
    public void sacarexceptionTest(){
        double teste = 800;
        ContaBancaria conta = new ContaBancaria("77547", 600);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            conta.sacar(teste);
        });

        assertEquals("Seu saldo é insuficiente para esse saque.", exception.getMessage());
    }

    @Test
    public void naoDeveDepositarValorNegativo() {
        ContaBancaria conta = new ContaBancaria("123", 100.0);
        conta.depositar(-50.0);
        assertEquals(100.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void naoDeveDepositarZero() {
        ContaBancaria conta = new ContaBancaria("123", 100.0);
        conta.depositar(0.0);
        assertEquals(100.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void deveSacarSaldoTotal() {
        ContaBancaria conta = new ContaBancaria("123", 500.0);
        conta.sacar(500.0);
        assertEquals(0.0, conta.getSaldo(), 0.01);
    }
}
