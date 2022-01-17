package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import main.Arquivo;

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
    
    public static void excluirCliente(String identificador){
        try{
            for(Cliente c : CLIENTES){
                if(c.getPessoa() instanceof PessoaFisica){
                    PessoaFisica clientePF = (PessoaFisica) c.getPessoa();
                    if(clientePF.getCpf().equals(identificador)){
                        CLIENTES.remove(c);
                        System.out.println("Cliente removido com sucesso.");
                        break;
                    }
                }else{
                    PessoaJuridica clientePJ = (PessoaJuridica) c.getPessoa();
                    if(clientePJ.getCnpj().equals(identificador)){
                        CLIENTES.remove(c);
                        System.out.println("Cliente removido com sucesso.");
                        break;
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Não foi possível excluir o cliente de CPF ou CNPJ: " + identificador);
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

    public static void contaPFmaiorSaldo() {
        Double valor = 0D;
        Double valorAux = 0D;
        Cliente cliente = new Cliente();

        for (Cliente c : CLIENTES) {
            if (c.getPessoa() instanceof PessoaFisica) {
                cliente = c;
                for (ContaBancaria cb : c.getContasBancarias()) {
                    valorAux += cb.getSaldo();
                }
                if (valorAux > valor) {
                    valor = valorAux;
                    valorAux = 0D;
                }
            }
        }
        if (cliente != null) {
            System.out.println("Valor total: R$ " + valor);
            cliente.exibirCliente();
        } else {
            System.out.println("Não foram encontrados clientes PF.");
        }
    }

    public static void contaPFmenorSaldo() {
        Double valor = 0D;
        Double valorAux = 0D;
        Cliente cliente = new Cliente();

        for (Cliente c : CLIENTES) {
            if (c.getPessoa() instanceof PessoaFisica) {
                cliente = c;
                for (ContaBancaria cb : c.getContasBancarias()) {
                    valorAux += cb.getSaldo();
                }
                if (valorAux < valor) {
                    valor = valorAux;
                    valorAux = 0D;
                }
            }
        }
        if (cliente != null) {
            System.out.println("Valor total: R$ " + valor);
            cliente.exibirCliente();
        } else {
            System.out.println("Não foram encontrados clientes PF.");
        }
    }

    public static void contaPJmaiorSaldo() {
        Double valor = 0D;
        Double valorAux = 0D;
        Cliente cliente = new Cliente();

        for (Cliente c : CLIENTES) {
            if (c.getPessoa() instanceof PessoaJuridica) {
                cliente = c;
                for (ContaBancaria cb : c.getContasBancarias()) {
                    valorAux += cb.getSaldo();
                }
                if (valorAux > valor) {
                    valor = valorAux;
                    valorAux = 0D;
                }
            }
        }
        if (cliente != null) {
            System.out.println("Valor total: R$ " + valor);
            cliente.exibirCliente();
        } else {
            System.out.println("Não foram encontrados clientes PJ.");
        }
    }

    public static void contaPJmenorSaldo() {
        Double valor = 0D;
        Double valorAux = 0D;
        Cliente cliente = new Cliente();

        for (Cliente c : CLIENTES) {
            if (c.getPessoa() instanceof PessoaJuridica) {
                cliente = c;
                for (ContaBancaria cb : c.getContasBancarias()) {
                    valorAux += cb.getSaldo();
                }
                if (valorAux < valor) {
                    valor = valorAux;
                    valorAux = 0D;
                }
            }
        }
        if (cliente != null) {
            System.out.println("Valor total: R$ " + valor);
            cliente.exibirCliente();
        } else {
            System.out.println("Não foram encontrados clientes PJ.");
        }
    }
}
