import java.util.Arrays;

public class quickSort {
    private static int comparacoes = 0;
    private static int trocas = 0;
    public static void sort(int e, int d, float[] a){
        int i;
        if (d > e){
            i = particao(e, d, a);
            sort(e, i - 1, a);
            sort(i+1, d, a);
        }
    }

    private static int particao(int e, int d, float[] a){
        float pivo, aux;
        int i, j;
        pivo = a[d];
        i = e - 1;
        j = d;
        do {
            do {
                i = i + 1;
                comparacoes++;
            } while ((a[i] < pivo) && (i < d));
            do {
                j = j - 1;
                comparacoes++;
            } while ((a[j] > pivo) && (j > 0));
            aux = a[i];
            a[i] = a[j];
            a[j] = aux;
            trocas++;
        } while (j > i);
        a[j] = a[i];
        a[i] = a[d];
        a[d] = aux;
        trocas++;
        return i;
    }

    public static int getComparacoes() {
        return comparacoes;
    }

    public static int getTrocas() {
        return trocas;
    }
}
