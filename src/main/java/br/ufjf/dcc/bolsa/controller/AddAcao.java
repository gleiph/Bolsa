/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.controller;

import br.ufjf.dcc.bolsa.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gleip
 */
public class AddAcao implements ActionListener{

    private JanelaPrincipal janelaPrincipal;

    public AddAcao(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        janelaPrincipal.addAcao("PETR4");
    }
    
}
