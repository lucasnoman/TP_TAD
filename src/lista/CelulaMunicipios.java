package lista;

import dadosDeCadastros.Municipios;

public class CelulaMunicipios {
    Municipios item;
    CelulaMunicipios proximo;

    CelulaMunicipios() {
        item = new Municipios();
        proximo = null;
    }
}
