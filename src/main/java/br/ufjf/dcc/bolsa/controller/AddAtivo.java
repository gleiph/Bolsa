package br.ufjf.dcc.bolsa.controller;

import br.ufjf.dcc.bolsa.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gleiph
 */
public class AddAtivo implements ActionListener {

    private final JanelaPrincipal janelaPrincipal;

    public AddAtivo(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String tag = JOptionPane.showInputDialog("Digite a tag da ação que deseja adicionar:");
        if (tag != null) {
            try {
                janelaPrincipal.addAtivo(tag);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Selecione uma carteira!");
            }

        }

    }

}
