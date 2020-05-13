package Cadastros;

public class Eleitores {
    private String nome;
    private int numTitulo;
    private String munEleitoral;
    private String zonaEleitoral;
    private String secaoEleitoral;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumTitulo() {
        return numTitulo;
    }

    public void setNumTitulo(int numTitulo) {
        this.numTitulo = numTitulo;
    }

    public String getMunEleitoral() {
        return munEleitoral;
    }

    public void setMunEleitoral(String munEleitoral) {
        this.munEleitoral = munEleitoral;
    }

    public String getZonaEleitoral() {
        return zonaEleitoral;
    }

    public void setZonaEleitoral(String zonaEleitoral) {
        this.zonaEleitoral = zonaEleitoral;
    }

    public String getSecaoEleitoral() {
        return secaoEleitoral;
    }

    public void setSecaoEleitoral(String secaoEleitoral) {
        this.secaoEleitoral = secaoEleitoral;
    }

    public Eleitores() {
        nome = "";
        numTitulo = 0;
        munEleitoral = "";
        zonaEleitoral = "";
        secaoEleitoral = "";
    }

    public Eleitores(String nome, int numTitulo, String munEleitoral, String zonaEleitoral, String secaoEleitoral) {
        this.nome = nome;
        this.numTitulo = numTitulo;
        this.munEleitoral = munEleitoral;
        this.zonaEleitoral = zonaEleitoral;
        this.secaoEleitoral = secaoEleitoral;
    }
}
