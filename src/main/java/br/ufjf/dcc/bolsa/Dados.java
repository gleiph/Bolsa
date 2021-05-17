package br.ufjf.dcc.bolsa;

import br.ufjf.dcc.bolsa.model.Carteira;
import br.ufjf.dcc.bolsa.model.Negociacao;
import br.ufjf.dcc.bolsa.utils.Arquivo;
import br.ufjf.dcc.bolsa.utils.PropertyBasedInterfaceMarshal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gleiph
 */
public class Dados {

    private static final String CARTEIRAS_PATH = "Carteiras.json";

    private static Carteira carteiraAtiva;
    private static List<Carteira> carteiras;

    static {
        carteiraAtiva = null;
        carteiras = new ArrayList<>();
    }

    public static Carteira getCarteiraAtiva() {
        return carteiraAtiva;
    }

    public static void setCarteiraAtiva(Carteira carteiraAtiva) {
        Dados.carteiraAtiva = carteiraAtiva;
    }

    public static List<Carteira> getCarteiras() {
        return carteiras;
    }

    public static void setCarteiras(List<Carteira> carteiras) {
        Dados.carteiras = carteiras;
    }

    public static Carteira getCarteira(String nome) {
        for (Carteira carteira : carteiras) {
            if (carteira.getNome().equals(nome)) {
                return carteira;
            }
        }

        return null;
    }

    public static void salvar() {
        try {

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Negociacao.class,
                            new PropertyBasedInterfaceMarshal())
                    .create();

            Arquivo.gravarArquivo(CARTEIRAS_PATH, gson.toJson(carteiras));

        } catch (IOException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void recuperar() {
        try {
            String conteudoCarterias = Arquivo.lerArquivo(CARTEIRAS_PATH);
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Negociacao.class,
                            new PropertyBasedInterfaceMarshal())
                    .create();

            Type listCarteiras = new TypeToken<ArrayList<Carteira>>() {
            }.getType();

            carteiras = gson.fromJson(conteudoCarterias, listCarteiras);

        } catch (IOException ex) {
            System.out.println("Arquivo invalido... ");
        }
    }
}
