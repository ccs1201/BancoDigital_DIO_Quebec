package br.com.ccs.domain.model.entity;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Integer numeroConta, Integer numeroAgencia, BigDecimal saldo, Cliente cliente) {
        super(numeroConta, numeroAgencia, saldo, cliente, TIPO_CONTA.POUPANCA);
    }
}
