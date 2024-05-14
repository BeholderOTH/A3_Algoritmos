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
        //Arrays
        int[] listaTeste = {13, 8, 10, 5, 100, 15, 1};
        int[] listaTesteDois = {13, 8, 10, 5, 100, 15, 1};
        float[] listaTesteTres = {13, 8, 10, 5, 100, 15, 1};
        int[] listaCemElementos = new int[100];
        float[] listaTesteQuick = new float[10];
        int[] listaMilElementos = new int[1000];
        int[] listaDezMilElementos = new int[10000];
        int[] listaCemMilElementos = new int[100000];
        int[] listaMilhaoElementos = new int[1000000];

        //Função responsável por gerar números aleatórios
        Random classeAleatoria = new Random();

        for(int i = 0; i < listaTesteQuick.length; i++){
            listaTesteQuick[i] = classeAleatoria.nextFloat(Float.MAX_VALUE);
        }

        //Preenche os Arrays com números positivos inteiros aleatórios
        for(int i = 0; i < listaCemElementos.length; i++){
            listaCemElementos[i] = classeAleatoria.nextInt(Integer.MAX_VALUE);
        }

        //Chamada de função para organizar a lista em ordem crescente
        Arrays.sort(listaCemElementos);

        //Função para inversão de ordem numérica

        /*
        for (int i = 0; i < listaCemElementos.length / 2; i++) {
            int temp = listaCemElementos[i];
            listaCemElementos[i] = listaCemElementos[listaCemElementos.length - i - 1];
            listaCemElementos[listaCemElementos.length - i - 1] = temp;
        }
        */

        //Definição de listas copiadas para cada variedade de algoritmo de ordenação
        int[] listaCemElementos2 = Arrays.copyOf(listaCemElementos, listaCemElementos.length);
        int[] listaCemElementos3 = Arrays.copyOf(listaCemElementos, listaCemElementos.length);
        float[] listaCemElementos4 = new float[listaCemElementos.length];
        int[] listaCemElementos5 = Arrays.copyOf(listaCemElementos, listaCemElementos.length);

        // Preencher as listas Float com os valores das listas originais convertidos para Float
        for (int i = 0; i < listaCemElementos.length; i++) {
            listaCemElementos4[i] = (float) listaCemElementos[i];
        }

        //Inicialização de método de ordenação
        bubbleSort bubble = new bubbleSort();
        selectionSort selection = new selectionSort();
        quickSort quick = new quickSort();
        insertionSort insertion = new insertionSort();
        mergeSort merge = new mergeSort();

        //Teste do funcionamento do método de ordenação
        //quick.sort(0, listaCemElementos4.length - 1, listaCemElementos4);

        //BUBBLE SORT

        //Começo da medição de tempo para ordenar as listas
        long comecoTempoBubble = System.nanoTime();

        //Execução do método de ordenação com respectivas quantidades de elementos
        bubble.sort(listaCemElementos);

        //Fim da medição de tempo para ordenar as listas
        long fimTempoBubble = System.nanoTime();
        long tempoDeExecucaoBubble = fimTempoBubble - comecoTempoBubble;

        //SELECTION SORT

        //Começo da medição de tempo para ordenar as listas
        long comecoTempoSelection = System.nanoTime();

        //Execução do método de ordenação com respectivas quantidades de elementos
        selection.sort(listaCemElementos2);

        //Fim da medição de tempo para ordenar as listas
        long fimTempoSelection = System.nanoTime();
        long tempoDeExecucaoSelection = fimTempoSelection - comecoTempoSelection;

        //INSERTION SORT

        //Começo da medição de tempo para ordenar as listas
        long comecoTempoInsertion = System.nanoTime();

        //Execução do método de ordenação com respectivas quantidades de elementos
        insertion.sort(listaCemElementos3);

        //Fim da medição de tempo para ordenar as listas
        long fimTempoInsertion = System.nanoTime();
        long tempoDeExecucaoInsertion = fimTempoInsertion - comecoTempoInsertion;

        //QUICK SORT

        //Começo da medição de tempo para ordenar as listas
        long comecoTempoQuick = System.nanoTime();

        //Execução do método de ordenação com respectivas quantidades de elementos
        //quick.sort(0, listaCemElementos4.length - 1, listaCemElementos4);
        quick.sort(0, listaTesteQuick.length - 1, listaTesteQuick);

        //Fim da medição de tempo para ordenar as listas
        long fimTempoQuick = System.nanoTime();
        long tempoDeExecucaoQuick = fimTempoQuick - comecoTempoQuick;

        //MERGE SORT

        //Começo da medição de tempo para ordenar as listas
        long comecoTempoMerge = System.nanoTime();

        //Execução do método de ordenação com respectivas quantidades de elementos
        merge.sort(0, listaCemElementos5.length, listaCemElementos5);

        //Fim da medição de tempo para ordenar as listas
        long fimTempoMerge = System.nanoTime();
        long tempoDeExecucaoMerge = fimTempoMerge - comecoTempoMerge;

        //Exibição dos resultados para análise
        //System.out.println("BubbleSort:" + Arrays.toString(listaTeste) + "\n" + Arrays.toString(listaCemElementos));
        System.out.println("Número de comparações (Bubble):" + bubble.getComparacoes());
        System.out.println("Número de trocas (Bubble):" + bubble.getTrocas());
        System.out.println("Número de comparações (Selection):" + selection.getComparacoes());
        System.out.println("Número de trocas (Selection):" + selection.getTrocas());
        System.out.println("Número de comparações (Insertion):" + insertion.getComparacoes());
        System.out.println("Número de trocas (Insertion):" + insertion.getTrocas());
        System.out.println("Número de comparações (Quick):" + quick.getComparacoes());
        System.out.println("Número de trocas (Quick):" + quick.getTrocas());
        System.out.println("Número de comparações (Merge):" + merge.getComparacoes());
        System.out.println("Número de trocas (Merge):" + merge.getTrocas());
        System.out.println("Tempo de execução (Bubble): " + tempoDeExecucaoBubble + "\n" + "(Selection): " + tempoDeExecucaoSelection
        + "\n" + "(Insertion): " + tempoDeExecucaoInsertion + "\n" + "(Quick): " + tempoDeExecucaoQuick
        + "\n" + "(Merge): " + tempoDeExecucaoMerge);
    }
}