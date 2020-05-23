package lista;

import dadosDeCadastros.Eleitores;

public class CelulaEleitores {
    Eleitores item;
    CelulaEleitores proximo;

    CelulaEleitores() {
        item = new Eleitores();
        proximo = null;
    }
}