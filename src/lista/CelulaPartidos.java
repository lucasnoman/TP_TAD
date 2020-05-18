package lista;

import dadosDeCadastros.Partidos;

public class CelulaPartidos {
    Partidos item;
    CelulaPartidos proximo;

    CelulaPartidos() {
        item = new Partidos();
        proximo = null;
    }
}
