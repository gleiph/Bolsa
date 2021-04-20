package br.ufjf.dcc.bolsa.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gleiph
 */
public class JanelaPrincipal extends JFrame {

    private JPanel painelCarteira;
    private JPanel painelNegociacoes;

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
        
        
        janelaPrincipal.setLayout(new BorderLayout());

        janelaPrincipal.painelCarteira = PainelCarteira.desenha(janelaPrincipal);
        janelaPrincipal.add(janelaPrincipal.painelCarteira, BorderLayout.WEST);

        janelaPrincipal.painelNegociacoes = PainelNegociacoes.desenha(janelaPrincipal);
        janelaPrincipal.add(janelaPrincipal.painelNegociacoes, BorderLayout.CENTER);

        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setVisible(true);
    }

    
    
}
