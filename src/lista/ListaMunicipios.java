package lista;

import dadosDeCadastros.Municipios;

public class ListaMunicipios {
    private CelulaMunicipios primeiro;
    private CelulaMunicipios ultimo;

    public ListaMunicipios() {
        primeiro = new CelulaMunicipios();
        ultimo = primeiro;
    }

    public void inserirFinal(Municipios p) {
        CelulaMunicipios aux = new CelulaMunicipios();
        ultimo.proximo = aux;
        aux.item = p;
        ultimo = ultimo.proximo;
    }

    public void imprimir() {
        CelulaMunicipios aux;
        aux = primeiro.proximo;

        if (listaVazia()) {
            System.out.println("A lista de municípios está vazia");
        } else {
            while (aux != null) {
                System.out.println(aux.item.getNome() + " - " + aux.item.getEstado() + " - " + aux.item.getQtHabitantes() + " - " + aux.item.getVagasVereador());
                aux = aux.proximo;
            }
        }
    }

    public Boolean listaVazia() {
        return primeiro == ultimo;
    }

    public void concatenar(ListaMunicipios lista) {
        ultimo.proximo = lista.ultimo;
        ultimo = ultimo.proximo;
    }

    public Municipios localizar(String nome, String estado) {
        CelulaMunicipios aux;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getNome().equals(nome) && aux.item.getEstado().equals(estado)) {
                return aux.item;
            } else {
                aux = aux.proximo;
            }
        }
        return null;
    }
}
