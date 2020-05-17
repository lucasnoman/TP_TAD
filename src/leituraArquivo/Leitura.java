package leituraArquivo;

import java.io.*;
import java.util.Scanner;

public class Leitura {
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
