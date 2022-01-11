package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author icaro
 */
public abstract class ContaBancaria implements Serializable {
    
    public static Integer CONTROLE_NUMERO = 2022;
    protected Integer numero;
    protected Date dataAbertura;
    protected Date dataEncerramento;
    protected boolean situacao;
    protected String senha;
    protected Double saldo;
    protected Cliente cliente;
    
    public ContaBancaria(Integer numero, Date dataAbertura, Date dataEncerramento, boolean situacao, String senha, Double saldo, Cliente cliente) {
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
        this.situacao = situacao;
        this.senha = senha;
        this.saldo = saldo;
        this.cliente = cliente;

    }

    public ContaBancaria() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    } 
    
    public abstract boolean abrirConta();
    
    public abstract boolean encerrarConta();
    
    public abstract boolean validarSenha(String senha);
    
    public abstract Double verificarSaldo();
    
    public abstract boolean sacarValor(Double valor);
    
    public abstract boolean depositarValor(Double valor);
    
    protected Integer fornecerNumero(){
        ContaBancaria.CONTROLE_NUMERO++;
        return ContaBancaria.CONTROLE_NUMERO;
    }
}
