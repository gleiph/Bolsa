package br.ufjf.dcc.bolsa.model;

/**
 *
 * @author gleiph
 */
public class Venda extends Negociacao{

    @Override
    public double getTotal() {
        return this.getQuantidade() * this.getValorUnitario() - this.getTaxas();
    }
    
}
