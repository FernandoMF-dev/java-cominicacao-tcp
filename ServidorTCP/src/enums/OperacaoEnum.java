package enums;

import java.io.Serializable;

public enum OperacaoEnum implements Serializable{

    SALVAR(1, "Salvar"),
    ATUALIZAR(2, "Atualizar"),
    APRIORI(3, "Apriori");

    private final Integer codigoOperacao;

    private final String nomeOperacao;

    OperacaoEnum(Integer codigoOperacao, String nomeOperacao) {
        this.codigoOperacao = codigoOperacao;
        this.nomeOperacao = nomeOperacao;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Integer getCodigoOperacao() {
        return codigoOperacao;
    }

    public String getNomeOperacao() {
        return nomeOperacao;
    }
    // </editor-fold>
}
