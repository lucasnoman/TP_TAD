package manipulaArquivos;

import dadosDeCadastros.*;
import lista.*;

import java.io.*;

public class AddArqTAD {
    final File dirExportar = new File("arquivos\\exportar");
    final File dirGeral = new File("arquivos");
    final String fileCandidatos = "Candidatos.txt";
    final String fileEleitores = "Eleitores.txt";
    final String fileMunicipios = "Municipios.txt";
    final String filePartidos = "Candidatos.txt";
    final String fileUrnas = "Urnas.txt";

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
        while (true) { // Lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER). Isso se repete
                       // para todos os arquivos txt abaixo
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

            u = new Urnas(parts[0], parts[1], parts[2], parts[3]);
            listaUrnas.inserirFinal(u);
        }
        br.close();
        return listaUrnas;
    }
    /* ##### FIM inserir URNAS na lista ##### */

    // Recupera os dados em "Municipios.txt" e a para cada linha sua,
    // compara com a lista já feita de Candidatos e cria um arquivo
    public void exportaCandidatos() throws IOException {
        // Recebe primeiramente o txt de municipios
        String fileName = dirGeral + "\\" + fileMunicipios;
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        int i = 0;

        while (true) {
            // Enquanto não terminar de ler o arquivo, não para (break)
            String line = br.readLine();
            if (line == null)
                break;

            // O "parts" recebeu a linha atual do arquivo e removeu o ; e o espaço,
            // colocando cada registro em uma célula do vetor
            String[] parts = line.split(";\s");

            // Se o diretório não existir, cria um novo
            if (!dirExportar.exists())
                dirExportar.mkdir();

            // Uma iteração é feita criando um arquivo para cada linha de cidade no txt
            File exportarCandidatos = new File(dirExportar + "\\ExportarCandidatos" + i + ".txt");

            if (!exportarCandidatos.exists())
                exportarCandidatos.createNewFile();

            // O segundo parâmetro desta classe fica como "true" para que o conteúdo já
            // escrito (que é toda a linha referente a cidade)
            // não seja sobrescrito, mas escrito nas linhas de baixo
            FileWriter fw = new FileWriter(exportarCandidatos.getAbsoluteFile(), true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(line);
            pw.close();

            ListaCandidatos novaLista = new ListaCandidatos();
            // Cria uma nova lista de candidatos, busca o método "listaDeCandidatos" (que já
            // tem a lista pronta) e a partir dele insere apenas os dados na posição 0 e 1
            // do município, que são respectivamente nome da cidade e estado
            novaLista = listaDeCandidatos().insereListaMunCand(parts[0], parts[1]);
            // com essa nova lista pronta, adiciona no arquivo criado acima (na linha 179)
            // os candidatos dessa urna e exporta
            novaLista.exportaArquivo(novaLista, exportarCandidatos);
            i++;
        }
    }

    // Esse método faz a mesma coisa acima, porém usando o arquivo de urna para
    // exportar seus devidos eleitores
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

            FileWriter fw = new FileWriter(exportarUrnas.getAbsoluteFile(), true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(line);
            pw.close();

            ListaEleitores novaLista = new ListaEleitores();
            novaLista = listaDeEleitores().insereListaUrnaEleitor(parts[0], parts[2], parts[3]);
            novaLista.exportaArquivo(novaLista, exportarUrnas);
            i++;
        }
    }
}
