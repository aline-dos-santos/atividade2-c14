import org.example.ContaBancaria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ContaBancariaTeste {
    @Test
    public void depositarTest(){
        ContaBancaria conta = new ContaBancaria("77547", 600);
        conta.depositar(500);
        assertEquals(1100.0, conta.getSaldo(), 0.001);
    }

    @Test
    public void sacarTest(){
        double teste = 400;
        ContaBancaria conta = new ContaBancaria("77547", 600);
        conta.sacar(teste);
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
}
