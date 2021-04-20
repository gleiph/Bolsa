/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.view;

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
    private final JFrame frame;

    public PainelCarteira(JFrame jf) {
        super();
        this.frame = jf;

        this.setLayout(new BorderLayout());

        Dimension d = new Dimension((int) (frame.getWidth() * 0.3d), frame.getHeight());
        this.setPreferredSize(d);

        jtAtivo = new JTable();

        String[] colunas = {"Nome", "Quantidade", "Preço Unitário"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        jtAtivo.setModel(model);

        this.add(new JScrollPane(jtAtivo), BorderLayout.CENTER);
    }

    public void addAcao(String tag) throws Exception {

        DefaultTableModel model = (DefaultTableModel) this.jtAtivo.getModel();
        String[] linha = {tag, "0", "0"};

        for (int i = 0; i < model.getRowCount(); i++) {
            String nome = (String) model.getValueAt(i, 0);
            if(nome.equals(tag))
                throw new Exception("Ação já existe!");
        }

        model.addRow(linha);
        this.jtAtivo.setModel(model);

        this.repaint();
    }
}
