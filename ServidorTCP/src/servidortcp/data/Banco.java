package servidortcp.data;

import java.util.ArrayList;
import entities.Compra;

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

}
