/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.controller;

import br.ufjf.dcc.bolsa.Dados;
import br.ufjf.dcc.bolsa.model.Ativo;
import br.ufjf.dcc.bolsa.model.Compra;
import br.ufjf.dcc.bolsa.model.Negociacao;
import br.ufjf.dcc.bolsa.model.Venda;
import br.ufjf.dcc.bolsa.view.JanelaAddNegociacao;
import br.ufjf.dcc.bolsa.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

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

        String tag = janelaAddNegociacao.getCbTag().getSelectedItem().toString();
        int quantidade = Integer.parseInt(janelaAddNegociacao.getTfQuantidade().getText());
        double precoUnitario = Double.parseDouble(janelaAddNegociacao.getTfPreco().getText());
        String tipo = janelaAddNegociacao.getCbTipo().getSelectedItem().toString();
        double taxas = 0;//TODO
        Negociacao negociacao = null;
        
        if (tipo.equals("Compra")) {
        
            negociacao = new Compra();
            negociacao.setData(LocalDate.now());
            negociacao.setQuantidade(quantidade);
            negociacao.setValorUnitario(precoUnitario);
            negociacao.setAtivo(Dados.getAtivo(tag));
            negociacao.atualiza(quantidade, precoUnitario);
            
            Dados.getNegociacoes().add(negociacao);
        
        }else if(tipo.equals("Venda")){
        
            negociacao = new Venda();
            negociacao.setData(LocalDate.now());
            negociacao.setQuantidade(quantidade);
            negociacao.setValorUnitario(precoUnitario);
            
            Ativo ativo = Dados.getAtivo(tag);
            
            negociacao.setAtivo(ativo);
            negociacao.atualiza(quantidade, precoUnitario);

            Dados.getNegociacoes().add(negociacao);
            
        }else{
            System.out.println("Negociação não suportada...");
        }
            
        
        janelaPrincipal.addNegociacao(tag, quantidade, precoUnitario, taxas, quantidade*precoUnitario+taxas, tipo);
        
        
        
    }

}
