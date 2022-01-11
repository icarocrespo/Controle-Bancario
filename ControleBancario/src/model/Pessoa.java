package model;

import java.io.Serializable;

/**
 *
 * @author icaro
 */
public abstract class Pessoa implements Serializable{
    
    protected String nome;
    protected String endereco;
    protected String CEP;
    protected String telefone;

    public Pessoa(String nome, String endereco, String CEP, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.CEP = CEP;
        this.telefone = telefone;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}
