package br.ufjf.dcc.bolsa.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author gleip
 */
public class PainelNegociacoes extends JPanel {

    private final JFrame frame;
    private final JTable jtNegociacoes;

    public PainelNegociacoes(JFrame frame) {
        this.frame = frame;
        this.jtNegociacoes = new JTable();
    }
    
    public void desenha() {

        
        this.setLayout(new BorderLayout());

        Dimension d = new Dimension((int)(this.frame.getWidth()*0.3d), this.frame.getHeight());
        this.setPreferredSize(d);

        String[] colunas = {"Nome", "Quantidade", "Preço Unitário", "Taxas", "Total", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        jtNegociacoes.setModel(model);

        this.add(new JScrollPane(jtNegociacoes), BorderLayout.CENTER);

    }

    void addNegociacao(String nome, int quantidade, double precoUnitario, double taxas, double total, String tipo) {
        DefaultTableModel model = (DefaultTableModel) this.jtNegociacoes.getModel();
        Object[] linha = {nome, quantidade, precoUnitario, taxas, total, tipo};
        
        model.addRow(linha);
        jtNegociacoes.setModel(model);
        
    }

}
