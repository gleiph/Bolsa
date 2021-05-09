package br.ufjf.dcc.bolsa.model;

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

        int quantidadeAtualizada = this.getAtivo().getQuantidade() - quantidade;
        this.getAtivo().setQuantidade(quantidadeAtualizada);
        
        if(quantidadeAtualizada == 0){
            this.getAtivo().setPrecoMedio(0);
        }
        
    }
    
    
}
