package menu;

import dadosDeCadastros.Candidatos;
import dadosDeCadastros.Eleitores;
import dadosDeCadastros.Urnas;
import lista.ListaCandidatos;
import lista.ListaEleitores;
import manipulaArquivos.AddArqTAD;

import java.io.*;
import java.util.Scanner;

public class Menu {

    final File dirExportar = new File("arquivos\\exportar");

    public void menu() {
        System.out.println("****************************************************************************************");
        System.out.println("                                        Módulo Urna");
        System.out.println("****************************************************************************************");
        System.out.println("    Menu - Configuração....");
        System.out.println("\n");
        System.out.println("    1 -  Configuração da Urna");
        System.out.println("    2 -  Carregar dados dos Eleitores:");
        System.out.println("    3 -  Carregar dados dos candidatos a prefeito e vereador");
        System.out.println("    4 -  Iniciar Votação");
        System.out.println("    5 -  Finalizar Votação");
        System.out.println("    6 -  Exportar dados da votação");
        System.out.println("    0 -  Para finalizar\n");
        System.out.println("*************************************************************************************");
        System.out.print("    Informe sua opção: ");
    }

    public void menuVotar() throws InterruptedException, IOException {
        limpaTela();
        System.out.println("****************************************************************************************");
        System.out.println("                                       **Módulo Urna**   ");
        System.out.println("                                     >>> Menu - Votação <<< ");
        System.out.println("****************************************************************************************");
        System.out.println("    Digite o código desejado:");
        System.out.println("\n");
        System.out.println("    1 -  Informar Titulo de Eleitor");
        System.out.println("    2 -  Informar Justificativa");
        System.out.println("    0 -  Para voltar ao menu inicial\n");
        System.out.println("*************************************************************************************");
        // System.out.println("\n");
        System.out.println("    Informe sua opção: ");
    }

