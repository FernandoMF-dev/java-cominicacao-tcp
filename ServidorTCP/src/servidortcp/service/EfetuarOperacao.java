package servidortcp.service;

import entities.CandidatoApriori;
import java.util.Objects;
import servidortcp.data.Banco;
import entities.Compra;
import entities.Operacao;
import enums.OperacaoEnum;
import java.util.List;
import java.util.stream.Collectors;

public class EfetuarOperacao {

    private Operacao operacao;
    private AlgoritimoApriori algoritimoApriori = new AlgoritimoApriori();

    public EfetuarOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    private String formatarRelatorio(List<CandidatoApriori> relatorio) {
        return relatorio.stream()
                .map(value -> String.format("%s >>> %s", value.getProdutos().get(0), value.getProdutos().get(1)))
                .collect(Collectors.joining("\n"));
    }

    private Operacao salvarCompra() {
        Operacao novaOperacao = new Operacao();
        Compra novaCompra = new Compra();
        novaCompra.setId(Banco.getIncrementoIdentificador());
        novaCompra.setProdutos(operacao.getNovaCompra());
        Banco.adicionarCompra(novaCompra);
        novaOperacao.setMensagem("Sucesso");
        return novaOperacao;
    }

    private Operacao retornarCompras() {
        Operacao novaOperacao = new Operacao();
        novaOperacao.setComprasEfetuadas(Banco.getResultadoCompras());
        novaOperacao.setMensagem("Sucesso");
        return novaOperacao;
    }

    private Operacao retornarApriori() {
        Operacao novaOperacao = new Operacao();
        List<CandidatoApriori> relatorio = algoritimoApriori.obterRelatorio();
        novaOperacao.setMensagem(formatarRelatorio(relatorio));
        return novaOperacao;
    }

    private Operacao verificarOperacao() {
        if (Objects.equals(operacao.getOperacao().getCodigoOperacao(), OperacaoEnum.SALVAR.getCodigoOperacao())) {
            return salvarCompra();
        }

        if (Objects.equals(operacao.getOperacao().getCodigoOperacao(), OperacaoEnum.ATUALIZAR.getCodigoOperacao())) {
            return retornarCompras();
        }

        return retornarApriori();
    }

    public Operacao realizarOperacao() {
        return verificarOperacao();
    }

}
