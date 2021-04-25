package br.ufjf.dcc.bolsa.model;

/**
 *
 * @author gleiph
 */
public class Ativo {
    
    private String tag;
    private int quantidade;
    private double precoMedio;

    public Ativo(String tag, int quantidade, double precoMedio) {
        this.tag = tag;
        this.quantidade = quantidade;
        this.precoMedio = precoMedio;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(double precoMedio) {
        this.precoMedio = precoMedio;
    }

    @Override
    public String toString() {
        return tag;
    }
 
}
