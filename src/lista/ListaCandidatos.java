package lista;

import dadosDeCadastros.Candidatos;

import java.io.*;

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
                if (aux.item.getMunicipio() != null) {
                    System.out.println(aux.item.getNome() + " - " + aux.item.getNumero() + " - " + aux.item.getMunicipio() + " - " + aux.item.getEstado() + " - " + aux.item.getPartido() + " - " + aux.item.getCargo());
                    aux = aux.proximo;
                } else {
                    // Imprime no menu os dados da lista de arquivos exportados
                    System.out.println(aux.item.getNome() + " - " + aux.item.getNumero() + " - " + aux.item.getPartido());
                    aux = aux.proximo;
                }

            }
        }
    }

    // Imprime a quantidade de votos do respectivo candidato
    public void imprimirVotos() {
        CelulaCandidatos aux;
        aux = primeiro.proximo;

        if (listaVazia()) {
            System.out.println("A lista de candidatos está vazia");
        } else {
            while (aux != null) {
                System.out.println(aux.item.getNome() + " - " + aux.item.getNumero() + " - " + aux.item.getPartido() + " - " + aux.item.getTotalVotos());
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

    public Candidatos localizarPorNum(String numCandidato) {
        int numero = Integer.parseInt(numCandidato);
        CelulaCandidatos aux;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getNumero() == numero) {
                return aux.item;
            } else {
                aux = aux.proximo;
            }
        }
        return null;
    }

    // vai lançar os votos dos candidatos - vereador e prefeitos
    public void lancarVoto(String numCandidato) {

        System.out.println("lançar votos - ENTROU");
        int numero = Integer.parseInt(numCandidato);
        int auxTotal;
        CelulaCandidatos aux;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getNumero() == numero) {// vai lançar o voto!!!!

                auxTotal = (aux.item.getTotalVotos()) + 1;
                System.out.println("o total de votos era:" + (auxTotal - 1));
                aux.item.setTotalVotos(auxTotal);
                System.out.println("o NOVO - total de votos é:" + (aux.item.getTotalVotos()));
                break;

            } else {
                aux = aux.proximo;
            }
        }
    }

    // Cria uma lista apenas com os candidatos de seus respectivos municípios
    public ListaCandidatos insereListaMunCand(String municipio, String estado) {
        CelulaCandidatos aux = primeiro.proximo;
        ListaCandidatos lista = new ListaCandidatos();

        while (aux != null) {
            // Compara o município encontrado na lista "Municipios.txt" com o munic e est na lista de candidatos
            if (aux.item.getMunicipio().equals(municipio) && aux.item.getEstado().equals(estado)) {
                lista.inserirFinal(aux.item);
            }
            aux = aux.proximo;
        }
        return lista;
    }

    // Exporta o arquivo ao receber a lista com os candidatos da referida urna e o devido arquivo
    public void exportaArquivo(ListaCandidatos lista, File file) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        CelulaCandidatos aux = lista.primeiro.proximo;
        pw.println(""); //pula a primeira linha que já tem os dados da cidade

        while (aux != null) {
            String recebe = aux.item.getNome() + "; " + aux.item.getNumero() + "; " + aux.item.getPartido() + "; " + aux.item.getCargo();
            pw.println(recebe); // escreve no arquivo os dados dos candidatos
            aux = aux.proximo;
        }
        pw.close();
    }

    public int tamLista(){
        int cont = 0;
        CelulaCandidatos aux = primeiro.proximo;
        while (aux != null){
            cont++;
            aux = aux.proximo;
        }
        return cont;
    }
}
