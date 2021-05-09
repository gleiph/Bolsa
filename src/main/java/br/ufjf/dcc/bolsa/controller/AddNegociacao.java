package br.ufjf.dcc.bolsa.controller;

import br.ufjf.dcc.bolsa.view.JanelaPrincipal;
import br.ufjf.dcc.bolsa.view.JanelaAddNegociacao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gleiph
 */
public class AddNegociacao implements ActionListener {

    private final JanelaPrincipal janelaPrincipal;

    public AddNegociacao(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JanelaAddNegociacao operacaoView = new JanelaAddNegociacao();
        operacaoView.desenha(janelaPrincipal);
        operacaoView.setVisible(true);
        
    }

}
