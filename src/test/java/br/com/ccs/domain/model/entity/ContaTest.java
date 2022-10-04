package br.com.ccs.domain.model.entity;

import br.com.ccs.domain.exception.SaldoInsuficienteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaTest {

    private Conta contaCorrente1;
    private Conta contaCorrente2;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente("TESTE", "123456789");
        contaCorrente1 = new ContaCorrente(1, 1, BigDecimal.valueOf(1000.10), cliente);
        contaCorrente2 = new ContaCorrente(2, 1, BigDecimal.valueOf(1000.20), cliente);
    }

    @Test
    @DisplayName("Sacando de conta corrente com saldo suficiente")
    void sacar() {

        contaCorrente1.sacar(BigDecimal.valueOf(0.10));

        assertEquals(1000.00D, contaCorrente1.getSaldo().doubleValue());
    }

    @Test
    @DisplayName("Sacando saldo total da conta")
    void sacarSaldoTotal() {
        contaCorrente1.sacar(contaCorrente1.getSaldo());

        assertEquals(0.0, contaCorrente1.getSaldo().doubleValue());
    }

    @Test
    @DisplayName("Sacar com saldo Insuficiente deve lançar SaldoInsuficienteException")
    void sacarComSaldoInsuficiente() {

        assertThrows(SaldoInsuficienteException.class, () ->
                contaCorrente1.sacar(BigDecimal.valueOf(10000)));
    }

    @Test
    @DisplayName("Depositando 10.00 na conta, deve passar se o saldo após o deposito for igual a saldo anterior + valorDeposito ")
    void depositar() {
        BigDecimal valorDeposito = BigDecimal.valueOf(10.0);
        BigDecimal saldo = contaCorrente1.getSaldo().add(valorDeposito);

        contaCorrente1.depositar(valorDeposito);

        assertEquals(saldo.doubleValue(), contaCorrente1.getSaldo().doubleValue());
    }

    @Test
    @DisplayName("Transferencia entre contas com saldo suficiente")
    void transferirEntreContasComSaldoSuficiente() {

        var valorTtransferencia = BigDecimal.valueOf(100.0);

        var saldo = contaCorrente2.getSaldo().add(valorTtransferencia);

        contaCorrente1.transferir(contaCorrente2, valorTtransferencia);

        assertEquals(saldo.doubleValue(), contaCorrente2.getSaldo().doubleValue());
    }

    @Test
    @DisplayName("Transferencia entre contas com saldo Insuficiente deve lançar SaldoInsuficienteException")
    void transferirEntreContasComSaldoInsuficiente() {

        var valorTtransferencia = BigDecimal.valueOf(10000.0);

        assertThrows(SaldoInsuficienteException.class, () ->
                contaCorrente1.transferir(contaCorrente2, valorTtransferencia));
    }
}