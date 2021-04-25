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

    private final JFrame frame;

    public PainelNegociacoes(JFrame frame) {
        this.frame = frame;
    }
    
    public void desenha() {

        
        this.setLayout(new BorderLayout());

        Dimension d = new Dimension((int)(this.frame.getWidth()*0.3d), this.frame.getHeight());
        this.setPreferredSize(d);
        
        JTable jtNegociacoes = new JTable();

        String[] colunas = {"Nome", "Quantidade", "Preço Unitário", "Taxas", "Total", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        jtNegociacoes.setModel(model);

        this.add(new JScrollPane(jtNegociacoes), BorderLayout.CENTER);

    }

}
