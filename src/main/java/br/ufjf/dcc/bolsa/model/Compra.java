package br.ufjf.dcc.bolsa.model;

/**
 *
 * @author gleiph
 */
public class Compra extends Negociacao{
    
    @Override
    public double getTotal(){
        return this.getQuantidade() * this.getValorUnitario() + this.getTaxas();
    }
    
    @Override
    public void atualiza(int quantidade, double precoUnitario){
        
        double valorAtualizado = this.getAtivo().getPrecoMedio() * this.getAtivo().getQuantidade() + 
                precoUnitario * quantidade;
        int quantidadeAtualizada = this.getAtivo().getQuantidade() + quantidade;
        
        this.getAtivo().setPrecoMedio(valorAtualizado/quantidadeAtualizada);
        this.getAtivo().setQuantidade(quantidadeAtualizada);
        
    }

}
