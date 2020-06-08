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

        if (listaVazia()) {
            System.out.println("A lista de partidos está vazia");
        } else {
            while (aux != null) {
                System.out.println(aux.item.getNome() + " - " + aux.item.getSigla());
                aux = aux.proximo;
            }
        }
    }

    public Boolean listaVazia() {
        return primeiro == ultimo;
    }

    public void concatenar(ListaPartido lista) {
        ultimo.proximo = lista.ultimo;
        ultimo = ultimo.proximo;
    }

    public Partidos localizar(String siglaPartido) {
        CelulaPartidos aux;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getSigla().equals(siglaPartido)) {
                return aux.item;
            } else {
                aux = aux.proximo;
            }
        }
        return null;
    }

    public int tamLista(){
        int cont = 0;
        CelulaPartidos aux = primeiro.proximo;
        while (aux != null){
            cont++;
            aux = aux.proximo;
        }
        return cont;
    }
}
