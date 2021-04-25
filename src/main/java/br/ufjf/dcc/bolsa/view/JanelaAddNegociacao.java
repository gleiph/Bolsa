/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.view;

import br.ufjf.dcc.bolsa.model.Ativo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author gleiph
 */
public class JanelaAddNegociacao extends JFrame {

    private JComboBox cbTag;
    private JTextField tfQuantidade;
    private JTextField tfPreco;
    private JComboBox cbTipo;

    public JanelaAddNegociacao() {
        super();
        int tamanhoTF = 15;
        this.cbTag = new JComboBox();
        this.tfQuantidade = new JTextField(tamanhoTF);
        this.tfPreco = new JTextField(tamanhoTF);
        this.cbTipo = new JComboBox();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void desenha(JanelaPrincipal jp) {
        this.setSize(new Dimension(400, 300));
        this.setLayout(new BorderLayout(20, 20));

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5, 2, 10, 10));

        jPanel.add(new JLabel());
        jPanel.add(new JLabel());

        JLabel jlNome = new JLabel("Nome:");
        JLabel jlQuantidade = new JLabel("Quantidade:");
        JLabel jlPreco = new JLabel("Preço:");
        JLabel jlTipo = new JLabel("Tipo:");

        DefaultComboBoxModel ativoModel = new DefaultComboBoxModel();

        for (Ativo ativo : jp.getAtivos()) {
            ativoModel.addElement(ativo);
        }

        this.cbTag.setModel(ativoModel);

        jPanel.add(jlNome);
        jPanel.add(cbTag);

        jPanel.add(jlQuantidade);
        jPanel.add(tfQuantidade);

        jPanel.add(jlPreco);
        jPanel.add(tfPreco);

        DefaultComboBoxModel tipoModel = new DefaultComboBoxModel();
        tipoModel.addElement("Compra");
        tipoModel.addElement("Venda");
        cbTipo.setModel(tipoModel);
        
        
        jPanel.add(jlTipo);
        jPanel.add(cbTipo);

        this.add(jPanel, BorderLayout.NORTH);

        JButton btnSalvar = new JButton("Salvar");

        this.add(btnSalvar, BorderLayout.SOUTH);

    }

    public JComboBox getCbTag() {
        return cbTag;
    }

    public void setCbTag(JComboBox cbTag) {
        this.cbTag = cbTag;
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

    public JComboBox getCbTipo() {
        return cbTipo;
    }

    public void setCbTipo(JComboBox cbTipo) {
        this.cbTipo = cbTipo;
    }

}
