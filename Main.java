public class Main {
    public static void main(String[] args) {
        String[] arquivos = {
            "aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv",
            "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
            "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"
        };

        int[] tamanhos = {
            100, 1000, 10000,
            100, 1000, 10000,
            100, 1000, 10000
        };

        for (int i = 0; i < arquivos.length; i++) {
            String nomeArquivo = arquivos[i];
            int tam = tamanhos[i];

            int[] dadosOriginais = LeitorCSV.lerArquivo(nomeArquivo, tam);

            if (dadosOriginais == null) {
                System.out.println(" Nao foi possivel testar o arquivo: " + nomeArquivo + "\n");
                continue;
            }

            System.out.println("---------------------------------------------------------");
            System.out.println("Arquivo: " + nomeArquivo + " | Elementos: " + tam);
            System.out.println("---------------------------------------------------------");

            int[] dadosBubble = clonarVetorManual(dadosOriginais);
            long incBubble = System.nanoTime();
            Ordenacao.bubbleSort(dadosBubble);
            long fimBubble = System.nanoTime();
            long tBubble = fimBubble - incBubble;
            
            int[] dadosInsertion = clonarVetorManual(dadosOriginais);
            long incInsertion = System.nanoTime();
            Ordenacao.insertionSort(dadosInsertion);
            long fimInsertion = System.nanoTime();
            long tInsertion = fimInsertion - incInsertion;

            int[] dadosQuick = clonarVetorManual(dadosOriginais);
            long incQuick = System.nanoTime();
            Ordenacao.quickSort(dadosQuick, 0, dadosQuick.length - 1);
            long fimQuick = System.nanoTime();
            long tQuick = fimQuick - incQuick;

            System.out.printf("Bubble Sort:    %15d ns (%.4f ms)%n", tBubble, tBubble / 1000000.0);
            System.out.printf("Insertion Sort: %15d ns (%.4f ms)%n", tInsertion, tInsertion / 1000000.0);
            System.out.printf("Quick Sort:     %15d ns (%.4f ms)%n", tQuick, tQuick / 1000000.0);
            System.out.println();
        }
    }

    private static int[] clonarVetorManual(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
}
