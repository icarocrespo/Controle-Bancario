package model;

import java.util.Date;

/**
 *
 * @author icaro
 */
public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(Integer numero, Date dataAbertura, Date dataEncerramento, boolean situacao, String senha, Double saldo, Cliente cliente) {
        super(numero, dataAbertura, dataEncerramento, situacao, senha, saldo, cliente);
    }

    public ContaCorrente(Cliente cliente) {
        this.numero = fornecerNumero();
        boolean abertura = abrirConta(cliente);
    }

    public ContaCorrente() {

    }

    @Override
    public boolean abrirConta(Cliente cliente) {
        try {
            this.cliente = cliente;
            this.dataAbertura = new Date(System.currentTimeMillis());
            this.saldo = 0D;
            this.situacao = true;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean encerrarConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public Double verificarSaldo() {
        return this.saldo;
    }

    @Override
    public boolean sacarValor(Double valor) {
        if (this.saldo > valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean depositarValor(Double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        } else {
            return false;
        }
    }

    public void exibirContaCorrente() {
        System.out.println("Nome do cliente: " + this.cliente.getPessoa().getNome());
        System.out.println("Número: " + this.getNumero());
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Situação: " + this.situacao);
        System.out.println("Data de abertura: " + this.dataAbertura);
        System.out.println("Data de encerramento: " + this.dataEncerramento);
    }

    public static void maiorSaldo() {
        ContaCorrente cc = new ContaCorrente();
        ContaCorrente aux;

        for (ContaBancaria cb : ContaBancaria.CONTAS) {
            if (cb instanceof ContaCorrente) {
                aux = (ContaCorrente) cb;
                if (aux.getSaldo() > cc.getSaldo() || cc.getSaldo() == null) {
                    cc = aux;
                }
            }
        }
        if (cc != null) {
            System.out.println("A conta corrente com maior saldo é:");
            cc.exibirContaCorrente();
        } else {
            System.out.println("Não há conta com maior saldo.");
        }
    }
    
    public static void menorSaldo() {
        ContaCorrente cc = new ContaCorrente();
        ContaCorrente aux;

        for (ContaBancaria cb : ContaBancaria.CONTAS) {
            if (cb instanceof ContaCorrente) {
                aux = (ContaCorrente) cb;
                if (aux.getSaldo() < cc.getSaldo() || cc.getSaldo() == null) {
                    cc = aux;
                }
            }
        }
        if (cc != null) {
            System.out.println("A conta corrente com maior saldo é:");
            cc.exibirContaCorrente();
        } else {
            System.out.println("Não há conta com maior saldo.");
        }
    }
}
