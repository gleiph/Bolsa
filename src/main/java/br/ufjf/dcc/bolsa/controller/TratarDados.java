/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.controller;

import br.ufjf.dcc.bolsa.Dados;
import br.ufjf.dcc.bolsa.view.JanelaPrincipal;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author gleip
 */
public class TratarDados implements WindowListener {

    private final JanelaPrincipal janelaPrincipal;

    public TratarDados(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
    
    
    
    @Override
    public void windowOpened(WindowEvent we) {
        Dados.recuperar();
        janelaPrincipal.atualizar();
    }

    @Override
    public void windowClosing(WindowEvent we) {
        Dados.salvar();
    }

    @Override
    public void windowClosed(WindowEvent we) {
        System.out.println("windowClosed");
    }

    @Override
    public void windowIconified(WindowEvent we) {
        System.out.println("windowIconified");
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        System.out.println("windowDeiconified");
    }

    @Override
    public void windowActivated(WindowEvent we) {
        System.out.println("windowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        System.out.println("windowDeactivated");
    }

}
