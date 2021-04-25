/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.controller;

import br.ufjf.dcc.bolsa.view.JanelaAddNegociacao;
import br.ufjf.dcc.bolsa.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gleip
 */
public class RealizarNegociacao implements ActionListener {

    private final JanelaAddNegociacao janelaAddNegociacao;
    private final JanelaPrincipal janelaPrincipal;

    public RealizarNegociacao(JanelaAddNegociacao janelaAddNegociacao, JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
        this.janelaAddNegociacao = janelaAddNegociacao;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String nome = janelaAddNegociacao.getCbTag().getSelectedItem().toString();
        int quantidade = Integer.parseInt(janelaAddNegociacao.getTfQuantidade().getText());
        double precoUnitario = Double.parseDouble(janelaAddNegociacao.getTfPreco().getText());
        String tipo = janelaAddNegociacao.getCbTipo().getSelectedItem().toString();
        double taxas = 0;//TODO
        
        janelaPrincipal.addNegociacao(nome, quantidade, precoUnitario, taxas, quantidade*precoUnitario+taxas, tipo);
        
    }

}
