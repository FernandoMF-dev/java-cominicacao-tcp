package entities;

import enums.OperacaoEnum;
import enums.ProdutoEnum;
import java.io.Serializable;
import java.util.ArrayList;

public class Operacao implements Serializable {

    private OperacaoEnum operacao;

    private ArrayList<ProdutoEnum> novaCompra = new ArrayList<>();

    private ArrayList<Compra> comprasEfetuadas = new ArrayList();

    private String mensagem;

    public Operacao() {
    }

    public OperacaoEnum getOperacao() {
        return operacao;
    }

    public ArrayList<ProdutoEnum> getNovaCompra() {
        return novaCompra;
    }

    public ArrayList<Compra> getComprasEfetuadas() {
        return comprasEfetuadas;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setOperacao(OperacaoEnum operacao) {
        this.operacao = operacao;
    }

    public void setNovaCompra(ArrayList<ProdutoEnum> novaCompra) {
        this.novaCompra = novaCompra;
    }

    public void setComprasEfetuadas(ArrayList<Compra> comprasEfetuadas) {
        this.comprasEfetuadas = comprasEfetuadas;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
