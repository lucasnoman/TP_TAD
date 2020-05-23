package lista;

import dadosDeCadastros.Candidatos;

public class ListaCandidatos {
    private CelulaCandidatos primeiro;
    private CelulaCandidatos ultimo;

    public ListaCandidatos() {
        primeiro = new CelulaCandidatos();
        ultimo = primeiro;
    }

    public void inserirFinal(Candidatos p) {
        CelulaCandidatos aux = new CelulaCandidatos();
        ultimo.proximo = aux;
        aux.item = p;
        ultimo = ultimo.proximo;
    }

    public void imprimir() {
        CelulaCandidatos aux;
        aux = primeiro.proximo;

        if (listaVazia()) {
            System.out.println("A lista de candidatos está vazia");
        } else {
            while (aux != null) {
                System.out.println(aux.item.getNome() + " - " + aux.item.getNumero() + " - " + aux.item.getMunicipio() + " - " + aux.item.getEstado() + " - " + aux.item.getPartido() + " - " + aux.item.getCargo());
                aux = aux.proximo;
            }
        }
    }

    public Boolean listaVazia() {
        return primeiro == ultimo;
    }

    public void concatenar(ListaCandidatos lista) {
        ultimo.proximo = lista.ultimo;
        ultimo = ultimo.proximo;
    }

    public Candidatos localizar(String nomeCandidato) {
        CelulaCandidatos aux;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getNome().equals(nomeCandidato)) {
                return aux.item;
            } else {
                aux = aux.proximo;
            }
        }
        return null;
    }
}
