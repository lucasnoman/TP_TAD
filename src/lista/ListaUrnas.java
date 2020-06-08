package lista;

import dadosDeCadastros.Urnas;

public class ListaUrnas {
    private CelulaUrnas primeiro;
    private CelulaUrnas ultimo;

    public ListaUrnas() {
        ultimo = primeiro = new CelulaUrnas();
    }

    public void inserirFinal(Urnas p) {
        CelulaUrnas aux = new CelulaUrnas();
        ultimo.proximo = aux;
        aux.item = p;
        ultimo = ultimo.proximo;
    }

    public void imprimir() {
        CelulaUrnas aux;
        aux = primeiro.proximo;
        int i = 0;

        if (listaVazia()) {
            System.out.println("A lista de urnas está vazia");
        } else {
            while (aux != null) {
                System.out.println(i + ": " + aux.item.getMunicipio() + " - " + aux.item.getZonaEleitoral() + " - "
                        + aux.item.getSecaoEleitoral());
                i++;
                aux = aux.proximo;
            }
        }
    }

    public Boolean listaVazia() {
        return primeiro == ultimo;
    }

    public void concatenar(ListaUrnas lista) {
        ultimo.proximo = lista.ultimo;
        ultimo = ultimo.proximo;
    }

    public Urnas localizar(String municipio, String zona, String secao) {
        CelulaUrnas aux;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getMunicipio().equals(municipio) && aux.item.getZonaEleitoral().equals(zona)
                    && aux.item.getSecaoEleitoral().equals(secao)) {
                return aux.item;
            } else {
                aux = aux.proximo;
            }
        }
        return null;
    }

    // Conta a quantidade de registro de Urnas
    public int tamLista() {
        int cont = 0;
        CelulaUrnas aux = primeiro.proximo;
        while (aux != null) {
            cont++;
            aux = aux.proximo;
        }
        return cont;
    }
}
