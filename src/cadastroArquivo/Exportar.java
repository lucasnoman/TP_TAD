package cadastroArquivo;

import java.io.IOException;
import java.io.*;

public class Exportar {
    public void exportar() throws IOException {
        File dir = new File("arquivos\\");
        File file = new File(dir, "Urnas.txt");
        File file2 = new File(dir, "Eleitores.txt");
        int cont = 0;

        String linha, linha2;

        FileReader fr = new FileReader(file);
        FileReader fr2 = new FileReader(file2);
        BufferedReader br = new BufferedReader(fr);
        BufferedReader br2 = new BufferedReader(fr2);

        //imprime linha a linha
        while (br.readLine() != null && br2.readLine() != null) {
            if () {
                //buscar a zona eleitoral e todos os eleitores que votarão nela.
            }
        }
        System.out.println("Quantidade de linhas: " + cont);
        fr.close();
        br.close();
    }
}
