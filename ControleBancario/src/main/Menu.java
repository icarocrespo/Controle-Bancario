package main;

import java.util.Scanner;

/**
 *
 * @author icaro
 */
public class Menu {

    static Scanner x = new Scanner(System.in);

    public static void principalMenu() {
        int opcao;
        System.out.println("MENU PRINCIPAL");
        do {
            System.out.println("Bem-vindo ao Sistema de Controle Bancário \n");
            System.out.println("0. Sair.");
            System.out.println("1. Gerenciamento de clientes.");
            System.out.println("2. Gerenciamento de contas bancárias.");
            System.out.print("Opção: ");
            opcao = x.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Você saiu.");
                    break;
                case 1:
                    clienteMenu();
                    break;
                case 2:
                    contaMenu();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    public static void clienteMenu() {
        int opcao;
        System.out.println("MENU DO CLIENTE");
        do {
            System.out.println("0. Voltar ao menu principal.");
            System.out.println("1. Cadastrar cliente.");
            System.out.println("2. Consultar cliente.");
            System.out.println("3. Alterar cliente.");
            System.out.println("4. Excluir cliente.");
            System.out.print("Opção: ");
            opcao = x.nextInt();

            switch (opcao) {
                case 0:
                    principalMenu();
                    break;
                case 1:
                    cadastrarClienteMenu();
                    break;
                case 2:
                    consultarClienteMenu();
                    break;
                case 3:
                    alterarClienteMenu();
                    break;
                case 4:
                    excluirClienteMenu();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    public static void contaMenu() {
        int opcao;
        System.out.println("MENU DA CONTA BANCÁRIA");
        do {
            System.out.println("0. Voltar ao menu principal.");
            System.out.println("1. Pesquisar a conta corrente com maior saldo.");
            System.out.println("2. Pesquisar a conta corrente com menor saldo.");
            System.out.println("3. Pesquisar a conta poupança com maior saldo.");
            System.out.println("4. Pesquisar a conta especial com maior saldo, considerando o limite.");
            System.out.println("5. Pesquisar o cliente pessoa física com maior saldo, considerando \ntodas as contas bancárias as quais ele está vinculado.");
            System.out.println("6. Pesquisar o cliente pessoa física com menor saldo, considerando \ntodas as contas bancárias as quais ele está vinculado.");
            System.out.println("7. Pesquisar o cliente pessoa jurídica com maior saldo, considerando \ntodas as contas bancárias as quais ele está vinculado.");
            System.out.println("8. Pesquisar o cliente pessoa jurídica com menor saldo, considerando \ntodas as contas bancárias as quais ele está vinculado.");
            System.out.print("Opção: ");
            opcao = x.nextInt();

            switch (opcao) {
                case 0:
                    principalMenu();
                    break;
                case 1:
                    contaCCmaiorSaldoMenu();
                    break;
                case 2:
                    contaCCmenorSaldoMenu();
                    break;
                case 3:
                    contaCPmaiorSaldoMenu();
                    break;
                case 4:
                    contaCEmaiorSaldoMenu();
                    break;
                case 5:
                    contaPFmaiorSaldoMenu();
                    break;
                case 6:
                    contaPFmenorSaldoMenu();
                    break;
                case 7:
                    contaPJmaiorSaldoMenu();
                    break;
                case 8:
                    contaPJmenorSaldoMenu();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    public static void cadastrarClienteMenu() {

    }

    public static void consultarClienteMenu() {

    }

    public static void alterarClienteMenu() {

    }

    public static void excluirClienteMenu() {

    }

    public static void contaCCmaiorSaldoMenu() {

    }

    public static void contaCCmenorSaldoMenu() {

    }

    public static void contaCPmaiorSaldoMenu() {

    }

    public static void contaCEmaiorSaldoMenu() {

    }
    
    public static void contaPFmaiorSaldoMenu() {

    }
    
    public static void contaPFmenorSaldoMenu() {

    }
    
    public static void contaPJmaiorSaldoMenu() {

    }
    
    public static void contaPJmenorSaldoMenu() {

    }
}
