package model;

import java.util.Calendar;
import java.util.Date;

public class ContaPoupanca extends ContaCorrente {

    private Double juros;

    public ContaPoupanca() {

    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    @Override
    public boolean sacarValor(Double valor) {
        Date dataDeposito = new Date(System.currentTimeMillis());
        
        if (this.saldo > valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean depositarValor(Double valor) {
        Calendar c = Calendar.getInstance();
        
        if (valor > 0) {
            this.saldo += valor;
            return true;
        } else {
            return false;
        }
    }
    
    public void aplicarRendimentos(){
        Date dataDeposito = new Date(System.currentTimeMillis());        
    }
}
