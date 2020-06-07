package com.company;

import manipulaArquivos.AddArqTAD;
import menu.Menu;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        AddArqTAD at = new AddArqTAD(); // Essa classe lê o conteúdo do arquivo, faz o split e já coloca dentro da lista
        at.exportaCandidatos();
        at.exportarUrnas();

//        at.teste().imprimir();

        Menu menu = new Menu();
//        menu.opcoesTRE();
    }

}