    public void opcoesMenu() throws InterruptedException, IOException {
        Urnas urnaLocal = new Urnas();

        int escolhaJustif = 0;

//        String arqEleitores = "arquivos\\exportar\\ExportarUrnas1.txt";
//        String arqCandidatos = "arquivos\\exportar\\ExportarCandidatos1.txt";

        ListaEleitores listEleitores = new ListaEleitores();
        ListaEleitores listJustificativas = new ListaEleitores();
        ListaCandidatos listPrefeitos = new ListaCandidatos();
        ListaCandidatos listVereadores = new ListaCandidatos();

        limpaTela();

        boolean continua = true;
        boolean emVotacao = true;
        Scanner sc = new Scanner(System.in);
        int escolhaMenu = 0, escolhaMenuVotacao = 0;
        AddArqTAD at = new AddArqTAD();

        do {
            limpaTela();
            menu();
            escolhaMenu = sc.nextInt();
            switch (escolhaMenu) {
                case 1 -> {
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            1 -  Configuração da Urna");
                    System.out.println("----------------------------------------------------------");
                    System.out.println();
                    System.out.println("Qual urna deseja carregar?");
                    at.listaDeUrnas().imprimir();
                    System.out.print("Escolha: ");
                    int i = sc.nextInt();
                    System.out.println("--------------------------\n");
                    // o que for colocar em "lerArqDadosUrna", vai alterar o "case 2". Neste caso, o usuário irá digitar a cidade, zona e seção e o "case 2" irá procurar o arquivo exportado referente a essa urna
                    urnaLocal = lerArqDadosUrna(dirExportar + "\\ExportarUrnas" + i + ".txt");
                    System.out.println("\n Digite 0 e tecle enter para continuar.....");
                    sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar
                }
                case 2 -> {
                    // ler o arquivo exportado e carregar os eleitores na lista de eleitores
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("          2 -  Carregar dados dos Eleitores");
                    System.out.println("----------------------------------------------------------\n");
                    // Busca o arquivo de exportação referente aos dados da urna pedidos no "case 1" e retorna o devido "File"
                    File arquivoUrnas = encontraArquivoUrnaExportado(urnaLocal.getMunicipio(), urnaLocal.getEstado(), urnaLocal.getZonaEleitoral(), urnaLocal.getSecaoEleitoral());
                    System.out.println();
                    System.out.println("Teste: " + urnaLocal.getMunicipio() + " - " + urnaLocal.getSecaoEleitoral());
                    System.out.println();
                    listEleitores = lerArqCriarLista(arquivoUrnas.toString());
                    listEleitores.imprimirDadosEleitores();
                    System.out.println("\n Digite 0 e tecle enter para continuar.....");
                    sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar
                }
                case 3 -> {
                    // TODO
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("          3 -  Carregar dados dos candidatos a prefeito e vereador");
                    System.out.println("----------------------------------------------------------\n");
                    // aqui irá puxar os dados exportados e criar uma lista de candidados a prefeito e outra lista de candidados a vereador
                    File arqCandidatos = escontraArquivoCandidatosExportados(urnaLocal.getMunicipio(), urnaLocal.getEstado());
                    lerArqCriarListaCand(arqCandidatos.toString(), listPrefeitos, listVereadores);
                    limpaTela();
                    System.out.println("--------------------------");
                    System.out.println("Lista de Prefeitos");
                    listPrefeitos.imprimir();
                    System.out.println("--------------------------");
                    System.out.println("Lista de Vereadores");
                    listVereadores.imprimir();
                    System.out.println("--------------------------");
                    System.out.println("\n Digite 0 e tecle enter para continuar.....");
                    sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar
                }
                case 4 -> {
                    limpaTela();
                    do {
                        String titulo;
                        menuVotar();
                        escolhaMenuVotacao = sc.nextInt();
                        if (escolhaMenuVotacao == 1) {
                            System.out.println("Digite o Titulo:");
                            sc.nextLine();
                            titulo = sc.nextLine();
                            Eleitores el = localizarTitulo(listEleitores, titulo);

                            if (el == null) {
                                limpaTela();
                                System.out.println("\n------------------------------------------------------------");
                                System.out.println("O Titulo (" + titulo + ") não foi encontrado nesta urna");
                                System.out.println("Deseja justificar seu voto? 1 - para sim // 2 - para não");

                                escolhaJustif = sc.nextInt();
                                if (escolhaJustif == 1) {
                                    justificar(urnaLocal.getMunicipio(), urnaLocal.getZonaEleitoral(), urnaLocal.getSecaoEleitoral(), titulo, listJustificativas);
                                    System.out.println("\n Digite 0 e tecle enter para continuar.....");
                                    sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar
                                }

                            } else if (el.getStatus().equals("V")) {

                                limpaTela();
                                System.out.println("Já votou!!!!!!!");
                                System.out.println("\n Digite 0 e tecle enter para continuar.....");
                                sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar
                                break;

                            } else {

                                limpaTela();
                                System.out.println("--------------------------------------------------------------------");
                                System.out.println("Local de votação correto, e ainda não votou....");
                                System.out.println("--------------------------------------------------------------------");
                                System.out.println("\n Digite 0 e tecle enter para liberar a tela de votação.....");
                                sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar para facilitar na hora de votar!!!

                                limpaTela();
                                System.out.println("\nLista de vereadores disponiveis para voto\n");
                                listVereadores.imprimir();
                                System.out.println("\n------------------------------------------------------------------------");
                                System.out.println("Digite o número do seu candidato a vereador:");
                                sc.nextLine();
                                String numVereador = sc.nextLine();
                                System.out.println("O número digitado foi: " + numVereador);
                                Candidatos candV = listVereadores.localizarPorNum(numVereador);
                                System.out.println(candV);
                                System.out.println("------------------------------------------------------------------------");
                                System.out.println("\n Digite 0 e tecle enter para continuar.....");
                                sc.nextInt();
                                listVereadores.lancarVoto(numVereador);
                                System.out.println("\n Digite 0 e tecle enter para continuar.....");
                                sc.nextInt();

                                limpaTela();
                                listPrefeitos.imprimir();
                                System.out.println("\n------------------------------------------------------------------------");
                                System.out.println("Digite o número do seu candidato a Prefeito:");
                                sc.nextLine();
                                String numPrefeito = sc.nextLine();
                                System.out.println("O número digitado para seu voto a prefeito foi: " + numPrefeito);
                                Candidatos candP = listPrefeitos.localizarPorNum(numPrefeito);
                                System.out.println(candP);
                                System.out.println("------------------------------------------------------------------------");
                                System.out.println("\n Digite 0 e tecle enter para continuar.....");
                                sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar

                                listPrefeitos.lancarVoto(numPrefeito);

                                System.out.println("Votos recebidos!!!");

                                listEleitores.atualizarStatusEleitor(titulo);// vai atualizar o status do eleitor

                                System.out.println("\n Digite 0 e tecle enter para continuar.....");
                                sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar
                            }
                        } else if (escolhaMenuVotacao == 2) {
                            System.out.println("Digite o Titulo:");
                            sc.nextLine();
                            titulo = sc.nextLine();

                            justificar(urnaLocal.getMunicipio(), urnaLocal.getZonaEleitoral(), urnaLocal.getSecaoEleitoral(), titulo, listJustificativas);
                            System.out.println("\n Digite 0 e tecle enter para continuar.....");
                            sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar

                        } else if (escolhaMenuVotacao == 0) {
                            emVotacao = false;
                        }
                    } while (emVotacao);
                }
                case 5 -> {
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("           5 - Finalizar Votação");
                    System.out.println("----------------------------------------------------------\n");
                    System.out.println("O resultado final da votação é:\n");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("Titulos justificados\n");
                    listJustificativas.imprimirJustificativas();
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("Lista detalhada dos eleitores desta urna\n");
                    listEleitores.imprimirDetalhes();
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("Votos dos candidatos a vereador desta urna");
                    listVereadores.imprimirVotos();
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("Votos dos candidatos a Prefeito desta urna");
                    listPrefeitos.imprimirVotos();
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("\n Digite 0 e tecle enter para continuar.....");
                    sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar
                }
                case 6 -> {
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("           6 - Exportar dados da votação");
                    System.out.println("----------------------------------------------------------\n");
                    File exportaResultado = new File(dirExportar + "\\ResultadosCandidatos.txt");
                    File exportaResultado2 = new File(dirExportar + "\\Justificados.txt");

                    ListaEleitores nLista = new ListaEleitores();
//                    nLista.exportaArquivo(listJustificativas,listEleitores, exportaResultado2);

                    listJustificativas.exportaArquivo(listJustificativas, exportaResultado2);
                    listEleitores.exportaArquivo(listEleitores, exportaResultado2);
                    listVereadores.exportaArquivo(listVereadores, exportaResultado);
                    listPrefeitos.exportaArquivo(listPrefeitos, exportaResultado);

                    System.out.println("\n Digite 0 e tecle enter para continuar.....");
                    sc.nextInt();// coloquei apenas para pausar a tela um pouco antes dele mudar
                }
                case 0 -> {
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("           0 -  Programa finalizado!!!!!");
                    System.out.println("----------------------------------------------------------\n");
                    continua = false;
                }
                default -> {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Código não existente!!!!!!!!!!!");
                    System.out.println("----------------------------------------------------------\n");
                }
            }
        } while (continua);
        sc.close();
    }

