package model;

import java.util.Date;

/**
 *
 * @author icaro
 */
public class ContaBancaria {
    
    private Integer numero;
    private Date dataAbertura;
    private Date dataEncerramento;
    private boolean situacao;
    private String senha;
    private Double saldo;
    private Cliente cliente;
    private TipoConta TIPOCONTA;
    
    public ContaBancaria(Integer numero, Date dataAbertura, Date dataEncerramento, boolean situacao, String senha, Double saldo, Cliente cliente, TipoConta tipoConta) {
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
        this.situacao = situacao;
        this.senha = senha;
        this.saldo = saldo;
        this.cliente = cliente;
        this.TIPOCONTA = tipoConta;
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

    public TipoConta getTIPOCONTA() {
        return TIPOCONTA;
    }

    public void setTIPOCONTA(TipoConta TIPOCONTA) {
        this.TIPOCONTA = TIPOCONTA;
    }
    
    
}
