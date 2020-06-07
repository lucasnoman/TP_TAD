package menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import dadosDeCadastros.Candidatos;
import dadosDeCadastros.Eleitores;
import dadosDeCadastros.Urnas;
import lista.ListaCandidatos;
import lista.ListaEleitores;

public class Menu {

    public void limpaTela() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");

    }

    public void menu() {
        System.out.println("****************************************************************************************");
        System.out.println("                                        Módulo Urna");
        System.out.println("****************************************************************************************");
        System.out.println("    Menu - Configuração....");
        System.out.println();
        System.out.println("    1 -  Configuração da Urna");
        System.out.println("    2 -  Carregar dados dos Eleitores:");
        System.out.println("    3 -  Carregar dados dos candidatos a prefeito e vereador");
        System.out.println("    4 -  Iniciar Votação");
        System.out.println("    5 -  Finalizar Votação");
        System.out.println("    6 -  Exportar dados da votação");
        System.out.println("    0 -  Para finalizar\n");
        System.out.println("*************************************************************************************");
        System.out.println();
        System.out.println("    Informe sua opção: ");
    }

    public void opcoesMenu() throws IOException, InterruptedException {
        Urnas urnaLocal;
        String municipio;
        String zona;
        String secao;

        int escolhaJustif = 0;

        String arqEleitores = "ArquivoUrnaEleitores.txt";
        String arqCandidatos = "ArqCandidatos.txt";

        ListaEleitores listEleitores = new ListaEleitores();
        ListaEleitores listJustificativas = new ListaEleitores();
        ListaCandidatos listPrefeitos = new ListaCandidatos();
        ListaCandidatos listVereadores = new ListaCandidatos();


        limpaTela();

        boolean continua = true;
        boolean emVotacao = true;
        Scanner sc = new Scanner(System.in);
        int escolhaMenu = 0, escolhaMenuVotacao = 0;

        do {
            menu();
            escolhaMenu = sc.nextInt();
            switch (escolhaMenu) {
                case 1:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            1 -  Configuração da Urna");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Informe o municipio desta urna: ");
                    sc.nextLine();
                    municipio = sc.nextLine();
                    System.out.println("\n Informe a seção desta urna: ");
                    secao = sc.nextLine();
                    System.out.println("\n Informe informe a zona desta urna: ");
                    zona = sc.nextLine();
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("Urna configurada com sucesso!!!");
                    System.out.println("Municipio: " + municipio + " || Zona: " + zona + " || seção:  || " + secao);
                    urnaLocal = new Urnas(municipio, zona, secao);
                    System.out.println("\n urna criada com sucesso\n");
                    System.out.println(urnaLocal);
                    System.out.println("\n");
                    break;

                case 2:
                    // preciso de ajudar aqui!!!!
                    // ler o arquivo exportado e carregar os eleitores na lista de eleitores
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("          2 -  Carregar dados dos Eleitores");
                    System.out.println("----------------------------------------------------------\n");

                    listEleitores = lerArqCriarLista(arqEleitores);
                    listEleitores.imprimir();

                    break;

                case 3:
                    // preciso de ajudar aqui!!!!

                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("          3 -  Carregar dados dos candidatos a prefeito e vereador");
                    System.out.println("----------------------------------------------------------\n");
                    // aqui irá puxar os dados exportados e criar uma lista de candidados a prefeito
                    // e outra lista de candidados a vereador

                    lerArqCriarListaCand(arqCandidatos, listPrefeitos, listVereadores);
                    System.out.println("--------------------------");
                    System.out.println("Lista de Prefeitos");
                    listPrefeitos.imprimir();
                    System.out.println("--------------------------");
                    System.out.println("Lista de Vereadores");
                    listVereadores.imprimir();
                    System.out.println("--------------------------");

                    break;

                case 4:
                    // limpaTela();
                    // System.out.println("----------------------------------------------------------");
                    // //System.out.println(" 4 - Iniciar Votação");
                    // System.out.println("----------------------------------------------------------\n");
                    do {
                        String titulo;
                        menuVotar();
                        escolhaMenuVotacao = sc.nextInt();
                        if (escolhaMenuVotacao == 1) {
                            System.out.println("Digite o Titulo:");
                            sc.nextLine();
                            titulo = sc.nextLine();
                            System.out.println(titulo);
                            Eleitores el = localizarTitulo(listEleitores, titulo);

                            if (el == null) {
                                //limpaTela();
                                System.out.println("Titulo não encontrado nesta urna");
                                System.out.println("Deseja justificar seu voto? 1 - para sim // 2 - para não");

                                escolhaJustif = sc.nextInt();

                                if (escolhaJustif == 1) {
                                    justificar(titulo, listJustificativas);
                                }

                            } else {

                            }

                            // System.out.println("Voto recebido!!!");
                            // System.out.println("Titulo digitado: " + titulo);
                            System.out.println("\n Digite 0 e tecle enter para continuar.....");
                            sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar

                            // aqui vai ter que ir para uma tela para capturar prefeito e
                            // outra para capturar o vereador, vc me ajudando a criar as listas, faço as
                            // manipulações

                        } else if (escolhaMenuVotacao == 2) {
                            System.out.println("Digite o Titulo:");
                            sc.nextLine();
                            titulo = sc.nextLine();

                            justificar(titulo, listJustificativas);

                        } else if (escolhaMenuVotacao == 0) {
                            emVotacao = false;
                        }
                    } while (emVotacao);

                    break;
                case 5:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("           5 - Finalizar Votação");
                    System.out.println("----------------------------------------------------------\n");
                    // pensei em deixar o metodo finalizar votação e gerar o consolidado na classe
                    // urna

                    break;
                case 6:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("           6 - Exportar dados da votação");
                    System.out.println("----------------------------------------------------------\n");
                    // este tb seria um metodo da classe urna

                    break;
                case 0:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("           0 -  Programa finalizado!!!!!");
                    System.out.println("----------------------------------------------------------\n");
                    continua = false;

                    break;

                default:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Código não existente!!!!!!!!!!!");
                    System.out.println("----------------------------------------------------------\n");
                    // limpaTela();
                    break;
            }
            escolhaMenu = 0;
        } while (continua);

        sc.close();
    }

    public void menuVotar() throws InterruptedException, IOException {
////        limpaTela();
        System.out.println("****************************************************************************************");
        System.out.println("                                        Módulo Urna");
        System.out.println("****************************************************************************************");
        System.out.println("    Menu - Votação - Digite o código desejado:");
        System.out.println("\n");
        System.out.println("    1 -  Informar Titulo de Eleitor");
        System.out.println("    0 -  Para voltar ao menu inicial\n");
        System.out.println("*************************************************************************************");
        System.out.println();
        System.out.println("    Informe sua opção: ");
    }

    public void menuTRE() {
        System.out.println("****************************************************************************************");
        System.out.println("                                        Módulo TRE");
        System.out.println("****************************************************************************************");
        System.out.println("    Escolha a opção desejada e tecle enter....");
        System.out.println();
        System.out.println("    1 -  Cadastro de partidos políticos");
        System.out.println("    2 -  Cadastro de municípios:");
        System.out.println("    3 -  Cadastro dos candidatos a prefeito e vereador");
        System.out.println("    4 -  Cadastro dos eleitores");
        System.out.println("    5 -  Cadastro das urnas eletrônicas");
        System.out.println("    6 -  Exportar dados para as urnas eletrônicas");
        System.out.println("    0 -  Para finalizar\n");
        System.out.println("*************************************************************************************");
        System.out.println();
        System.out.print("    Informe sua opção: ");
    }

    public void opcoesTRE() throws IOException, InterruptedException {
        boolean continua = true;
        Scanner sc = new Scanner(System.in);
        int escolhaMenu = 0;

        do {
            menuTRE();
            escolhaMenu = sc.nextInt();
            switch (escolhaMenu) {
                case 1 -> {
//                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Cadastro de partidos políticos");
                    System.out.println("----------------------------------------------------------\n");
                }
                case 2 -> {
//                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Cadastro de municípios");
                    System.out.println("----------------------------------------------------------\n");
                }
                case 3 -> {
//                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Cadastro dos candidatos a prefeito e vereador");
                    System.out.println("----------------------------------------------------------\n");
                }
                case 4 -> {
//                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Cadastro dos eleitores");
                    System.out.println("----------------------------------------------------------\n");
                }
                case 5 -> {
//                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Cadastro das urnas eletrônicas");
                    System.out.println("----------------------------------------------------------\n");
                }
                case 6 -> {
//                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Exportar dados para as urnas eletrônicas");
                    System.out.println("----------------------------------------------------------\n");
                }
                case 0 -> {
//                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Programa finalizado!!!!!");
                    System.out.println("----------------------------------------------------------\n");
                    continua = false;
                }
                default -> {
//                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Código não existente!!!!!!!!!!!");
                    System.out.println("----------------------------------------------------------\n");
                }
            }
        } while (continua);
    }

    public static Eleitores localizarTitulo(ListaEleitores list, String numTitulo) {
        System.out.println("Localizar Titulo - ENTROU");
        return list.localizar(numTitulo);
    }

    public static void justificar(String titulo, ListaEleitores listJustif) {
        System.out.println("A justificativa  de voto - entrou");
        Eleitores eleitor = new Eleitores(titulo, "J");
        listJustif.inserirFinal(eleitor);
        System.out.println("Voto Justificado!!!");
        listJustif.imprimir();
    }

    public static void lerArquivo(String file) throws IOException {
        String linha;

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        // imprime linha a linha
        while ((linha = br.readLine()) != null) {
            System.out.println(linha);
        }
        fr.close();
        br.close();
    }

    public static ListaEleitores lerArqCriarLista(String file) throws IOException {
        String linha;
        String[] parts;
        boolean passouPrimeiraLinha = false;

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        Eleitores el;
        ListaEleitores lista = new ListaEleitores();

        // imprime linha a linha
        while (true) {

            linha = br.readLine();
            if (passouPrimeiraLinha) {
                if (linha == null)
                    break;

                el = new Eleitores(linha);
                lista.inserirFinal(el);
            }

            passouPrimeiraLinha = true;
        }

        fr.close();
        br.close();
        return lista;
    }

    public static void lerArqCriarListaCand(String file, ListaCandidatos prefeitos, ListaCandidatos vereadores) throws IOException {
        System.out.println("Carregar dados dos candidatos - ENTROU");

        String linha;
        String[] parts;
        boolean passouPrimeiraLinha = false;

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        Candidatos cand;

        // imprime linha a linha
        while (true) {
            linha = br.readLine();
            if (passouPrimeiraLinha) {
                if (linha == null)
                    break;

                parts = linha.split(";\s");
                String cargo = parts[3].toUpperCase();
                System.out.println("Este é o cargo : " + cargo);

                if (cargo.equals("P")) {//vai criar a lista de prefeito
                    cand = new Candidatos(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
                    prefeitos.inserirFinal(cand);
                } else {
                    cand = new Candidatos(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
                    vereadores.inserirFinal(cand);
                }

                // for (int i = 0; i < parts.length; i++) {
                //     System.out.println(parts[i]);
                // }
            }
            passouPrimeiraLinha = true;
        }

        fr.close();
        br.close();
    }
}