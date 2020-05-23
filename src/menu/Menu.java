package menu;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public void limpaTela() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");

    }

    public void menu() {

        System.out.println("****************************************************************************************");
        System.out.println("                                        Módulo TRE");
        System.out.println("****************************************************************************************");
        System.out.println("    Escolha a opção desejada e tecle enter....");
        System.out.println("\n");
        System.out.println("    1 -  Cadastro de partidos políticos");
        System.out.println("    2 -  Cadastro de municípios:");
        System.out.println("    3 -  Cadastro dos candidatos a prefeito e vereador");
        System.out.println("    4 -  Cadastro dos eleitores");
        System.out.println("    5 -  Cadastro das urnas eletrônicas");
        System.out.println("    6 -  Exportar dados para as urnas eletrônicas");
        System.out.println("    0 -  Para finalizar\n");
        System.out.println("*************************************************************************************");
        System.out.println("\n");
        System.out.println("    Informe sua opção: ");
    }

    public void opcoes() throws IOException, InterruptedException {
        boolean continua = true;
        Scanner sc = new Scanner(System.in);
        int escolhaMenu = 0;

        do {
            menu();
            escolhaMenu = sc.nextInt();
            switch (escolhaMenu) {
                case 1:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Cadastro de partidos políticos");
                    System.out.println("----------------------------------------------------------\n");
                    break;

                case 2:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Cadastro de municípios");
                    System.out.println("----------------------------------------------------------\n");
                    break;

                case 3:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Cadastro dos candidatos a prefeito e vereador");
                    System.out.println("----------------------------------------------------------\n");
                    break;

                case 4:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Cadastro dos eleitores");
                    System.out.println("----------------------------------------------------------\n");

                    break;
                case 5:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Cadastro das urnas eletrônicas");
                    System.out.println("----------------------------------------------------------\n");

                    break;
                case 6:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Exportar dados para as urnas eletrônicas");
                    System.out.println("----------------------------------------------------------\n");

                    break;
                case 0:
                    limpaTela();
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Programa finalizado!!!!!");
                    System.out.println("----------------------------------------------------------\n");
                    continua = false;

                    break;

                default:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Código não existente!!!!!!!!!!!");
                    System.out.println("----------------------------------------------------------\n");
                    //limpaTela();
                    break;
            }
            escolhaMenu = 0;
        } while (continua);
    }
}