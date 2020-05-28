package dadosDeCadastros;

public class Municipios {
    private String nome;
    private String estado;
    private int qtHabitantes;
    private int vagasVereador;

    public Municipios() {
        nome = "";
        estado = "";
        qtHabitantes = 0;
        vagasVereador = 0;
    }

    public Municipios(String nome, String estado, int qtHabitantes, int vagasVereador) {
        this.nome = nome;
        this.estado = estado;
        this.qtHabitantes = qtHabitantes;
        this.vagasVereador = vagasVereador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getQtHabitantes() {
        return qtHabitantes;
    }

    public void setQtHabitantes(int qtHabitantes) {
        this.qtHabitantes = qtHabitantes;
    }

    public int getVagasVereador() {
        return vagasVereador;
    }

    public void setVagasVereador(int vagasVereador) {
        this.vagasVereador = vagasVereador;
    }


}
