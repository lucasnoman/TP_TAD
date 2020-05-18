package arquivos;

import dadosDeCadastros.Partidos;
import lista.ListaPartido;

import java.io.*;

public class AddArqTAD {
    public void createADT() throws IOException {
        Partidos p;
        ListaPartido partido = new ListaPartido();
        String line;
        int pos = 0;

        if (partido.listaVazia()) {
            System.out.println("A lista de partidos está vazia.");
        }

        FileReader fr = new FileReader("arquivos\\Partidos.txt");
        BufferedReader br = new BufferedReader(fr);

        //lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER)
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            String[] parts = line.split(";\s");

            for (String part : parts) {
                System.out.println(part);
            }
        }
        br.close();


        /*
         reservado para após o SPLIT
         */
//        p = new Partidos("Teste", "T");
//        partido.inserirFinal(p);
//        p = new Partidos("Teste2", "T2");
//        partido.inserirFinal(p);
//        System.out.println("Partidos cadastrados:");
//        partido.imprimir();
    }
}
