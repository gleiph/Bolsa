package br.ufjf.dcc.bolsa.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;

/**
 *
 * @author gleip
 */
public abstract class Negociacao {

    private LocalDate data;
    private int quantidade;
    private double valorUnitario;
    private Ativo ativo;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public double getTaxaLiquidacao() {
        return this.getQuantidade() * this.getValorUnitario() * 0.0250 / 100;
    }

    public double getTaxaNegociacao() {
        return this.getQuantidade() * this.getValorUnitario() * 0.0050 / 100;
    }

    public abstract double getTotal();

    public abstract void atualiza(int quantidade, double precoUnitario);

}
