package br.ufjf.dcc.bolsa.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gleip
 */
public class Carteira {
    
    private String nome;
    private List<Ativo> ativos;
    private List<Negociacao> negociacoes;

    public Carteira(String nome) {
        this.nome = nome;
        this.ativos = new ArrayList<>();
        this.negociacoes = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(List<Ativo> ativos) {
        this.ativos = ativos;
    }

    public List<Negociacao> getNegociacoes() {
        return negociacoes;
    }

    public void setNegociacoes(List<Negociacao> negociacoes) {
        this.negociacoes = negociacoes;
    }
    
    public Ativo getATivo(String codigo){
        for (Ativo ativo : ativos) {
            if(ativo.getTag().equals(codigo)){
                return ativo;
            }
        }
        return null;
    }
}
