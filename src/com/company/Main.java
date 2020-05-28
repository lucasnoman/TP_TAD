package com.company;

import arquivos.AddArqTAD;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        AddArqTAD at = new AddArqTAD(); // Essa classe lê o conteúdo do arquivo, faz o split e já coloca dentro da lista (teremos que arrumar isso depois)
        at.createADT(); //Executo tudo (leitura, split, inserção na TAD)
    }
}
