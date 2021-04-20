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
public class PainelNegociacoes extends JPanel {

    public static PainelNegociacoes desenha(JFrame frame) {

        PainelNegociacoes jp = new PainelNegociacoes();
        jp.setLayout(new BorderLayout());

        Dimension d = new Dimension((int)(frame.getWidth()*0.3d), frame.getHeight());
        jp.setPreferredSize(d);
        
        JTable jtNegociacoes = new JTable();

        String[] colunas = {"Nome", "Quantidade", "Preço Unitário", "Taxas", "Total", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        jtNegociacoes.setModel(model);

        jp.add(new JScrollPane(jtNegociacoes), BorderLayout.CENTER);

        return jp;
    }

}
