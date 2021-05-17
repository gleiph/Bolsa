package br.ufjf.dcc.bolsa.view;

import br.ufjf.dcc.bolsa.Dados;
import br.ufjf.dcc.bolsa.controller.AddAtivo;
import br.ufjf.dcc.bolsa.controller.AddCarteira;
import br.ufjf.dcc.bolsa.controller.AddNegociacao;
import br.ufjf.dcc.bolsa.controller.CarregarListener;
import br.ufjf.dcc.bolsa.controller.TratarDados;
import br.ufjf.dcc.bolsa.model.Ativo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author gleiph
 */
public class JanelaPrincipal extends JFrame {

    private PainelCarteira painelCarteira;
    private PainelNegociacoes painelNegociacoes;

    public JanelaPrincipal() {
        super();
    }

    public void atualizar() {
        
        painelCarteira.atualiza();
        painelNegociacoes.atualiza();
        this.repaint();
    }

    public static void main(String[] args) {

        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        janelaPrincipal.setSize(1200,600);
        janelaPrincipal.addWindowListener(new TratarDados(janelaPrincipal));

        
        /*=================================================
                    MENU ADICIONAR
        ===================================================*/
        JMenuBar menu = new JMenuBar();
        JMenu subMenuAdicionar = new JMenu("Adicionar");

        /*=================================================
                    MENU AÇÃO
        ===================================================*/
        JMenuItem addAcao = new JMenuItem("Ação");
        addAcao.addActionListener(new AddAtivo(janelaPrincipal));
        subMenuAdicionar.add(addAcao);

        /*=================================================
                    MENU NEGOCIAÇÃO
        ===================================================*/
        JMenuItem addNegociacao = new JMenuItem("Negociação");
        addNegociacao.addActionListener(new AddNegociacao(janelaPrincipal));
        subMenuAdicionar.add(addNegociacao);

        /*=================================================
                    MENU CARTEIRA
        ===================================================*/
        JMenuItem addCarteira = new JMenuItem("Carteira");
        addCarteira.addActionListener(new AddCarteira());
        subMenuAdicionar.add(addCarteira);
        
        menu.add(subMenuAdicionar);

        /*=================================================
                    MENU CARREGAR
        ===================================================*/
        
        JMenu subMenuCarregar = new JMenu("Carregar");
        
        /*=================================================
                    MENU CARTEIRA
        ===================================================*/
        JMenu carregarCarteira = new JMenu("Carteira");
        carregarCarteira.addChangeListener(new CarregarListener(janelaPrincipal));
        subMenuCarregar.add(carregarCarteira);
        
        
        menu.add(subMenuCarregar);
                
        
        janelaPrincipal.setJMenuBar(menu);

        janelaPrincipal.setLayout(new BorderLayout());

        janelaPrincipal.painelCarteira = new PainelCarteira(janelaPrincipal);
        janelaPrincipal.add(janelaPrincipal.painelCarteira, BorderLayout.WEST);

        janelaPrincipal.painelNegociacoes = new PainelNegociacoes(janelaPrincipal);
        janelaPrincipal.painelNegociacoes.atualiza();
        janelaPrincipal.add(janelaPrincipal.painelNegociacoes, BorderLayout.CENTER);

        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setVisible(true);

    }

    public void addAtivo(String nome) throws NullPointerException {
        
        Dados.getCarteiraAtiva().getAtivos().add(new Ativo(nome, 0, 0));
        this.atualizar();
    }

    public void addNegociacao(String nome, int quantidade, double precoUnitario, double taxaNegociacao, double taxaLiquidacao, double total, String tipo) {
        this.painelNegociacoes.addNegociacao(nome, quantidade, precoUnitario, taxaNegociacao, taxaLiquidacao, total, tipo);
        this.atualizar();
    }

}