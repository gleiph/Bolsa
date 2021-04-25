/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author gleiph
 */
public class OperacaoView extends JFrame {

    private JList jlTag;
    private JTextField tfQuantidade;
    private JTextField tfPreco;
    private JTextField tfTipo;

    public OperacaoView() {
        super();
        int tamanhoTF = 15;
        this.jlTag = new JList();
        this.tfQuantidade = new JTextField(tamanhoTF);
        this.tfPreco = new JTextField(tamanhoTF);
        this.tfTipo = new JTextField(tamanhoTF);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void desenha() {
        this.setSize(new Dimension(400, 300));
        this.setLayout(new BorderLayout(20, 20));
        
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5, 2, 10, 10));

        jPanel.add(new JLabel());
        JLabel jlNome = new JLabel("Nome:");
        JLabel jlQuantidade = new JLabel("Quantidade:");
        JLabel jlPreco = new JLabel("Preço:");
        JLabel jlTipo = new JLabel("Tipo:");

        jPanel.add(jlNome);
        jPanel.add(jlTag);

        jPanel.add(jlQuantidade);
        jPanel.add(tfQuantidade);

        jPanel.add(jlPreco);
        jPanel.add(tfPreco);

        jPanel.add(jlTipo);
        jPanel.add(tfTipo);
        
        this.add(jPanel, BorderLayout.NORTH);
        
        JButton btnSalvar = new JButton("Salvar");
        
        this.add(btnSalvar, BorderLayout.SOUTH);
        

    }

    public JList getJlTag() {
        return jlTag;
    }

    public void setJlTag(JList jlTag) {
        this.jlTag = jlTag;
    }

    public JTextField getTfQuantidade() {
        return tfQuantidade;
    }

    public void setTfQuantidade(JTextField tfQuantidade) {
        this.tfQuantidade = tfQuantidade;
    }

    public JTextField getTfPreco() {
        return tfPreco;
    }

    public void setTfPreco(JTextField tfPreco) {
        this.tfPreco = tfPreco;
    }

    public JTextField getTfTipo() {
        return tfTipo;
    }

    public void setTfTipo(JTextField tfTipo) {
        this.tfTipo = tfTipo;
    }

    

}
