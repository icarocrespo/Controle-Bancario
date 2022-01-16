package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Cliente;
import model.ContaBancaria;
import model.ContaCorrente;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;

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
            x.nextLine();

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

    // Submenus de cliente
    public static void cadastrarClienteMenu() {

        int opcao;
        Cliente cliente;
        Double renda;

        System.out.println("Você acessou a opção 1. Cadastrar cliente.");

        do {
            System.out.println("Para cadastrar um novo cliente preencha as seguintes informações");
            System.out.print("Você é Pessoa Física (1) ou Pessoa Jurídica (2)? ");
            System.out.println("Para voltar, digite '0'.");

            opcao = x.nextInt();
            x.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo de 1. Cadastrar cliente.");
                    break;
                case 1:
                    boolean existeCPF = false;

                    PessoaFisica pf = new PessoaFisica();
                    System.out.println("Informe o nome: ");
                    pf.setNome(x.nextLine());
                    System.out.println("Informe o CPF: ");
                    pf.setCpf(x.nextLine());
                    System.out.println("Informe o RG: ");
                    pf.setRg(x.nextLine());
                    System.out.println("Informe o endereço: ");
                    pf.setEndereco(x.nextLine());
                    System.out.println("Informe o CEP: ");
                    pf.setCEP(x.nextLine());
                    System.out.println("Informe o telefone: ");
                    pf.setTelefone(x.nextLine());
                    System.out.println("Informe a renda: ");
                    renda = x.nextDouble();

                    for (Cliente c : Cliente.CLIENTES) {
                        if (c.getPessoa() instanceof PessoaFisica) {
                            PessoaFisica aux = (PessoaFisica) c.getPessoa();
                            pf.getCpf().equals(aux.getCpf());
                            existeCPF = true;
                            break;
                        }
                    }

                    if (!existeCPF) {
                        cliente = new Cliente(pf, renda, true);
                        Cliente.adicionarCliente(cliente);
                    }
                    break;
                case 2:
                    boolean existeCNPJ = false;

                    PessoaJuridica pj = new PessoaJuridica();
                    System.out.println("Informe o nome: ");
                    pj.setNome(x.nextLine());
                    System.out.println("Informe o CPF: ");
                    pj.setCnpj(x.nextLine());
                    System.out.println("Informe o endereço: ");
                    pj.setEndereco(x.nextLine());
                    System.out.println("Informe o CEP: ");
                    pj.setCEP(x.nextLine());
                    System.out.println("Informe o telefone: ");
                    renda = x.nextDouble();

                    for (Cliente c : Cliente.CLIENTES) {
                        if (c.getPessoa() instanceof PessoaJuridica) {
                            PessoaJuridica aux = (PessoaJuridica) c.getPessoa();
                            pj.getCnpj().equals(aux.getCnpj());
                            existeCNPJ = true;
                            break;
                        }
                    }

                    if (!existeCNPJ) {
                        cliente = new Cliente(pj, renda, true);
                        Cliente.adicionarCliente(cliente);
                    }

                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
        Cliente.serializar();
    }

    public static void consultarClienteMenu() {
        String pesquisa;
        List<Cliente> clientes = new ArrayList<>();

        do {
            System.out.println("Você acessou a opção 2. Consultar cliente.");
            System.out.println("Para voltar, digite 'sair'.");
            //System.out.print("Confirme sua senha: ");
            pesquisa = x.nextLine();

            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }

            for (Cliente c : Cliente.CLIENTES) {
                if (c.getPessoa() instanceof PessoaFisica) {
                    PessoaFisica aux = (PessoaFisica) c.getPessoa();

                    if (aux.getNome().contains(pesquisa) || aux.getCpf().contains(pesquisa)) {
                        clientes.add(c);
                    }
                } else {
                    PessoaJuridica aux = (PessoaJuridica) c.getPessoa();
                    if (aux.getNome().contains(pesquisa) || aux.getCnpj().contains(pesquisa)) {
                        clientes.add(c);
                    }
                }
            }
            if (!clientes.isEmpty()) {
                System.out.println("Resutado da pesquisa.");
                for (Cliente c : clientes) {
                    c.exibirCliente();
                }
            } else {
                System.out.println("Nenhum cliente encontrado.");
            }
        } while (!pesquisa.equalsIgnoreCase("sair"));
    }

    public static void consultarTodosClienteMenu() {
        String pesquisa;
        List<Cliente> pesquisaCliente = null;
        System.out.println("Você acessou a opção 2. Cadastrar cliente.");

        do {
            System.out.println("Você pode pesquisar clientes sobre 'NOME', 'CPF' e 'CNPJ'.");
            System.out.println("Para voltar, digite 'sair'.");
            System.out.print("Informe o texto da pesquisa a seguir: ");
            pesquisa = x.nextLine();

            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }

            for (Cliente c : Cliente.CLIENTES) {
                if (c.getPessoa() instanceof PessoaFisica) {
                    PessoaFisica aux = (PessoaFisica) c.getPessoa();

                    if (aux.getNome().contains(pesquisa) || aux.getCpf().contains(pesquisa)) {
                        pesquisaCliente.add(c);
                    }
                } else {
                    PessoaJuridica aux = (PessoaJuridica) c.getPessoa();
                    if (aux.getNome().contains(pesquisa) || aux.getCnpj().contains(pesquisa)) {
                        pesquisaCliente.add(c);
                    }
                }
            }

            System.out.println("Resutado da pesquisa.");
            for (Cliente c : pesquisaCliente) {
                c.exibirCliente();
            }
        } while (!pesquisa.equalsIgnoreCase("sair"));
    }

    public static void alterarClienteMenu() {
        String pesquisa;
        Cliente cliente = null;
        Double renda;
        System.out.println("Você acessou a opção 3. Alter cliente.");

        do {
            System.out.println("Informe o CNPJ ou CPF do cliente que deseja alterar.");
            System.out.println("Para voltar, digite 'sair'.");
            pesquisa = x.nextLine();

            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }

            for (Cliente c : Cliente.CLIENTES) {
                if (c.getPessoa() instanceof PessoaFisica) {
                    PessoaFisica aux = (PessoaFisica) c.getPessoa();
                    if (aux.getCpf().equals(pesquisa)) {
                        cliente = c;
                        break;
                    }
                } else {
                    PessoaJuridica aux = (PessoaJuridica) c.getPessoa();
                    if (aux.getCnpj().equals(pesquisa)) {
                        cliente = c;
                        break;
                    }
                }
            }

            if (cliente != null && cliente.getPessoa() instanceof PessoaFisica) {
                boolean existeCPF = false;

                PessoaFisica pf = new PessoaFisica();
                System.out.print("Informe o nome: ");
                pf.setNome(x.nextLine());
                pf.setCpf(((PessoaFisica) cliente.getPessoa()).getCpf());
                pf.setCpf(x.next());
                System.out.print("Informe o RG: ");
                pf.setRg(x.next());
                System.out.print("Informe o endereço: ");
                pf.setEndereco(x.nextLine());
                System.out.print("Informe o CEP: ");
                pf.setCEP(x.next());
                System.out.print("Informe o telefone: ");
                pf.setTelefone(x.nextLine());
                System.out.print("Informe a renda: ");
                renda = x.nextDouble();

                cliente.setPessoa(pf);

                //Cliente.CLIENTES.get(0);
            } else if (cliente != null && cliente.getPessoa() instanceof PessoaJuridica) {

            } else {

            }
        } while (!pesquisa.equalsIgnoreCase("sair"));
    }

    public static void excluirClienteMenu() {

    }

    public static void contaMenu() {
        int opcao;
        do {
            System.out.println("MENU DA CONTA BANCÁRIA");

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
            x.nextLine();

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

    public static void contaCCmaiorSaldoMenu() {
        System.out.println("1. Pesquisar a conta corrente com maior saldo.");
        ContaCorrente.maiorSaldo();
        contaMenu();
    }

    public static void contaCCmenorSaldoMenu() {
        System.out.println("2. Pesquisar a conta corrente com menor saldo.");
        ContaCorrente.menorSaldo();
        contaMenu();
    }

    public static void contaCPmaiorSaldoMenu() {
        System.out.println("3. Pesquisar a conta poupança com maior saldo.");
        ContaCorrente.maiorSaldo();
        contaMenu();
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
