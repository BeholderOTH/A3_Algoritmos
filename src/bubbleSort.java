//STATUS = CONCLUÍDO
public class bubbleSort {
    static float comparacoes = 0;
    static float trocas = 0;
    public void sort(int[] lista){
        int iteracao, i, aux;

        for (iteracao = 0; iteracao < lista.length - 1; iteracao++) {
            for (i = 0; i < lista.length - 1 - iteracao; i++) {
                comparacoes++;
                if (lista[i] > lista[i + 1]) {
                    trocas++;
                    aux = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = aux;
                }
            }
        }
    }

    public static float getComparacoes() {
        return comparacoes;
    }

    public static float getTrocas() {
        return trocas;
    }
}

