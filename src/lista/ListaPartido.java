package lista;

import dadosDeCadastros.Partidos;

public class ListaPartido {
    private CelulaPartidos primeiro;
    private CelulaPartidos ultimo;

    public ListaPartido() {
        primeiro = new CelulaPartidos();
        ultimo = primeiro;
    }

    public void inserirFinal(Partidos p) {
        CelulaPartidos aux = new CelulaPartidos();
        ultimo.proximo = aux;
        aux.item = p;
        ultimo = ultimo.proximo;
    }

    public void imprimir() {
        CelulaPartidos aux;
        aux = primeiro.proximo;

        if (aux == null) {
            System.out.println("A lista de partidos está vazia");
        } else {
            while (aux != null) {
                System.out.println("Nome do partido: " + aux.item.getNome() + ", sigla do partido: " + aux.item.getSigla());
                aux = aux.proximo;
            }
        }
    }

    public Boolean listaVazia() {
        if (primeiro == ultimo) {
            return true;
        } else {
            return false;
        }
    }
}
