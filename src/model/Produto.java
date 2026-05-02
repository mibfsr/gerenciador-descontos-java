package model;

import exceptions.DescontoInvalidoException;
import exceptions.NomeInvalidoException;
import exceptions.PrecoInvalidoException;

public abstract class Produto {
    private String nome;
    private double precoBase;
    static private double descontoGlobal;

    public Produto(String nome, double precoBase) {
        setNome(nome);
        setPrecoBase(precoBase);
    }

    public double calcularPrecoFinal() {
        return precoBase - (precoBase * descontoGlobal);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new NomeInvalidoException("Digite um nome válido");
        } else {
            this.nome = nome;
        }
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        if (precoBase < 0) {
            throw new PrecoInvalidoException("O preço do produto inválido.");
        } else {
            this.precoBase = precoBase;
        }
    }

    public static double getDescontoGlobal() {
        return descontoGlobal;
    }

    public static void setDescontoGlobal(double descontoGlobal) {
        if (descontoGlobal < 0) {
            throw new DescontoInvalidoException("Desconto inválido.");
        } else {
            Produto.descontoGlobal = descontoGlobal;
        }

    }
}
