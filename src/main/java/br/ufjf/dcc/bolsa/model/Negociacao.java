package br.ufjf.dcc.bolsa.model;

import java.time.LocalDate;

/**
 *
 * @author gleiph
 */
public abstract class Negociacao {

    private LocalDate data;
    private int quantidade;
    private double valorUnitario;
    private String tagAtivo;


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

    public String getTagAtivo() {
        return tagAtivo;
    }

    public void setTagAtivo(String tagAtivo) {
        this.tagAtivo = tagAtivo;
    }

    public double getTaxaLiquidacao() {
        return this.getQuantidade() * this.getValorUnitario() * 0.0250 / 100;
    }

    public double getTaxaNegociacao() {
        return this.getQuantidade() * this.getValorUnitario() * 0.0050 / 100;
    }

    public String getTipo() {
        if (this instanceof Venda) {
            return Constantes.VENDA;
        } else if (this instanceof Compra) {
            return Constantes.COMPRA;
        } else{
            throw new RuntimeException("Operação não suportada");
        }
    }

    public abstract double getTotal();

    public abstract void atualiza(int quantidade, double precoUnitario);

}
