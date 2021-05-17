package br.ufjf.dcc.bolsa.model;

import br.ufjf.dcc.bolsa.Dados;

/**
 *
 * @author gleiph
 */
public class Compra extends Negociacao{

    public Compra() {
        super();
    }
    
    
    @Override
    public double getTotal(){
        return this.getQuantidade() * this.getValorUnitario() + (this.getTaxaNegociacao() + this.getTaxaLiquidacao());
    }
    
    @Override
    public void atualiza(int quantidade, double precoUnitario){
        
        Ativo ativo = Dados.getCarteiraAtiva().getAtivo(this.getTagAtivo());
        
        double valorAtualizado = ativo.getPrecoMedio() * ativo.getQuantidade() + 
                precoUnitario * quantidade;
        int quantidadeAtualizada = ativo.getQuantidade() + quantidade;
        
        ativo.setPrecoMedio(valorAtualizado/quantidadeAtualizada);
        ativo.setQuantidade(quantidadeAtualizada);
        
    }

}
