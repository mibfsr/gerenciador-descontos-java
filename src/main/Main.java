package main;

import model.Produto;
import service.ProdutoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        ProdutoService produtoService = new ProdutoService();

        boolean sistemaOnline = true;

        while (sistemaOnline) {
            System.out.printf(
                    "========== PRODUCT LIST ==========%n" +
                    "1 - CADASTRAR PRODUTO%n" +
                    "2 - MOSTRAR LISTA DE PRODUTOS%n" +
                    "3 - EXCLUIR PRODUTO%n" +
                    "4 - LIMPAR LISTA%n" +
                    "5 - SAIR DO SISTEMA%n" +
                    "6 - APLICAR DESCONTO%n" +
                    "==================================%n" +
                    "Digite a sua escolha: ");
            String escolhaServico = leitor.nextLine();

            switch (escolhaServico) {
                case "1":
                    System.out.println("Digite o nome do produto: ");
                    String nomeProdutoAdicionado = leitor.nextLine();

                    System.out.println("Digite o valor base do produto: ");
                    double valorProdutoAdicionado = leitor.nextDouble();
                    leitor.nextLine();

                    Produto novoProduto = new Produto(nomeProdutoAdicionado, valorProdutoAdicionado);

                    produtoService.adicionarProduto(novoProduto);
                    break;
                case "2":
                    produtoService.listarProdutos();
                    break;
                case "3":
                    System.out.println("Digite o nome do produto: ");
                    String nomeProdutoExcluido = leitor.nextLine();

                    produtoService.removerProduto(nomeProdutoExcluido);
                    break;
                case "4":
                    produtoService.limparLista();
                    break;
                case "5":
                    sistemaOnline = false;
                    break;
                case "6":
                    System.out.println("Digite o valor do desconto: (ex: 10 para 10%)");
                    int valorDescontoAplicado = leitor.nextInt();
                    leitor.nextLine();

                    Produto.setDescontoGlobal(valorDescontoAplicado / 100.0);
                    break;
                default:
                    System.out.println("Operação inválida!");
            }
        }
    }
}
