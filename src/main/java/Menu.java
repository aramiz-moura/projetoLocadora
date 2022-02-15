import filme.Filme;
import pessoa.Cliente;
import pessoa.Funcionario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Menu {


    final private List<Cliente> listaClientes = new ArrayList<Cliente>();
    final private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    final public List<Filme> listaFilmes = new ArrayList<>();


    Scanner input = new Scanner(System.in);




    public void iniciarMenu() {
        //TODO: ADICIONAR METODO PARA TRATAR INPUT
        System.out.println("Olá. Por favor, selecione a opção desejada:");

        System.out.println("1 : Adicionar Cliente: \n" +
                            "2 : Adicionar Funcionario: \n" +
                            "3 : Adicionar Filme: \n" +
                            "4 : Mostrar lista de filmes: \n" +
                            "5: Mostrar todos os funcionários \n" +
                            "6: Gerar um arquivo texto com a lista de filmes: \n");
        int opcaoSelecionada = input.nextInt();
        //TODO CRIAR OPÇÃO PARA MOSTRAR TODOS OS CLIENTES;
        switch(opcaoSelecionada) {
            case 1:
                adicionarCliente();
                break;
            case 2:
                adicionarFuncionario();
                break;
            case 3:
                adicionarFilme();
                break;
            case 4:
                listaDeFilmes();
                break;
            case 5:
                listaDeFuncionarios();
                break;
            case 6:
                listaFilmesTxt();
                break;
            default:
                System.out.println("Opção não encontrada");
                iniciarMenu();

        }


    }

    private void adicionarCliente() {
        System.out.println("Por favor, informe o nome do Cliente: ");
        String nome = input.next();
        System.out.println("Agora, informe o cpf do Cliente: ");
        String cpf = input.nextLine();
        System.out.println("E por último, o id para o Cliente: ");
        Double id = input.nextDouble();

        Cliente cliente = new Cliente(nome, cpf, id);
        listaClientes.add(cliente);



        System.out.println("Cliente criado. O que gostaria de fazer? \n" +
                            "1: Adicionar novo cliente \n" +
                            "2: Ir para o menu \n");
        //TODO: ADICIONAR METODO PARA TRATAR INPUT;
        //TODO ADICIONAR O METODO
        int opcaoSelecionada = input.nextInt();
            if(opcaoSelecionada == 1){
                adicionarCliente();
            } else if (opcaoSelecionada == 2) {
                iniciarMenu();
            }
    }

    private void adicionarFuncionario(){
        System.out.println("Por favor, informe o nome do Funcionário: ");
        String nome = input.next();
        System.out.println("Agora, informe o cpf do Funcionário ");
        String cpf = input.next();
        System.out.println("Informe o cargo que irá exercer:  ");
        String cargo = input.next();
        System.out.println("E, por último, informe o salário a ser pago: ");
        double salario = input.nextDouble();

        Funcionario funcionario = new Funcionario(nome, cpf, cargo, salario);
        listaFuncionarios.add(funcionario);

        System.out.println("Funcionário criado. O que gostaria de fazer?" +
                "1: Adicionar novo Funcionário" +
                "2: Ir para o menu");
        int opcaoSelecionada = input.nextInt();
        if(opcaoSelecionada == 1){
            adicionarFuncionario();
        } else if (opcaoSelecionada == 2) {
            iniciarMenu();
        }
    }

    private void adicionarFilme() {
        System.out.println("Por favor, informe o nome do Filme: ");
        String nome = input.next();

        System.out.println("Agora, informe o ano do Filme:  ");
        int ano = input.nextInt();

        System.out.println("E por fim, informe o genero do Filme:  ");
        String genero = input.next();

        Filme filme = new Filme(nome,ano, genero);
        listaFilmes.add(filme);

        System.out.println("Filme adicionado. O que gostaria de fazer?" +
                "1: Adicionar novo Filme" +
                "2: Ir para o menu");

        int opcaoSelecionada = input.nextInt();
        if(opcaoSelecionada == 1){
            adicionarFilme();
        } else if (opcaoSelecionada == 2) {
            iniciarMenu();
        }
    }

    private void listaDeFilmes() {
        List<String> nomeFilmes = listaFilmes.stream().map(filme -> filme.getNome()).collect(Collectors.toList());
        System.out.println(nomeFilmes);
    }

    private void listaDeFuncionarios() {
        List<String> nomeFuncionarios = listaFuncionarios.stream().map(funcionario -> funcionario.getNome()).collect(Collectors.toList());
        System.out.println(nomeFuncionarios);
    }

    private void listaFilmesTxt() {
        try {
            FileWriter arquivoSaida = new FileWriter("listaFilmes.txt");
            BufferedWriter saida = new BufferedWriter(arquivoSaida);
            for(Filme filme: listaFilmes) {
                saida.write(filme.getNome());
                saida.newLine();
            }
            saida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
