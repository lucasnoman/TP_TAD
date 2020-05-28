package arquivos;

import java.io.*;

public class Leitura { // Essa classe apenas lê o arquivo txt. Pensei em usar ela para ler e usar return para chamar em outra classe, mas acho que não rola.
    public void lerArquivo(String file) throws IOException {
        String linha;

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        //imprime linha a linha
        while ((linha = br.readLine()) != null) {
            System.out.println(linha);
        }
        fr.close();
        br.close();
    }
}
