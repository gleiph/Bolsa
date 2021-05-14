package br.ufjf.dcc.bolsa;

import br.ufjf.dcc.bolsa.model.Ativo;
import br.ufjf.dcc.bolsa.model.Carteira;
import br.ufjf.dcc.bolsa.model.Negociacao;
import br.ufjf.dcc.bolsa.utils.Arquivo;
import br.ufjf.dcc.bolsa.utils.PropertyBasedInterfaceMarshal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author gleiph
 */
public class Dados {

    private static final String ATIVOS_PATH = "Ativos.json";
    private static final String NEGOCIACOES_PATH = "Negociacoes.json";

    private static List<Carteira> carteiras;
    private static List<Ativo> ativos;
    private static List<Negociacao> negociacoes;

    static {
        carteiras = new ArrayList<>();
        ativos = new ArrayList<>();
        negociacoes = new ArrayList<>();
    }

    public static List<Carteira> getCarteiras() {
        return carteiras;
    }

    public static void setCarteiras(List<Carteira> carteiras) {
        Dados.carteiras = carteiras;
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

    public static void salvar() {
        try {
            Gson gson = new Gson();
            String jsonAtivos = gson.toJson(ativos);
            Arquivo.gravarArquivo(ATIVOS_PATH, jsonAtivos);

            gson = new GsonBuilder()
                    .registerTypeAdapter(Negociacao.class,
                            new PropertyBasedInterfaceMarshal())
                    .create();
            
            Type listNegociacoes = new TypeToken<ArrayList<Negociacao>>() {
            }.getType();
            
            String jsonNegociacoes = gson.toJson(negociacoes, listNegociacoes);
            Arquivo.gravarArquivo(NEGOCIACOES_PATH, jsonNegociacoes);

        } catch (IOException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void recuperar() {
        try {
            String conteudoAtivo = Arquivo.lerArquivo(ATIVOS_PATH);
            Gson gson = new Gson();

            Type listAtivos = new TypeToken<ArrayList<Ativo>>() {
            }.getType();
            ativos = new Gson().fromJson(conteudoAtivo, listAtivos);

            String conteudoNegociacoes = Arquivo.lerArquivo(NEGOCIACOES_PATH);
            Type listNegociacoes = new TypeToken<ArrayList<Negociacao>>() {
            }.getType();

            gson = new GsonBuilder()
                    .registerTypeAdapter(Negociacao.class,
                            new PropertyBasedInterfaceMarshal())
                    .create();

            negociacoes = gson.fromJson(conteudoNegociacoes, listNegociacoes);

        } catch (IOException ex) {
            System.out.println("Arquivo invalido... ");
        }
    }
}
