package model;

import java.util.Date;

/**
 *
 * @author icaro
 */
public class ContaEspecial extends ContaCorrente {

    private Double limite;

    public ContaEspecial(Double limite, Integer numero, Date dataAbertura, Date dataEncerramento, boolean situacao, String senha, Double saldo, Cliente cliente) {
        super(numero, dataAbertura, dataEncerramento, situacao, senha, saldo, cliente);
        this.limite = limite;
        this.numero = fornecerNumero();
    }

    public ContaEspecial(Double limite) {
        this.limite = limite;
        this.numero = fornecerNumero();
    }
    
    public ContaEspecial(){
        this.numero = fornecerNumero();
    }

    
    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacarValor(Double valor) {
        if(this.saldo + this.limite > valor){
            this.saldo -= valor;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean alterarLimite(Double limite) {
        try {
            this.limite = limite;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
