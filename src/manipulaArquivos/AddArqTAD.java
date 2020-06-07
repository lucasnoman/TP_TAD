package manipulaArquivos;

import dadosDeCadastros.*;
import lista.*;

import java.io.*;

@SuppressWarnings("ALL")
public class AddArqTAD {
    private File dirExportar = new File("arquivos\\exportar");
    private File dirGeral = new File("arquivos");
    private String fileCandidatos = "Candidatos.txt";
    private String fileEleitores = "Eleitores.txt";
    private String fileMunicipios = "Municipios.txt";
    private String filePartidos = "Candidatos.txt";
    private String fileUrnas = "Urnas.txt";

    /* ##### Inserir CANDIDATOS na lista ##### */
    public ListaCandidatos listaDeCandidatos() throws IOException {
        String line, fileName;
        String[] parts;
        FileReader fr;
        BufferedReader br;
        ListaCandidatos listaCandidatos;

        fileName = dirGeral + "\\" + fileCandidatos;
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        Candidatos c;
        listaCandidatos = new ListaCandidatos();
        while (true) { // Lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER). Isso se repete para todos os arquivos txt abaixo
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            int parse = Integer.parseInt(parts[1]);
            c = new Candidatos(parts[0], parse, parts[2], parts[3], parts[4], parts[5]);
            listaCandidatos.inserirFinal(c);
        }
        br.close();
        return listaCandidatos;
    }
    /* ##### FIM inserir CANDIDATOS na lista ##### */

    /* ##### Inserir ELEITORES na lista ##### */
    public ListaEleitores listaDeEleitores() throws IOException {
        String line, fileName;
        String[] parts;
        FileReader fr;
        BufferedReader br;
        ListaEleitores listaEleitores;

        fileName = dirGeral + "\\" + fileEleitores;
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        Eleitores e;
        listaEleitores = new ListaEleitores();
        while (true) {
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            e = new Eleitores(parts[0], parts[1], parts[2], parts[3], parts[4]);
            listaEleitores.inserirFinal(e);
        }
        br.close();
        return listaEleitores;
    }
    /* ##### FIM inserir ELEITORES na lista ##### */

    /* ##### Inserir PARTIDOS na lista ##### */
    public ListaPartido listaDePartidos() throws IOException {
        String line, fileName;
        String[] parts;
        FileReader fr;
        BufferedReader br;
        ListaPartido listaPartidos;

        fileName = dirGeral + "\\" + filePartidos;
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        Partidos p;
        listaPartidos = new ListaPartido();
        while (true) {
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            p = new Partidos(parts[0], parts[1]);
            listaPartidos.inserirFinal(p);
        }
        br.close();
        return listaPartidos;
    }
    /* ##### FIM inserir PARTIDOS na lista ##### */

    /* ##### Inserir MUNICÍPIOS na lista ##### */
    public ListaMunicipios listaDeMunicipios() throws IOException {
        String line, fileName;
        String[] parts;
        FileReader fr;
        BufferedReader br;
        ListaMunicipios listaMunicipios;

        fileName = dirGeral + "\\" + fileMunicipios;
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        Municipios m;
        listaMunicipios = new ListaMunicipios();
        while (true) {
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            int parse = Integer.parseInt(parts[3]);
            int parse2 = Integer.parseInt(parts[2]);
            m = new Municipios(parts[0], parts[1], parse, parse2);
            listaMunicipios.inserirFinal(m);
            br.close();
        }
        br.close();
        return listaMunicipios;
    }
    /* ##### FIM inserir MUNICÍPIOS na lista ##### */

    /* ##### Inserir URNAS na lista ##### */
    public ListaUrnas listaDeUrnas() throws IOException {
        String line, fileName;
        String[] parts;
        FileReader fr;
        BufferedReader br;
        ListaUrnas listaUrnas;

        fileName = dirGeral + "\\" + fileUrnas;
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        Urnas u;
        listaUrnas = new ListaUrnas();
        while (true) {
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            u = new Urnas(parts[0], parts[1], parts[2]);
            listaUrnas.inserirFinal(u);
        }
        br.close();
        return listaUrnas;
    }
    /* ##### FIM inserir URNAS na lista ##### */

    public void exportaCandidatos() throws IOException {
        String fileName = dirGeral + "\\" + fileMunicipios;
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        int i = 0;

        while (true) {
            String line = br.readLine();
            if (line == null)
                break;

            String[] parts = line.split(";\s");

            if (!dirExportar.exists())
                dirExportar.mkdir();
            File exportarCandidatos = new File(dirExportar + "\\ExportarCandidatos" + i + ".txt");

            if (!exportarCandidatos.exists())
                exportarCandidatos.createNewFile();

            String juntarCidade = parts[0] + "; " + parts[1] + "; " + parts[2] + "; " + parts[3];
            FileWriter fw = new FileWriter(exportarCandidatos.getAbsoluteFile(), true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(juntarCidade);
            pw.close();

            ListaCandidatos novaLista = new ListaCandidatos();
            novaLista = listaDeCandidatos().insereListaMunCand(parts[0], parts[1]);
            novaLista.exportaArquivo(novaLista, exportarCandidatos);
            i++;
        }
    }

    public void exportarUrnas() throws IOException {
        String fileName = dirGeral + "\\" + fileUrnas;
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        int i = 0;

        while (true) {
            String line = br.readLine();
            if (line == null)
                break;

            String[] parts = line.split(";\s");

            if (!dirExportar.exists())
                dirExportar.mkdir();
            File exportarUrnas = new File(dirExportar + "\\ExportarUrnas" + i + ".txt");

            if (!exportarUrnas.exists())
                exportarUrnas.createNewFile();

            String juntar = parts[0] + "; " + parts[1] + "; " + parts[2];
            FileWriter fw = new FileWriter(exportarUrnas.getAbsoluteFile(), true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(juntar);
            pw.close();

            ListaEleitores novaLista = new ListaEleitores();
            novaLista = listaDeEleitores().insereListaUrnaEleitor(parts[0], parts[1], parts[2]);
            novaLista.exportaArquivo(novaLista, exportarUrnas);
            i++;
        }
    }

    public ListaEleitores teste() throws IOException {
        String fileName = dirGeral + "\\" + fileUrnas;
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        ListaEleitores novaLista = new ListaEleitores();

        while (true) {
            String line = br.readLine();
            if (line == null)
                break;

            String[] parts = line.split(";\s");
            String juntar = parts[0] + "; " + parts[1] + "; " + parts[2];

            novaLista = listaDeEleitores().insereListaUrnaEleitor(parts[0], parts[1], "1001");
        }
        return novaLista;
    }
}
