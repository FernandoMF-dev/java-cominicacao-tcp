/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientetcp.entities;

import clientetcp.enums.ProdutoEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2020122760137
 */
public class Compra {
    private Long id;
    private List<ProdutoEnum> produtos = new ArrayList<>();

    // <editor-fold>

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProdutoEnum> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEnum> produtos) {
        this.produtos = produtos;
    }
    
    // </editor-fold>
}
