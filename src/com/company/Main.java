package com.company;

import arquivos.AddArqTAD;
import arquivos.AddConteudoArquivo;
import lista.ListaCandidatos;
import lista.ListaPartido;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
//        AddConteudoArquivo c = new AddConteudoArquivo();
//        c.escreverPartido();
//        Leitura l = new Leitura();
//        Exportar e = new Exportar();
//        e.exportar();

        AddArqTAD at = new AddArqTAD();
        String file = "arquivos\\Eleitores.txt";
        at.createADT(file);

        ListaPartido lp = new ListaPartido();
//        lp.imprimir();
    }
}
