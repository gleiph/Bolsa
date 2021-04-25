package br.ufjf.dcc.bolsa;

import br.ufjf.dcc.bolsa.model.Ativo;
import br.ufjf.dcc.bolsa.model.Negociacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gleiph
 */
public class Dados {

    private static List<Ativo> ativos;
    private static List<Negociacao> negociacoes;

    static {
        ativos = new ArrayList<>();
        negociacoes = new ArrayList<>();
    }
    
    public static List<Ativo> getAtivos() {
        return ativos;
    }

    public static void setAtivos(List<Ativo> ativos) {
        Dados.ativos = ativos;
    }

    public static List<Negociacao> getNegociacoes() {
        return negociacoes;
    }

    public static void setNegociacoes(List<Negociacao> negociacoes) {
        Dados.negociacoes = negociacoes;
    }

    public static Ativo getAtivo(String tag) {
        for (Ativo ativo : ativos) {
            if (ativo.getTag().equals(tag)) {
                return ativo;
            }
        }
        
        return null;
    }
}
