package br.ufjf.dcc.bolsa.view;

import br.ufjf.dcc.bolsa.Dados;
import br.ufjf.dcc.bolsa.model.Negociacao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gleip
 */
public class PainelNegociacoes extends JPanel {

    private final JanelaPrincipal frame;
    private final JTable jtNegociacoes;

    public PainelNegociacoes(JanelaPrincipal janelaPrincipal) {
        super();

        this.frame = janelaPrincipal;
        this.jtNegociacoes = new JTable();

        this.setLayout(new BorderLayout());

        Dimension d = new Dimension((int) (this.frame.getWidth() * 0.3d), this.frame.getHeight());
        this.setPreferredSize(d);

        this.add(new JScrollPane(this.jtNegociacoes), BorderLayout.CENTER);
    }

    public void atualiza() {

        String[] colunas = {"Nome", "Quantidade", "Preço Unitário", "Taxa de Negociação", "Taxa de Liquidação", "Total", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        if (Dados.getCarteiraAtiva() != null) {
            for (Negociacao negociacao : Dados.getCarteiraAtiva().getNegociacoes()) {
                Object[] linha = {negociacao.getTagAtivo(), negociacao.getQuantidade(), negociacao.getValorUnitario(),
                    negociacao.getTaxaNegociacao(), negociacao.getTaxaLiquidacao(), negociacao.getTotal(), negociacao.getTipo()};
                model.addRow(linha);
            }
        }

        jtNegociacoes.setModel(model);

    }

    void addNegociacao(String nome, int quantidade, double precoUnitario, double taxaNegociacao, double taxaLiquidacao, double total, String tipo) {
        DefaultTableModel model = (DefaultTableModel) this.jtNegociacoes.getModel();
        Object[] linha = {nome, quantidade, this.formataDouble(precoUnitario), this.formataDouble(taxaNegociacao),
            this.formataDouble(taxaLiquidacao), this.formataDouble(total), tipo};

        model.addRow(linha);
        jtNegociacoes.setModel(model);

    }

    private String formataDouble(double numero) {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        return df.format(numero);
    }

}
