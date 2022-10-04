package br.com.ccs.domain.model.entity;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
    public ContaCorrente(Integer numeroConta, Integer numeroAgencia, BigDecimal saldo, Cliente cliente) {
        super(numeroConta, numeroAgencia, saldo, cliente, TIPO_CONTA.CORRENTE);
    }
}
