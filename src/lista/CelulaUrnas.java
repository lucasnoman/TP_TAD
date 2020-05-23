package lista;

import dadosDeCadastros.Urnas;

public class CelulaUrnas {
    Urnas item;
    CelulaUrnas proximo;

    CelulaUrnas() {
        item = new Urnas();
        proximo = null;
    }
}
