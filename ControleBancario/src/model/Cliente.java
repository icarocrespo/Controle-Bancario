package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import main.Arquivo;

/**
 *
 * @author icaro
 */
public class Cliente implements Serializable {

    public static String LOCAL = "src\\arquivos\\clientes.bin";
    public static ArrayList<Cliente> CLIENTES = new ArrayList<>();
    private Pessoa pessoa;
    private Double renda;
    private boolean situacao;
    private List<ContaBancaria> contasBancarias;

    public Cliente(Pessoa pessoa, Double renda, boolean situacao) {
        this.pessoa = pessoa;
        this.renda = renda;
        this.situacao = situacao;
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

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public List<ContaBancaria> getContasBancarias() {
        return contasBancarias;
    }

    public void setContasBancarias(List<ContaBancaria> contasBancarias) {
        this.contasBancarias = contasBancarias;
    }

    public void exibirCliente() {
        PessoaFisica pf;
        PessoaJuridica pj;
        if (pessoa instanceof PessoaFisica) {
            pf = (PessoaFisica) pessoa;
            System.out.println("-----------------");
            System.out.println("Nome: " + pf.getNome());
            System.out.println("CPF: " + pf.getCpf());
            System.out.println("RG: " + pf.getRg());
            System.out.println("Endereço: " + pf.getEndereco());
            System.out.println("CEP: " + pf.getCEP());
            System.out.println("Telefone: " + pf.getTelefone());
            System.out.println("-----------------");
        } else {
            pj = (PessoaJuridica) pessoa;
            System.out.println("-----------------");
            System.out.println("Nome: " + pj.getNome());
            System.out.println("CNPJ" + pj.getCnpj());
            System.out.println("Endereço: " + pj.getEndereco());
            System.out.println("CEP: " + pj.getCEP());
            System.out.println("Telefone: " + pj.getTelefone());
            System.out.println("-----------------");
        }

    }

    public static void adicionarCliente(Cliente cliente) {
        try {
            CLIENTES.add(cliente);
            System.out.println("Cliente adicionado à lista de clientes com sucesso.");
        } catch (Exception e) {
            System.out.println("Falha ao adicionar cliente ao escopo global" + e.toString());
        }
    }

    public static void serializar() {
        try {
            for (Cliente c : CLIENTES) {
                Arquivo.gravar(c, LOCAL);
            }
            System.out.println("Serialização efetuada com sucesso.");
        } catch (Exception e) {
            System.out.println("Falha ao serializar" + e.toString());
        }
    }

    public static boolean carregarClientes() {
        try {
            CLIENTES.add((Cliente) Arquivo.ler(LOCAL));
            return true;
        } catch (Exception e) {
            System.out.println("Falha ao carregar os clientes do arquivo " + e.toString());
            return false;
        }
    }

}
