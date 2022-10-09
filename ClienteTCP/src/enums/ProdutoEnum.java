package enums;

import java.io.Serializable;

public enum ProdutoEnum implements Serializable {

    PAO(1, "Pão"),
    LEITE(2, "Leite"),
    CAFE(3, "Café"),
    SUCO(4, "Suco"),
    BOLACHAS(5, "Bolachas"),
    QUEIJO(6, "Queijo"),
    PRESUNTO(7, "Presunto"),
    MANTEIGA(8, "Manteiga");

    private final Integer codigoProduto;

    private final String nomeProduto;

    ProdutoEnum(Integer codigoProduto, String nomeProduto) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

}