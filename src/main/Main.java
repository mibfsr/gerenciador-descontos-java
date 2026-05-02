package main;

import exceptions.*;
import model.Produto;
import model.ProdutoDigital;
import model.ProdutoFisico;
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
                    try {
                        System.out.println("Digite o nome do produto: ");
                        String nomeProdutoAdicionado = leitor.nextLine();

                        System.out.println("Digite o valor base do produto: ");
                        double valorProdutoAdicionado = leitor.nextDouble();
                        leitor.nextLine();

                        System.out.printf(
                                "======== TIPO DE PRODUTO ========%n" +
                                "(F) FÍSICO%n" +
                                "(D) DIGITAL%n" +
                                "=================================%n");
                        String escolhaTipoProduto = leitor.nextLine();

                        if (escolhaTipoProduto.equalsIgnoreCase("F")) {

                            System.out.println("Digite a taxa de frete: ");
                            double taxaFrete = leitor.nextDouble();
                            leitor.nextLine();

                            ProdutoFisico novoProdutoFisico = new ProdutoFisico(nomeProdutoAdicionado, valorProdutoAdicionado, taxaFrete);
                            produtoService.adicionarProduto(novoProdutoFisico);

                        } else if (escolhaTipoProduto.equalsIgnoreCase("D")) {

                            ProdutoDigital novoProdutoDigital = new ProdutoDigital(nomeProdutoAdicionado, valorProdutoAdicionado);
                            produtoService.adicionarProduto(novoProdutoDigital);

                        } else {
                            System.out.println("Valor inválido");
                        }
                    } catch (PrecoInvalidoException |NomeInvalidoException | TaxaFreteInvalidaException e) {
                        System.out.println("Erro ao cadastrar: " + e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        produtoService.listarProdutos();
                    } catch (ListaDeProdutosVaziaException e) {
                        System.out.println("Operação cancelada: "  + e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        System.out.println("Digite o nome do produto: ");
                        String nomeProdutoExcluido = leitor.nextLine();

                        produtoService.removerProduto(nomeProdutoExcluido);
                    } catch (ProdutoNaoEncontradoException e) {
                        System.out.println("Busca inválida: " + e.getMessage());
                    }
                    break;
                case "4":
                    try {
                        produtoService.limparLista();
                    } catch (ListaDeProdutosVaziaException e) {
                        System.out.println("Operação cancelada: "  + e.getMessage());
                    }
                    break;
                case "5":
                    sistemaOnline = false;
                    break;
                case "6":
                    try {
                        System.out.println("Digite o valor do desconto: (ex: 10 para 10%)");
                        int valorDescontoAplicado = leitor.nextInt();
                        leitor.nextLine();

                        Produto.setDescontoGlobal(valorDescontoAplicado / 100.0);
                    } catch (DescontoInvalidoException e) {
                        System.out.println("Valor não aceito:  " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Operação inválida!");
            }
        }
    }
}
