package entities;

import enums.ProdutoEnum;
import java.io.Serializable;
import java.util.ArrayList;

public class Compra implements Serializable {

    private Long identificador;

    private ArrayList<ProdutoEnum> produtos = new ArrayList<>();

    public Compra() {
    }

    public Long getId() {
        return identificador;
    }

    public void setId(Long id) {
        this.identificador = id;
    }

    public ArrayList<ProdutoEnum> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ProdutoEnum> produtos) {
        this.produtos = produtos;
    }

}
