package arquivos;

import dadosDeCadastros.Candidatos;
import lista.ListaCandidatos;

import java.io.IOException;
import java.io.*;

public class Exportar { //Essa classe não está sendo usada ainda. Estou fazendo o "exportar" na AddArqTAD
    public void exportar() throws IOException {
        File file = new File("arquivos\\ExportUrnas.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        String linha;

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
    }
}
