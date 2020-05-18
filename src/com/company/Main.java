package com.company;
import arquivos.AddArqTAD;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        AddConteudoArquivo c = new AddConteudoArquivo();
//        c.escreverPartido();
//        Leitura l = new Leitura();
//        Exportar e = new Exportar();
//        e.exportar();

        AddArqTAD at = new AddArqTAD();
        at.createADT();
    }
}
