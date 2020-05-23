package lista;

import dadosDeCadastros.Candidatos;

public class CelulaCandidatos {
    Candidatos item;
    CelulaCandidatos proximo;

    CelulaCandidatos(){
        item = new Candidatos();
        proximo = null;
    }
}
