package br.com.ccs.domain.model.entity;

import br.com.ccs.domain.exception.SaldoInsuficienteException;

import java.math.BigDecimal;

public abstract class Conta {

    private Integer numeroConta;
    private Integer numeroAgencia;
    private BigDecimal saldo;
    private Cliente cliente;
    private TIPO_CONTA tipo_conta;

    public Conta(Integer numeroConta, Integer numeroAgencia, BigDecimal saldo, Cliente cliente, TIPO_CONTA tipo_conta) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldo = saldo;
        this.cliente = cliente;
        this.tipo_conta = tipo_conta;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public Integer getNumeroAgencia() {
        return numeroAgencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TIPO_CONTA getTipo_conta() {
        return tipo_conta;
    }

    protected void setTipo_conta(TIPO_CONTA tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public void sacar(BigDecimal valorSaque) {

        if (saldo.compareTo(valorSaque) < 0) {
            throw new SaldoInsuficienteException(saldo, valorSaque);
        } else {
            saldo = saldo.subtract(valorSaque);
        }
    }

    public void depositar(BigDecimal valorDeposito) {

        saldo = saldo.add(valorDeposito);
    }

    public void transferir(Conta contaDestino, BigDecimal valorTransferencia) {

            sacar(valorTransferencia);
            contaDestino.depositar(valorTransferencia);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta=" + numeroConta +
                ", numeroAgencia=" + numeroAgencia +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                ", tipo_conta=" + tipo_conta +
                '}';
    }
}
