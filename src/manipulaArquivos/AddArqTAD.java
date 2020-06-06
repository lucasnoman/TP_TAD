package manipulaArquivos;

import dadosDeCadastros.*;
import lista.*;

import java.io.*;
import java.util.Scanner;

public class AddArqTAD {
    public void menu() {
        System.out.println("Digite a lista que deseja imprimir");
        System.out.println("1. Candidatos");
        System.out.println("2. Eleitores");
        System.out.println("3. Municípios");
        System.out.println("4. Partidos");
        System.out.println("5. Urnas");
        System.out.println("0. Sair");
    }

    public void createADT() throws IOException {
        Scanner sc = new Scanner(System.in);
        String line;
        String[] parts;
        FileReader fr;
        BufferedReader br;
        FileWriter fw;
        BufferedWriter bw;


        /* ##### Inserir CANDIDATOS na lista ##### */
        String fileName = "arquivos\\Candidatos.txt";
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        Candidatos c;
        ListaCandidatos listaCandidatos = new ListaCandidatos();
        while (true) { // Lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER). Isso se repete para todos os arquivos txt abaixo
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

//            for (String t : parts) { // testar impressão do conteúdo do arquivo
//                System.out.println(t);
//            }

            int parse = Integer.parseInt(parts[1]);
            c = new Candidatos(parts[0], parse, parts[2], parts[3], parts[4], parts[5]);
            listaCandidatos.inserirFinal(c);
        }
        br.close();

        /* ##### Inserir ELEITORES na lista ##### */
        fileName = "arquivos\\Eleitores.txt";
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        Eleitores e;
        ListaEleitores listaEleitores = new ListaEleitores();
        while (true) {
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            e = new Eleitores(parts[0], parts[1], parts[2], parts[3], parts[4]);
            listaEleitores.inserirFinal(e);
        }
        br.close();

        /* ##### Inserir MUNICIPIOS na lista ##### */
        fileName = "arquivos\\Municipios.txt";
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        Municipios m;
        ListaMunicipios listaMunicipios = new ListaMunicipios();
        while (true) {
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            int parse = Integer.parseInt(parts[3]);
            int parse2 = Integer.parseInt(parts[2]);
            m = new Municipios(parts[0], parts[1], parse, parse2);
            listaMunicipios.inserirFinal(m);
        }
        br.close();

        /* ##### Inserir PARTIDOS na lista ##### */
        fileName = "arquivos\\Partidos.txt";
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        Partidos p;
        ListaPartido listaPartidos = new ListaPartido();
        while (true) {
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            p = new Partidos(parts[0], parts[1]);
            listaPartidos.inserirFinal(p);
        }
        br.close();

        /* ##### Inserir URNAS na lista ##### */
        fileName = "arquivos\\Urnas.txt";
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        Urnas u;
        ListaUrnas listaUrnas = new ListaUrnas();
        String juntar;
        int i = 0;
        while (true) { // Lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER)
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            u = new Urnas(parts[0], parts[1], parts[2]);
            listaUrnas.inserirFinal(u);


            /* ############# Exportação de listaUrnas por arquivo ############# */
            juntar = parts[0] + "; " + parts[1] + "; " + parts[2];
            File exportarUrnas = new File("arquivos\\ExportarUrnas" + i + ".txt"); //Cria 1 arquivo por volta no loop
            String nome = exportarUrnas.toString();

            if (!exportarUrnas.exists())
                exportarUrnas.createNewFile();

            fw = new FileWriter(exportarUrnas.getAbsoluteFile(), true); //O segundo argumento (true) permite que escrevamos no arquivo sem sobrescrever o que já tem lá.
            bw = new BufferedWriter(fw);
            bw.write(juntar); // Escreve no arquivo
            bw.newLine(); // Usa o "enter" para quebra de linha após escrever
            bw.close();
//            #####################################################################################

            ListaEleitores novaLista = listaEleitores.insereListaUrnaEleitor(parts[0], parts[1], parts[2]); //dentro de ListaEleitores, fazer um método que recebe essa "novaLista" e o "exportarUrnas" como parâmetro e adicionar tudo no arquivo
            novaLista.exportaArquivo(novaLista, exportarUrnas);
            i++;
        }
        br.close();




        /* Trecho que imprime as listas */
//        int op;
//        do {
//            System.out.println();
//            menu();
//            System.out.println();
//            op = Integer.parseInt(sc.nextLine());
//            switch (op) {
//                case 1 -> listaCandidatos.imprimir();
//                case 2 -> listaEleitores.imprimir();
//                case 3 -> listaMunicipios.imprimir();
//                case 4 -> listaPartidos.imprimir();
//                case 5 -> listaUrnas.imprimir();
//                case 0 -> System.out.println("");
//                default -> {
//                    System.out.println("Opção inválida.\nDigite novamente.");
//                    op = Integer.parseInt(sc.nextLine());
//                }
//            }
//        } while (op != 0);
    }
}
