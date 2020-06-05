package manipulaArquivos;

import java.util.Scanner;
import java.io.*;

public class AddConteudoArquivo {
    public void escreverPartido() throws IOException {
        Scanner sc = new Scanner(System.in);
        File dir = new File("arquivos\\");
        File file = new File(dir, "Teste.txt");
        String nome, sigla;

        if (!file.exists())
            file.createNewFile();

//        Colocando o segundo argumento como true, o código não sobrescreve o que já contem no arquivo
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < 2; i++) { //isso foi feito só para testar a escrita
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
