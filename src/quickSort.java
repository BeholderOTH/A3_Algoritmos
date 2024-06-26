//STATUS = CONCLUÍDO.

public class quickSort {
    private static float comparacoes = 0;
    private static float trocas = 0;

    /*
    public static void sort(int e, int d, float[] a){
        float i;
        if (d > e){
            i = particao(e, d, a);
            sort(e, (int) (i - 1), a);
            sort((int) (i+1), d, a);
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
     */

    public static void sort(int e, int d, float[] a){
        while (e < d) {
            int i = particao(e, d, a);
            if (i - e < d - i) {
                sort(e, i - 1, a);
                e = i + 1; // Tail call optimization
            } else {
                sort(i + 1, d, a);
                d = i - 1; // Tail call optimization
            }
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
            } while (a[i] < pivo);
            do {
                j = j - 1;
                comparacoes++;
            } while (j >= e && a[j] > pivo);
            if (i < j) {
                aux = a[i];
                a[i] = a[j];
                a[j] = aux;
                trocas++;
            }
        } while (i < j);
        aux = a[i];
        a[i] = a[d];
        a[d] = aux;
        trocas++;
        return i;
    }

    public static float getComparacoes() {
        return comparacoes;
    }

    public static float getTrocas() {
        return trocas;
    }
}
