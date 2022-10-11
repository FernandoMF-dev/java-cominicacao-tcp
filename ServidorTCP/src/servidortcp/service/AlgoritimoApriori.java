package servidortcp.service;

import entities.CandidatoApriori;
import enums.ProdutoEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import servidortcp.data.Banco;

public class AlgoritimoApriori {

    private static final double APRIORI_FREQUENCIA_MIN = 50.0;
    private static final double APRIORI_CONFIABILIDADE_MIN = 75.0;

    public List<CandidatoApriori> obterRelatorio() {
        List<CandidatoApriori> primeiroGrau = obterCanditadosPrimeiroGrau();
        primeiroGrau = filtrarFrequencia(primeiroGrau);
        List<CandidatoApriori> segundoGrau = obterCanditadosSegundoGrau(primeiroGrau);
        segundoGrau = filtrarFrequencia(segundoGrau);
        List<CandidatoApriori> relatorio = calcularConfiabilidadeCandidatos(segundoGrau);
        return filtrarConfiabilidade(relatorio);
    }

    private List<CandidatoApriori> obterCanditadosPrimeiroGrau() {
        List<CandidatoApriori> candidatos = new ArrayList<>();

        for (ProdutoEnum produto : ProdutoEnum.values()) {
            candidatos.add(obterCandidato(produto));
        }

        return candidatos;
    }

    private List<CandidatoApriori> obterCanditadosSegundoGrau(List<CandidatoApriori> primeiroGrau) {
        List<CandidatoApriori> segundoGrau = new ArrayList<>();
        List<ProdutoEnum> produtos = primeiroGrau.stream()
                .map(value -> value.getProdutos().get(0))
                .collect(Collectors.toList());

        for (ProdutoEnum p1 : produtos.toArray(ProdutoEnum[]::new)) {
            for (ProdutoEnum p2 : produtos.toArray(ProdutoEnum[]::new)) {
                if (!p1.equals(p2)) {
                    segundoGrau.add(obterCandidato(p1, p2));
                }
            }
        }

        return segundoGrau;
    }
    
    private List<CandidatoApriori> calcularConfiabilidadeCandidatos(List<CandidatoApriori> candidatos) {
        List<CandidatoApriori> formulario = new ArrayList<>();

        candidatos.forEach(value -> {
            ArrayList<ProdutoEnum> produtos = value.getProdutos();
            formulario.add(calcularConfiabilidade(value, produtos.get(0), produtos.get(1)));
        });

        return formulario;
    }

    private CandidatoApriori obterCandidato(ProdutoEnum... produtos) {
        double compras = (double) Banco.filtrarPorProdutos(produtos).size();
        double total = (double) Banco.getResultadoCompras().size();
        double frequencia = compras / total * 100;

        return new CandidatoApriori(frequencia, produtos);
    }

    private CandidatoApriori calcularConfiabilidade(CandidatoApriori candidato, ProdutoEnum... produtos) {
        double compras = (double) Banco.filtrarPorProdutos(produtos).size();
        double total = (double) Banco.filtrarPorProdutos(produtos[0]).size();

        return new CandidatoApriori(candidato.getFrequencia(), compras / total * 100, produtos);
    }

    private List<CandidatoApriori> filtrarFrequencia(List<CandidatoApriori> candidatos) {
        candidatos.removeIf(value -> value.getFrequencia() < APRIORI_FREQUENCIA_MIN);
        return candidatos;
    }

    private List<CandidatoApriori> filtrarConfiabilidade(List<CandidatoApriori> candidatos) {
        candidatos.removeIf(value -> value.getConfiabilidade() < APRIORI_CONFIABILIDADE_MIN);
        return candidatos;
    }

}
