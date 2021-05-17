/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.controller;

import br.ufjf.dcc.bolsa.Dados;
import br.ufjf.dcc.bolsa.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author gleip
 */
public class SelecionaCarteira implements ActionListener{

    private final JanelaPrincipal janelaPrincipal;

    public SelecionaCarteira(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() instanceof JMenuItem) {
            
            JMenuItem item = (JMenuItem) ae.getSource();
            String text = item.getText();
            Dados.setCarteiraAtiva(Dados.getCarteira(text));
            
            janelaPrincipal.atualizar();
        }
        
    }
    
}
