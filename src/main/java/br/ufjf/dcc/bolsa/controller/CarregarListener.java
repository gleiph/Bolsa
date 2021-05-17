/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.controller;

import br.ufjf.dcc.bolsa.Dados;
import br.ufjf.dcc.bolsa.model.Carteira;
import br.ufjf.dcc.bolsa.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author gleip
 */
public class CarregarListener implements ChangeListener {

    private final JanelaPrincipal janelaPrincipal;

    public CarregarListener(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
    
    @Override
    public void stateChanged(ChangeEvent ce) {
        if(ce.getSource() instanceof JMenu){
            
            JMenu menu = (JMenu) ce.getSource();
            
            menu.removeAll();
            JMenuItem submenu = null;
                    
            for (Carteira carteira : Dados.getCarteiras()) {
                submenu = new JMenuItem(carteira.getNome());
                submenu.addActionListener(new SelecionaCarteira(janelaPrincipal));
                menu.add(submenu);
                        
            }
            
        }
    }

}
