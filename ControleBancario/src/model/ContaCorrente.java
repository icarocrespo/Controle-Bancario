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

    public ContaCorrente() {
        this.numero = fornecerNumero();
    }

    
    @Override
    public boolean abrirConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if(this.saldo > valor){
            this.saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean depositarValor(Double valor) {
        if(valor > 0){
            this.saldo += valor;
            return true;
        }else{
            return false;
        }
    }
    
}
