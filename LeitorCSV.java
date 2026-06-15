import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCSV {

    public static int[] lerArquivo(String caminho, int tamanho) {
        int[] dados = new int[tamanho];
        int ponteiro = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String cabecalho = br.readLine(); 

            String linha;
            while ((linha = br.readLine()) != null && ponteiro < tamanho) {
                if (linha.trim().isEmpty()) {
                    continue;
                }
                
                String[] partes = linha.split("[,;]");
                
                for (String parte : partes) {
                    String textoLimpo = parte.trim();
                    if (!textoLimpo.isEmpty() && ponteiro < tamanho) {
                        try {
                            dados[ponteiro] = Integer.parseInt(textoLimpo);
                            ponteiro++;
                        } catch (NumberFormatException e) {
                            System.out.println("⚠️ Aviso: Linha com texto invalido pulada: [" + textoLimpo + "]");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + caminho + " -> " + e.getMessage());
            return null;
        }

        return dados;
    }
}
