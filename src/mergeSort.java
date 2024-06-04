//STATUS = INDECISO.

public class mergeSort {
    private static float comparacoes = 0;
    private static float trocas = 0;

        public static void sort(int inicio, int tamanho, int[] v) {
            if (inicio < tamanho - 1) {
                int meio = (inicio + tamanho) / 2;
                sort(inicio, meio, v);
                sort(meio, tamanho, v);
                intercalar(inicio, meio, tamanho, v);
            }
        }

        private static void intercalar(int inicio, int meio, int tamanho, int[] v) {
            int i, j, k;
            int[] auxiliar = new int[tamanho - inicio];
            i = inicio;
            j = meio;
            k = 0;

            while (i < meio && j < tamanho) {
                comparacoes++;
                if (v[i] <= v[j]) {
                    auxiliar[k] = v[i];
                    k++; i++;
                } else {
                    auxiliar[k] = v[j];
                    k++; j++;
                }
                trocas++;
            }
            while (i < meio) {
                comparacoes++;
                auxiliar[k] = v[i];
                k++; i++;
            }
            while (j < tamanho) {
                comparacoes++;
                auxiliar[k] = v[j];
                k++; j++;
            }
            for (i = inicio; i < tamanho; i++) {
                v[i] = auxiliar[i - inicio];
            }
        }

    public static float getComparacoes() {
        return comparacoes;
    }

    public static float getTrocas() {
        return trocas;
    }
}
