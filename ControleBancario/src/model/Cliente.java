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

    public Cliente(Pessoa pessoa, Double renda, boolean situacao, List<ContaBancaria> contasBancarias) {
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

    public static boolean adicionarCliente(Cliente cliente) {
        try {
            CLIENTES.add(cliente);
            return true;
        } catch (Exception e) {
            System.out.println("Falha ao adicionar cliente ao escopo global" + e.toString());
            return false;
        }
    }

    public static boolean serializar() {
        try {
            Arquivo.gravar(CLIENTES, LOCAL);
            return true;
        } catch (Exception e) {
            System.out.println("Falha ao serializar" + e.toString());
            return false;
        }
    }

    public static boolean carregarContas() {
        try {
            CLIENTES = (ArrayList<Cliente>) Arquivo.ler(LOCAL);
            return true;
        } catch (Exception e) {
            System.out.println("Falha ao carregar os clientes do arquivo" + e.toString());
            return false;
        }
    }

}
