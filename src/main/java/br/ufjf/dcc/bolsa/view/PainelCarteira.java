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
public class PainelCarteira extends JPanel{
    
    public static JPanel desenha(JFrame frame) {

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        
        
        Dimension d = new Dimension((int)(frame.getWidth()*0.3d), frame.getHeight());
        jp.setPreferredSize(d);
        
        JTable jtAtivo = new JTable();
        
        String[] colunas = {"Nome", "Quantidade", "Preço Unitário"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        jtAtivo.setModel(model);
        
        jp.add(new JScrollPane(jtAtivo), BorderLayout.CENTER);
        
        return jp;
    }
}
