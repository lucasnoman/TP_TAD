package dadosDeCadastros;

public class Candidatos {
    private String nome;
    private int numero;
    private String municipio;
    private String partido;
    private char cargo;

    public Candidatos() {
        nome = "";
        numero = 0;
        municipio = "";
        partido = "";
        cargo = '0';
    }

    public Candidatos(String nome, int numero, String municipio, String partido, char cargo) {
        this.nome = nome;
        this.numero = numero;
        this.municipio = municipio;
        this.partido = partido;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public char getCargo() {
        return cargo;
    }

    public void setCargo(char cargo) {
        this.cargo = cargo;
    }
}
