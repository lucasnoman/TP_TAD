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

        // Essa classe lê o conteúdo do arquivo, faz o split e já coloca dentro da lista (teremos que arrumar isso depois)
        AddArqTAD at = new AddArqTAD();
        // Apenas indico o caminho do arquivo
        String file = "arquivos\\Eleitores.txt";
        // Executo tudo (leitura, spli, inserção na TAD)
        at.createADT(file);

//        ListaPartido lp = new ListaPartido();
//        lp.imprimir();
    }
}
