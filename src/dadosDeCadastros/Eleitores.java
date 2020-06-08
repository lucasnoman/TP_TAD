package dadosDeCadastros;

public class Eleitores {
    private String nome;
    private String numTitulo;
    private String munEleitoral;
    private String zonaEleitoral;
    private String secaoEleitoral;
    private String status;

    public Eleitores() {
        nome = "";
        numTitulo = "";
        munEleitoral = "";
        zonaEleitoral = "";
        secaoEleitoral = "";
    }

    public Eleitores(String numTitulo) {
        this.numTitulo = numTitulo;
        status = "A";//No inicio, todos ainda estão 'A' - ausentes
        //quem tiver votado irá ganhar 'V', e quem justificar , vai ganhar um "J"
    }

    public Eleitores(String numTitulo, String status) {
        this.numTitulo = numTitulo;
        this.status = status;
    }

    public Eleitores(String nome, String numTitulo, String munEleitoral, String zonaEleitoral, String secaoEleitoral) {
        this.nome = nome;
        this.numTitulo = numTitulo;
        this.munEleitoral = munEleitoral;
        this.zonaEleitoral = zonaEleitoral;
        this.secaoEleitoral = secaoEleitoral;
    }

    public Eleitores(String nome, String numTitulo, String munEleitoral, String zonaEleitoral, String secaoEleitoral, String status) {
        this.nome = nome;
        this.numTitulo = numTitulo;
        this.munEleitoral = munEleitoral;
        this.zonaEleitoral = zonaEleitoral;
        this.secaoEleitoral = secaoEleitoral;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumTitulo() {
        return numTitulo;
    }

    public void setNumTitulo(String numTitulo) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
