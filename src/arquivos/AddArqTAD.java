package arquivos;

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

        /* ##### Inserir CANDIDATOS na lista ##### */ //DONE
        String file = "arquivos\\Candidatos.txt";
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        Candidatos c;
        ListaCandidatos candidatos = new ListaCandidatos();
        while (true) { //lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER). Isso se repeta para todos os arquivos txt abaixo  DONE
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

//            for (String t : parts) { // testar impressão do conteúdo do arquivo
//                System.out.println(t);
//            }

            int parse = Integer.parseInt(parts[1]);
            c = new Candidatos(parts[0], parse, parts[2], parts[3], parts[4], parts[5]);
            candidatos.inserirFinal(c);
        }

        /* ##### Inserir ELEITORES na lista ##### */ //DONE
        file = "arquivos\\Eleitores.txt";
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        Eleitores e;
        ListaEleitores eleitores = new ListaEleitores();
        while (true) { //lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER)
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            e = new Eleitores(parts[0], parts[1], parts[2], parts[3], parts[4]);
            eleitores.inserirFinal(e);
        }

        /* ##### Inserir MUNICIPIOS na lista ##### */ //DONE
        file = "arquivos\\Municipios.txt";
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        Municipios m;
        ListaMunicipios municipios = new ListaMunicipios();
        while (true) { //lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER)
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            int parse = Integer.parseInt(parts[3]);
            int parse2 = Integer.parseInt(parts[2]);
            m = new Municipios(parts[0], parts[1], parse, parse2);
            municipios.inserirFinal(m);
        }

        /* ##### Inserir PARTIDOS na lista ##### */ //DONE
        file = "arquivos\\Partidos.txt";
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        Partidos p;
        ListaPartido partidos = new ListaPartido();
        while (true) { //lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER)
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            p = new Partidos(parts[0], parts[1]);
            partidos.inserirFinal(p);
        }

        /* ##### Inserir URNAS na lista ##### */ //DONE
        file = "arquivos\\Urnas.txt";
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        Urnas u;
        ListaUrnas urnas = new ListaUrnas();
        while (true) { //lê o arquivo e remove o " ; " e a "quebra de linha" (ENTER)
            line = br.readLine();
            if (line == null)
                break;
            parts = line.split(";\s");

            u = new Urnas(parts[0], parts[1], parts[2]);
            urnas.inserirFinal(u);
        }
        br.close();

        /* Trecho que imprime as listas */ //DONE
//        int op;
//        do {
//            System.out.println();
//            menu();
//            System.out.println();
//            op = Integer.parseInt(sc.nextLine());
//            switch (op) {
//                case 1 -> candidatos.imprimir();
//                case 2 -> eleitores.imprimir();
//                case 3 -> municipios.imprimir();
//                case 4 -> partidos.imprimir();
//                case 5 -> urnas.imprimir();
//                case 0 -> System.out.println("");
//                default -> {
//                    System.out.println("Opção inválida.\nDigite novamente.");
//                    op = Integer.parseInt(sc.nextLine());
//                }
//            }
//        } while (op != 0);


        /* Exportar conteúdo */ //TODO
//        File archive = new File("arquivos\\ExportUrnas.txt"); // Cria o arquivo novo. Temos que colocar isso para iterar e criar um nome novo a cada vez que busca uma urna nova. TODO
//
//        if (!archive.exists()) { // Verifica se o arquivo existe, se não, cria ele.
//            archive.createNewFile();
//        }
//        FileWriter fw = new FileWriter(archive.getAbsoluteFile());
//        BufferedWriter bw = new BufferedWriter(fw);

        /*
         * A ideia aqui era buscar na lista uma urna, criar um arquivo com os dados dela
         * e procurar todos os eleitores que votam nessa urna e colocar no mesmo arquivo
         * */

    }
}
