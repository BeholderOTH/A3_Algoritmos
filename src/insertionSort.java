//STATUS = CONCLUÍDO

public class insertionSort {
    static float comparacoes = 0;
    static float trocas = 0;
    public void sort (int[] lista) {
        int primeiro = 0;
        int ultimo = (lista.length - 1);

        for(int i = (primeiro + 1); i <= ultimo; i++){
            int t = lista[i];
            int j = i - 1;
            int count = 0;

            comparacoes++;
            while((j >= 0) && (lista[j] > t)) {
                if(count >= 1) {
                    comparacoes++;
                }
                count++;
                lista[j + 1] = lista[j];
                j--;
                trocas++;
                //System.out.println(Arrays.toString(lista));
            }

            count = 0;
            lista[j + 1] = t;
        }
    }

    public static float getComparacoes() {
        return comparacoes;
    }

    public static float getTrocas() {
        return trocas;
    }
}