    public Eleitores localizarTitulo(ListaEleitores list, String numTitulo) {
        {
            System.out.println("Localizar Titulo - ENTROU");
            return list.localizar(numTitulo);
        }
    }

    public void limpaTela() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");

    }

    public void justificar(String muncipio, String zona, String secao, String titulo, ListaEleitores listJustif) {
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("A justificativa  de voto - entrou");
//        Eleitores eleitor = new Eleitores(titulo, "J");
        Eleitores eleitor = new Eleitores("", titulo, muncipio, zona, secao, "J");
        listJustif.inserirFinal(eleitor);
        System.out.println("Voto Justificado!!!");
        listJustif.imprimir();
    }

    public void lerArquivo(String file) throws IOException {
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

    public Urnas lerArqDadosUrna(String file) throws IOException {
        String linha;
        String[] parts;
        boolean passouPrimeiraLinha = false;
        String cidade, estado, zona, secao;
        Urnas urna;

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        Eleitores el;
        ListaEleitores lista = new ListaEleitores();

        // imprime linha a linha
        while (true) {

            linha = br.readLine();
            parts = linha.split(";\s");
            cidade = parts[0];
            estado = parts[1];
            zona = parts[2];
            secao = parts[3];
            urna = new Urnas(cidade, estado, zona, secao);
            break;
        }

        fr.close();
        br.close();
        System.out.println("\n Dados da Urna carregados com sucesso!!!!\n");
        System.out.println("Informações da Urna:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(urna);
        System.out.println("----------------------------------------------------------------------");
        return urna;
    }

    public ListaEleitores lerArqCriarLista(String file) throws IOException {
        String linha;
        String[] parts;
        FileReader fr = new FileReader(file);
        boolean passouPrimeiraLinha = false;
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

        System.out.println("Lista de titulos de eleitores carregados com sucesso!!!!");
        System.out.println("---------------------------------------------------------------");
        fr.close();
        br.close();
        return lista;
    }

    public void lerArqCriarListaCand(String file, ListaCandidatos prefeitos, ListaCandidatos vereadores) throws IOException {
        System.out.println("Carregar dados dos candidatos - ENTROU");
        System.out.println("----------------------------------------------------------------\n");

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
                // System.out.println("Este é o cargo : " + cargo);

                if (cargo.equals("P")) {// vai criar a lista de prefeito

                    cand = new Candidatos(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
                    prefeitos.inserirFinal(cand);

                } else {

                    cand = new Candidatos(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
                    vereadores.inserirFinal(cand);
                }
            }
            passouPrimeiraLinha = true;
        }
        fr.close();
        br.close();
    }

    public File encontraArquivoUrnaExportado(String municipio, String estado, String zona, String secao) throws IOException {
        int i = 0;
        boolean termina = false;
        File arqExportado = new File(dirExportar + "\\ExportarUrnas" + i + ".txt");
        while (!termina) {
            arqExportado = new File(dirExportar + "\\ExportarUrnas" + i + ".txt");
            FileReader fr = new FileReader(arqExportado);
            BufferedReader br = new BufferedReader(fr);
            String line;

            line = br.readLine();
            String[] parts = line.split(";\s");

            if (parts[0].equals(municipio) && parts[1].equals(estado) && parts[2].equals(zona) && parts[3].equals(secao)) {
                termina = true;
                return arqExportado;
            }
            i++;
        }
        return arqExportado;
    }

    public File escontraArquivoCandidatosExportados(String municipio, String estado) throws IOException {
        int i = 0;
        boolean termina = false;
        File arqExportado = new File(dirExportar + "\\ExportarCandidatos" + i + ".txt");
        while (!termina) {
            arqExportado = new File(dirExportar + "\\ExportarCandidatos" + i + ".txt");
            FileReader fr = new FileReader(arqExportado);
            BufferedReader br = new BufferedReader(fr);
            String line;

            line = br.readLine();
            String[] parts = line.split(";\s");

            if (parts[0].equals(municipio) && parts[1].equals(estado)) {
                termina = true;
                return arqExportado;
            }
            i++;
        }
        return arqExportado;
    }

}