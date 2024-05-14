import java.util.Random;

public class mergeSort {
    private static int comparacoes = 0;
    private static int trocas = 0;

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
                    trocas++;
                    auxiliar[k] = v[j];
                    k++; j++;
                }
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

    public static int getComparacoes() {
        return comparacoes;
    }

    public static int getTrocas() {
        return trocas;
    }
}
