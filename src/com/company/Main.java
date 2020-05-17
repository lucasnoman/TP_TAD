package com.company;
import cadastroArquivo.Cadastro;
import cadastroArquivo.Exportar;
import leituraArquivo.Leitura;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Cadastro c = new Cadastro();
//        c.escreverPartido();
        Leitura l = new Leitura();
        Exportar e = new Exportar();
        e.exportar();
    }
}
