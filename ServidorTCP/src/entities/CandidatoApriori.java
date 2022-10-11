package entities;

import enums.ProdutoEnum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CandidatoApriori implements Serializable {

	private ArrayList<ProdutoEnum> produtos = new ArrayList<>();
	private double frequencia = 0.0;
	private double confiabilidade = 0.0;

	public CandidatoApriori(double frequencia, ProdutoEnum... produtos) {
		this.produtos = new ArrayList<>(List.of(produtos));
		this.frequencia = frequencia;
	}

	public CandidatoApriori(double frequencia, double confiabilidade, ProdutoEnum... produtos) {
		this.produtos = new ArrayList<>(List.of(produtos));
		this.frequencia = frequencia;
		this.confiabilidade = confiabilidade;
	}

	// <editor-fold defaultstate="collapsed" desc="Getters & Setters">
	public ArrayList<ProdutoEnum> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<ProdutoEnum> produtos) {
		this.produtos = produtos;
	}

	public double getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Double frequencia) {
		this.frequencia = frequencia;
	}

	public double getConfiabilidade() {
		return confiabilidade;
	}

	public void setConfiabilidade(Double confiabilidade) {
		this.confiabilidade = confiabilidade;
	}
	// </editor-fold>
}
