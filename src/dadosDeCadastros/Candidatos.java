package dadosDeCadastros;

public class Candidatos {
    private String nome;
    private int numero;
    private String municipio;
    private String estado;
    private String partido;
    private String cargo;
    int totalVotos;

    public Candidatos() {
        nome = "";
        numero = 0;
        municipio = "";
        estado = "";
        partido = "";
        cargo = "";
    }

    public Candidatos(String nome, int numero, String municipio, String estado, String partido, String cargo) {
        this.nome = nome;
        this.numero = numero;
        this.municipio = municipio;
        this.estado = estado;
        this.partido = partido;
        this.cargo = cargo;
    }

    public Candidatos(String nome, int numero, String partido, String cargo) {
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;
        this.cargo = cargo;
        totalVotos = 0;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    @Override
    public String toString() {
        return "Candidato [nome=" + nome + ", numero=" + numero + ", partido=" + partido + "]";
    }
}
