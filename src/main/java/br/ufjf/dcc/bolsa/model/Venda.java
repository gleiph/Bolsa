package br.ufjf.dcc.bolsa.model;

import br.ufjf.dcc.bolsa.Dados;

/**
 *
 * @author gleiph
 */
public class Venda extends Negociacao{

    public Venda() {
        super();
    }

    @Override
    public double getTotal() {
        return this.getQuantidade() * this.getValorUnitario() - (this.getTaxaNegociacao() + this.getTaxaLiquidacao());
    }

    @Override
    public void atualiza(int quantidade, double precoUnitario) {

                Ativo ativo = Dados.getCarteiraAtiva().getAtivo(this.getTagAtivo());

        int quantidadeAtualizada = ativo.getQuantidade() - quantidade;
        ativo.setQuantidade(quantidadeAtualizada);
        
        if(quantidadeAtualizada == 0){
            ativo.setPrecoMedio(0);
        }
        
    }
    
    
}
