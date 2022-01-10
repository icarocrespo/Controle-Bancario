package model;

/**
 *
 * @author icaro
 */
public class PessoaFisica extends Pessoa {
    
    private String cpf;
    private String rg;

    public PessoaFisica(String nome, String endereco, String CEP, String telefone, String cpf, String rg) {
        super(nome, endereco, CEP, telefone);
        this.cpf = cpf;
        this.rg = rg;
    }

    public PessoaFisica() {
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
}