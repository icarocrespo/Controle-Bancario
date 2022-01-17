package model;

public class PessoaJuridica extends Pessoa {
    
    private String cnpj;

    public PessoaJuridica(String nome, String endereco, String CEP, String telefone, String cnpj) {
        super(nome, endereco, CEP, telefone);
        this.cnpj = cnpj;
    }

    public PessoaJuridica() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
