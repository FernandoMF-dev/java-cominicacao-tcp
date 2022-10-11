package servidortcp.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Compra;
import enums.ProdutoEnum;

public class Banco {

    private static Long incrementoIdentificador = 1L;

    private static ArrayList<Compra> resultadoCompras = new ArrayList<>();

    public static void adicionarCompra(Compra compra) {
        resultadoCompras.add(compra);
        incrementoIdentificador = incrementoIdentificador + 1L;
    }

    public static Long getIncrementoIdentificador() {
        return incrementoIdentificador;
    }

    public static ArrayList<Compra> getResultadoCompras() {
        return resultadoCompras;
    }

    public static ArrayList<Compra> filtrarPorProdutos(ProdutoEnum... produtos) {
        List<ProdutoEnum> prods = List.of(produtos);
        return new ArrayList<>(resultadoCompras.stream()
                .filter(compra -> compra.getProdutos().containsAll(prods))
                .collect(Collectors.toList()));
    }

}
