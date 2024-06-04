//STATUS = CONCLUÍDO, PENDENTE PARA QUESTÕES SOBRE A FUNÇÃO TROCA

public class selectionSort {
    static float comparacoes = 0;
    static float trocas = 0;
    public void sort (int[] lista){
            int min;

            for (int i = 0; i < lista.length - 1; i++) {
                min = i;

                for (int j = i+1; j < lista.length; j++) {
                    comparacoes++;
                    if(lista[j] < lista[min]){
                        min = j;
                    }
                }
                troca(i, min, lista);
                trocas++;
            }
        }

        private static void troca(int i, int j, int[] lista){
            int temp = lista[i];
            lista[i] = lista[j];
            lista[j] = temp;
        }

    public static float getComparacoes() {
        return comparacoes;
    }

    public static float getTrocas() {
        return trocas;
    }
}
