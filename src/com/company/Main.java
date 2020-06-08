package com.company;

import manipulaArquivos.AddArqTAD;
import menu.Menu;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        AddArqTAD at = new AddArqTAD(); // Essa classe lê o conteúdo do arquivo, faz o split e já coloca dentro da lista
        Menu menu = new Menu();

        /* Essas duas deverão ser executadas obrigatoriamente na primeira vez que rodar! */
//        at.exportaCandidatos();
//        at.exportarUrnas();

//        at.retornaEleitoresDaUrna().imprimir();
//        at.listaDeUrnas().imprimir();

//        Ordenar o = new Ordenar();
//        o.vetores();

        menu.opcoesMenu();
    }
}
