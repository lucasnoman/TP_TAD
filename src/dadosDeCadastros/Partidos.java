package dadosDeCadastros;

public class Partidos {
    private String nome;
    private String sigla;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Partidos() {
        nome = "";
        sigla = "";
    }

    public Partidos(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
}
