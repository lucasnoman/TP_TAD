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
                System.out.println(
                        aux.item.getNome() + " - " + aux.item.getNumTitulo() + " - " + aux.item.getMunEleitoral()
                                + " - " + aux.item.getZonaEleitoral() + " - " + aux.item.getSecaoEleitoral());
                aux = aux.proximo;
            }
        }
    }

    // usado para imprimir os eleitores que justificaram
    public void imprimirJustificativas() {
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

    // imprime na tela os eleitores carregados
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

    // imprime o núm do título e se votou ou esteve ausente em relação a devida urna
    public void imprimirDetalhes() {
        CelulaEleitores aux;
        aux = primeiro.proximo;

        if (listaVazia()) {
            System.out.println("A lista de eleitores está vazia");
        } else {
            while (aux != null) {
                System.out
                        .println("Número do titulo: " + aux.item.getNumTitulo() + " - Status: " + aux.item.getStatus());
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

    // Caso o eleitor tenha votado, atualiza a variável "status" para V
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

    // Cria uma lista apenas com os eleitores de suas recpectivas urnas
    // Recebe como parâmetro os dados obtidos no arquivo "Municipios"
    public ListaEleitores insereListaUrnaEleitor(String municipio, String zonaEleitoral, String secaoEleitoral) {
        CelulaEleitores aux = primeiro.proximo;
        ListaEleitores lista = new ListaEleitores();

        while (aux != null) {
            // Compara os dados dos parâmetros com os devidos dados da lista de eleitores
            if (aux.item.getMunEleitoral().equals(municipio) && aux.item.getZonaEleitoral().equals(zonaEleitoral)
                    && aux.item.getSecaoEleitoral().equals(secaoEleitoral)) {
                lista.inserirFinal(aux.item);
                aux = aux.proximo;
            } else {
                aux = aux.proximo;
            }
        }
        return lista;
    }

    // Exporta o arquivo ao receber a lista com os candidatos da referida urna e o devido arquivo
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

    public int tamLista() {
        int cont = 0;
        CelulaEleitores aux = primeiro.proximo;
        while (aux != null) {
            cont++;
            aux = aux.proximo;
        }
        return cont;
    }
}
