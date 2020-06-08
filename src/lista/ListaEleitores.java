package lista;

import dadosDeCadastros.Eleitores;

import java.io.*;

public class ListaEleitores {
    private CelulaEleitores primeiro;
    private CelulaEleitores ultimo;

    public ListaEleitores() {
        primeiro = new CelulaEleitores();
        ultimo = primeiro;
    }

    public void inserirFinal(Eleitores p) {
        CelulaEleitores aux = new CelulaEleitores();
        ultimo.proximo = aux;
        aux.item = p;
        ultimo = ultimo.proximo;
    }

    public void imprimir() {
        CelulaEleitores aux;
        aux = primeiro.proximo;

        if (listaVazia()) {
            System.out.println("A lista de eleitores está vazia");
        } else {
            while (aux != null) {
                System.out.println(aux.item.getNome() + " - " + aux.item.getNumTitulo() + " - " + aux.item.getMunEleitoral() + " - " + aux.item.getZonaEleitoral() + " - " + aux.item.getSecaoEleitoral());
//                System.out.println(aux.item.getNumTitulo());
                aux = aux.proximo;
            }
        }
    }

    public void imprimirDadosEleitores() {
        CelulaEleitores aux;
        aux = primeiro.proximo;

        if (listaVazia()) {
            System.out.println("A lista de eleitores está vazia");
        } else {
            while (aux != null) {
                System.out.println(aux.item.getNumTitulo());
                aux = aux.proximo;
            }
        }
    }

    public void imprimirDetalhes() {
        CelulaEleitores aux;
        aux = primeiro.proximo;

        if (listaVazia()) {
            System.out.println("A lista de eleitores está vazia");
        } else {
            while (aux != null) {
                System.out.println("Número do titulo: " + aux.item.getNumTitulo() + " - Status: " + aux.item.getStatus());
                aux = aux.proximo;
            }
        }
    }

    public Boolean listaVazia() {
        return primeiro == ultimo;
    }

    public void concatenar(ListaEleitores lista) {
        ultimo.proximo = lista.ultimo;
        ultimo = ultimo.proximo;
    }

    public Eleitores localizar(String numTitulo) {
        CelulaEleitores aux;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getNumTitulo().equals(numTitulo)) {
                return aux.item;
            } else {
                aux = aux.proximo;
            }
        }
        return null;
    }

    public void atualizarStatusEleitor(String numTitulo) {
        CelulaEleitores aux;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getNumTitulo().equals(numTitulo)) {
                aux.item.setStatus("V");
                System.out.println("O status do eleitor foi atualizado com sucesso!!!");
                break;
            } else {
                aux = aux.proximo;
            }
        }
    }

    public ListaEleitores insereListaUrnaEleitor(String municipio, String zonaEleitoral, String secaoEleitoral) {
        CelulaEleitores aux = primeiro.proximo;
        ListaEleitores lista = new ListaEleitores();

        while (aux != null) {
            if (aux.item.getMunEleitoral().equals(municipio) && aux.item.getZonaEleitoral().equals(zonaEleitoral) && aux.item.getSecaoEleitoral().equals(secaoEleitoral)) {
                lista.inserirFinal(aux.item);
                aux = aux.proximo;
            } else {
                aux = aux.proximo;
            }
        }
        return lista;
    }

    public void exportaArquivo(ListaEleitores lista, File file) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        CelulaEleitores aux = lista.primeiro;

        while (aux != null) {
            bw.write(aux.item.getNumTitulo());
            aux = aux.proximo;
            bw.newLine();
        }
        bw.close();
    }

    public int tamLista(){
        int cont = 0;
        CelulaEleitores aux = primeiro.proximo;
        while (aux != null){
            cont++;
            aux = aux.proximo;
        }
        return cont;
    }
}
