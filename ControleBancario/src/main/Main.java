package main;

import model.Cliente;

public class Main {

    public static void main(String[] args) {
//        try{
//            Cliente.carregarClientes();
//            System.out.println("Arquivo de dados de clientes carregado com sucesso.");
//        }catch(Exception e){
//            System.out.println("Arquivo de dados de clientes ainda inexistente.");
//        }finally{
//            
//        }
        
        Cliente.carregarClientes();

        
        Menu.principalMenu();

//        Cliente cliente = new Cliente(null, 0D, true, null);
//        Cliente cliente2 = new Cliente(null, 0D, true, null);
//        Cliente.adicionarCliente(cliente);
//        Cliente.adicionarCliente(cliente2);
//        Cliente.serializar();
//        
//        
        for (Cliente c : Cliente.CLIENTES) {
            c.exibirCliente();
        }
    }

}
