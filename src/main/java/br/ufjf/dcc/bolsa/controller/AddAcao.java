/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.controller;

import br.ufjf.dcc.bolsa.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gleiph
 */
public class AddAcao implements ActionListener {

    private final JanelaPrincipal janelaPrincipal;

    public AddAcao(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String tag = JOptionPane.showInputDialog("Digite a tag da ação que deseja adicionar:");
        if (tag != null) {
            try {
                janelaPrincipal.addAcao(tag);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ação já existe em carteira!");
            }

        }

    }

}
