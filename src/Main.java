import java.util.Arrays;
import java.util.Random;

/*
Elabore um relatório comparando os seguintes algoritmos de ordenação: bubble sort,
selection sort, insertion sort, quick sort e merge sort, explicando o funcionamento de
cada um deles.
O relatório deve verificar o comportamento dos algoritmos em relação ao tempo,
movimentações de trocas e comparações.
Teste 3 ordens de listas: ordenada em ordem crescente, ordenada em ordem
decrescente e desordenada com números aleatórios. As listas podem ter duplicidade ou
não.
Para cada um dos 3 tipos de ordenações você deve testar vetores de 5 tamanhos
diferentes: cem, mil, dez mil, cem mil e um milhão.
 */

public class Main {
    public static void main(String[] args) {
        //Definição e inicialização dos Arrays
        int[] tamanhoArrays = {100, 1000, 10000, 100000, 1000000};
        int[] listaUsada = new int[tamanhoArrays[4]];

        //Função responsável por gerar números aleatórios
        Random classeAleatoria = new Random();

        //Preenche os Arrays com números positivos inteiros aleatórios
        for(int i = 0; i < listaUsada.length; i++){
            listaUsada[i] = classeAleatoria.nextInt(Integer.MAX_VALUE);
        }

        //Chamada de função para organizar a lista em ordem crescente
        Arrays.sort(listaUsada);

        //Chamada da função para inversão de lista
        listaUsada = inversaoDeLista(listaUsada);

        //Definição de listas copiadas para cada variedade de algoritmo de ordenação
        //int[][] listasCopiadas;
        int[] listaC2 = Arrays.copyOf(listaUsada, listaUsada.length);
        int[] listaC3 = Arrays.copyOf(listaUsada, listaUsada.length);
        float[] listaC4 = new float[listaUsada.length];
        int[] listaC5 = Arrays.copyOf(listaUsada, listaUsada.length);

        // Preencher a lista C4 (QuickSort) Float com os valores das listas originais convertidos para Float
        for (int i = 0; i < listaC4.length; i++) {
            listaC4[i] = (float) listaUsada[i];
        }

        //Inicialização de método de ordenação
        bubbleSort bubble = new bubbleSort();
        selectionSort selection = new selectionSort();
        quickSort quick = new quickSort();
        insertionSort insertion = new insertionSort();
        mergeSort merge = new mergeSort();

        //BubbleSort
        long tempoBubble = medirTempoDeOrdenacao(bubble::sort, listaUsada);
        //SelectionSort
        long tempoSelection = medirTempoDeOrdenacao(selection::sort, listaC2);
        //InsertionSort
        long tempoInsertion = medirTempoDeOrdenacao(insertion::sort, listaC3);
        //MergeSort
        long tempoMerge = medirTempoDeOrdenacao((array) -> merge.sort(0, array.length, array), listaC5);

        //QuickSort
        //Começo da medição de tempo para ordenar as listas
        long comecoTempoQuick = System.nanoTime();

        //Execução do método de ordenação com respectivas quantidades de elementos
        quick.sort(0, listaC4.length - 1, listaC4);

        //Fim da medição de tempo para ordenar as listas
        long fimTempoQuick = System.nanoTime();
        long tempoQuick = fimTempoQuick - comecoTempoQuick;

        //Exibição dos resultados para análise
        System.out.println("Número de comparações (Bubble):" + bubble.getComparacoes());
        System.out.println("Número de comparações (Selection):" + selection.getComparacoes());
        System.out.println("Número de comparações (Insertion):" + insertion.getComparacoes());
        System.out.println("Número de comparações (Quick):" + quick.getComparacoes());
        System.out.println("Número de comparações (Merge):" + merge.getComparacoes());
        System.out.println("Número de trocas (Bubble):" + bubble.getTrocas());
        System.out.println("Número de trocas (Selection):" + selection.getTrocas());
        System.out.println("Número de trocas (Insertion):" + insertion.getTrocas());
        System.out.println("Número de trocas (Quick):" + quick.getTrocas());
        System.out.println("Número de trocas (Merge):" + merge.getTrocas());
        System.out.println("Tempo de execução (Bubble): " + tempoBubble);
        System.out.println("Tempo de execução (Selection): " + tempoSelection);
        System.out.println("Tempo de execução (Insertion): " + tempoInsertion);
        System.out.println("Tempo de execução (Quick): " + tempoQuick);
        System.out.println("Tempo de execução (Merge): " + tempoMerge);
    }

    //Função para inverter o Arranjo selecionado
    public static int[] inversaoDeLista(int[] lista){
        for (int i = 0; i < lista.length / 2; i++) {
            int temp = lista[i];
            lista[i] = lista[lista.length - i - 1];
            lista[lista.length - i - 1] = temp;
        }
        return lista;
    }

    //Interface para manejar os métodos genéricos "Sort" em cada classe
    interface sortGenerico {
        void sort (int[] lista);
    }

    //Função universal para executar e cronometrar o tempo dos métodos de ordenação de Arranjos
    public static long medirTempoDeOrdenacao (sortGenerico alg, int[] lista){
        long comecoTempo = System.nanoTime();
        alg.sort(lista);
        long fimTempo = System.nanoTime();
        long tempoTotal = fimTempo - comecoTempo;
        return tempoTotal;
    }
}