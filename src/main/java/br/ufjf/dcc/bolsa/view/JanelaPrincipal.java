package br.ufjf.dcc.bolsa.view;

import br.ufjf.dcc.bolsa.controller.AddAcao;
import br.ufjf.dcc.bolsa.controller.AddNegociacao;
import br.ufjf.dcc.bolsa.model.Ativo;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 *
 * @author gleiph
 */
public class JanelaPrincipal extends JFrame {

    private List<Ativo> ativos;
    private PainelCarteira painelCarteira;
    private PainelNegociacoes painelNegociacoes;

    public JanelaPrincipal() {
        super();
        this.ativos = new ArrayList<>();
    }

    
    
    public void repintar(){
        System.out.println("repintar");
        painelCarteira.repaint();
        painelNegociacoes.repaint();
        this.repaint();
    }
    
    public static void main(String[] args) {
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        janelaPrincipal.setSize(1800
                , 600);
        
        
        JMenuBar menu = new JMenuBar();
        JMenu subMenu = new JMenu("Adicionar");
        
        JMenuItem addAcao = new JMenuItem("Ação");
        addAcao.addActionListener(new AddAcao(janelaPrincipal));
        subMenu.add(addAcao);

        JMenuItem addNegociacao = new JMenuItem("Negociação");
        addNegociacao.addActionListener(new AddNegociacao(janelaPrincipal));
        subMenu.add(addNegociacao);
        
        
        menu.add(subMenu);
        
        janelaPrincipal.setJMenuBar(menu);
        
        janelaPrincipal.setLayout(new BorderLayout());

        janelaPrincipal.painelCarteira = new PainelCarteira(janelaPrincipal);
        janelaPrincipal.add(janelaPrincipal.painelCarteira, BorderLayout.WEST);

        
        janelaPrincipal.painelNegociacoes = new PainelNegociacoes(janelaPrincipal);
        janelaPrincipal.painelNegociacoes.desenha();
        janelaPrincipal.add(janelaPrincipal.painelNegociacoes, BorderLayout.CENTER);

        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setVisible(true);
        
    }

    public void addAcao(String nome) throws Exception{
        this.painelCarteira.addAcao(nome);
        this.ativos.add(new Ativo(nome, 0,0));
        this.repaint();
    } 
    
    public void addNegociacao(String nome, int quantidade, double preco, double taxas, String tipo) throws Exception{
        
        this.repaint();
    }

    public List<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(List<Ativo> ativos) {
        this.ativos = ativos;
    }
    
}
