package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author icaro
 */
public class Cliente implements Serializable{
    
    private Pessoa pessoa;
    private Double renda;
    private Boolean situacao;
    private List<ContaBancaria> contasBancarias;

    public Cliente(Pessoa pessoa, Double renda, Boolean situacao, List<ContaBancaria> contasBancarias) {
        this.pessoa = pessoa;
        this.renda = renda;
        this.situacao = situacao;
        this.contasBancarias = contasBancarias;
    }

    public Cliente() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public List<ContaBancaria> getContasBancarias() {
        return contasBancarias;
    }

    public void setContasBancarias(List<ContaBancaria> contasBancarias) {
        this.contasBancarias = contasBancarias;
    }
    
    
    
}
