//STATUS = CONCLUÍDO
public class bubbleSort {
    static int comparacoes = 0;
    static int trocas = 0;
    public static void sort(int[] lista){
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

    public static int getComparacoes() {
        return comparacoes;
    }

    public static int getTrocas() {
        return trocas;
    }
}

