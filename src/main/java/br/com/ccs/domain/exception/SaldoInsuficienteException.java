package br.com.ccs.domain.exception;

import java.math.BigDecimal;

public class SaldoInsuficienteException extends IllegalArgumentException {
    public SaldoInsuficienteException(BigDecimal saldo, BigDecimal valorSolicitado) {
        super(String.format("Saldo insuficiente. Saldo: %s Valor Solicitado: %s", saldo, valorSolicitado));
    }
}
