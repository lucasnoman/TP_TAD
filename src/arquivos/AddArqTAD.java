package arquivos;

import dadosDeCadastros.Candidatos;
import dadosDeCadastros.Eleitores;
import dadosDeCadastros.Partidos;
import lista.ListaCandidatos;
import lista.ListaPartido;
import lista.ListaEleitores;

import java.io.*;

public class AddArqTAD {
    public void createADT(String file) throws IOException {
        Partidos p;
        Candidatos c;
        Eleitores e;
        ListaPartido partidos = new ListaPartido();
        ListaCandidatos candidatos = new ListaCandidatos();
        ListaEleitores eleitores = new ListaEleitores();
        String line;

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        //lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER)
        while (true) {
            line = br.readLine();
            if (line == null)
                break;
            String[] parts = line.split(";\s");

//            foreach só para imprimir o que foi lido do arquivo
//            for (String t : parts) {
//                System.out.println(t);
//            }

            //Insere Candidatos na lista
            if (parts.length == 6) {
                int parse = Integer.parseInt(parts[1]);
                c = new Candidatos(parts[0], parse, parts[2], parts[3], parts[4], parts[5]);
                candidatos.inserirFinal(c);
            } else if (parts.length == 2) { //Partidos
                p = new Partidos(parts[0], parts[1]);
                partidos.inserirFinal(p);
            } else if (parts.length == 5) { //Eleitores
                e = new Eleitores(parts[0], parts[1], parts[2], parts[3], parts[4]);
                eleitores.inserirFinal(e);
            }
        }
        br.close();

        //por enquanto só está sendo impresso aqui nessa classe
        partidos.imprimir();
        eleitores.imprimir();
    }
}
