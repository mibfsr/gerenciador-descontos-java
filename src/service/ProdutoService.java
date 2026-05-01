package service;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    List<model.Produto> listaDeProdutos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        listaDeProdutos.add(produto);
        System.out.println("---------------------------------------");
        System.out.println("Produto adicionado com sucesso");
        System.out.println("---------------------------------------");
    }

    public void listarProdutos() {

        System.out.println("---------------------------------------");
        if (listaDeProdutos.isEmpty()) {
            System.out.println("Lista de produtos vazia!");
        } else {

                int contador = 1;

                if (Produto.getDescontoGlobal() == 0) {

                    System.out.println("========== LISTA DE PRODUTOS ==========");
                    for (Produto produto : listaDeProdutos) {

                        System.out.printf(
                                "ID: %d %n" +
                                "Nome: %s%n" +
                                "Preço base: R$ %.2f%n",
                                        contador,
                                produto.getNome(),
                                produto.getPrecoBase());
                                System.out.println("---------------------------------------");
                        contador++;
                    }
                } else {
                    System.out.println("========== LISTA DE PRODUTOS ==========");

                    for (Produto produto : listaDeProdutos) {

                        System.out.printf(
                                "ID: %d %n" +
                                        "Nome: %s%n" +
                                        "Preço base: R$ %.2f%n" +
                                        "Preço com desconto: R$ %.2f %n",
                                contador,
                                produto.getNome(),
                                produto.getPrecoBase(),
                                produto.calcularPrecoFinal());
                        System.out.println("---------------------------------------");
                        contador++;
                    }
                }
            }
        System.out.println("=======================================");
    }

    public void removerProduto(String nome) {

        boolean removido = listaDeProdutos.removeIf(produto -> produto.getNome().equalsIgnoreCase(nome));

        System.out.println("---------------------------------------");
        if (removido) {
            System.out.println("Produto removido com sucesso");
        } else {
            System.out.println("Produto não encontrado!");
        }
        System.out.println("---------------------------------------");
    }

    public void limparLista() {
        listaDeProdutos.clear();
    }
}
