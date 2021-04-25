/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.view;

import br.ufjf.dcc.bolsa.Dados;
import br.ufjf.dcc.bolsa.model.Ativo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gleip
 */
public class PainelCarteira extends JPanel {

    private JTable jtAtivo;
    private final JanelaPrincipal janelaPrincipal;

    public PainelCarteira(JanelaPrincipal janelaPrincipal) {
        super();
        
        this.janelaPrincipal = janelaPrincipal;

        this.setLayout(new BorderLayout());

        Dimension d = new Dimension((int) (janelaPrincipal.getWidth() * 0.3d), janelaPrincipal.getHeight());
        this.setPreferredSize(d);

        jtAtivo = new JTable();


        this.add(new JScrollPane(jtAtivo), BorderLayout.CENTER);
    }

    public void atualizar() {

        String[] colunas = {"Nome", "Quantidade", "Preço Unitário"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Ativo ativo : Dados.getAtivos()) {
            Object[] linha = {ativo.getTag(), ativo.getQuantidade(), ativo.getPrecoMedio()};
            model.addRow(linha);

        }

        this.jtAtivo.setModel(model);

        this.repaint();
    }
}
