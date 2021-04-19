package br.ufjf.dcc.bolsa.model;

import java.time.LocalDate;

/**
 *
 * @author gleip
 */
public class Negociacao {
    
    private LocalDate data;
    private double valor;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
