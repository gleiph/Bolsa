/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.bolsa.controller;

import br.ufjf.dcc.bolsa.Dados;
import br.ufjf.dcc.bolsa.model.Carteira;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gleip
 */
public class AddCarteira implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        String carteira = JOptionPane.showInputDialog("Digite o nome da carteira: ");
        
        Dados.getCarteiras().add(new Carteira(carteira));

        System.out.println("Carteiras cadastradas:");
        for (Carteira c : Dados.getCarteiras()) {
            System.out.println("\t"+c.getNome());
        }

    }
    
}
