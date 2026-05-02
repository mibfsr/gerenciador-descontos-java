package model;

import exceptions.TaxaFreteInvalidaException;

public class ProdutoFisico extends Produto{

    private double taxaFrete;

    public ProdutoFisico(String nome, double precoBase, double taxaFrete) {
        super(nome, precoBase);
        setTaxaFrete(taxaFrete);
    }

    @Override
    public double calcularPrecoFinal() {
        return super.calcularPrecoFinal() + this.taxaFrete;
    }

    public double getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(double taxaFrete) {
        if (taxaFrete < 0) {
            throw new TaxaFreteInvalidaException("Taxa de frete inválida.");
        } else {
            this.taxaFrete = taxaFrete;
        }
    }
}
