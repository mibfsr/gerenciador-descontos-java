package model;

public class Produto {
    private String nome;
    private double precoBase;
    static private double descontoGlobal;

    public Produto(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public double calcularPrecoFinal() {
        System.out.println("Desconto aplicado com sucesso");
        return precoBase - (precoBase * 0.1);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public static double getDescontoGlobal() {
        return descontoGlobal;
    }

    public static void setDescontoGlobal(double descontoGlobal) {
        Produto.descontoGlobal = descontoGlobal;
    }
}
