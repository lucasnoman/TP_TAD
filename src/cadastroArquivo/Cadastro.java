package cadastroArquivo;

import java.util.Scanner;
import java.io.*;

public class Cadastro {
    public void escreverPartido() throws IOException {
        Scanner sc = new Scanner(System.in);
        File dir = new File("arquivos\\");
        File file = new File(dir, "Partidos.txt");
        String nome, sigla;

        if (!file.exists())
            file.createNewFile();

        //colocando o segundo argumento como true, eu não sobrescrevo o que já contem no arquivo
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);

        //isso foi feito só para testar a escrita
        for (int i = 0; i < 2; i++) {
            System.out.println("Nome do partido:");
            nome = sc.nextLine();
            System.out.println("Sigla do partido:");
            sigla = sc.nextLine();
            bw.write(nome + "; " + sigla);
            bw.newLine();
        }
        bw.close();
    }
}
