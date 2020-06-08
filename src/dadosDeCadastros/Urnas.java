package dadosDeCadastros;

public class Urnas {
    private String municipio;
    private String estado;
    private String zonaEleitoral;
    private String secaoEleitoral;

    public Urnas() {
        municipio = "";
        estado = "";
        zonaEleitoral = "";
        secaoEleitoral = "";
    }

    public Urnas(String municipio, String estado, String zonaEleitoral, String secaoEleitoral) {
        this.municipio = municipio;
        this.estado = estado;
        this.zonaEleitoral = zonaEleitoral;
        this.secaoEleitoral = secaoEleitoral;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        return "Urna [municipio=" + municipio + ", estado=" + estado + ", zonaEleitoral=" + zonaEleitoral + ", secaoEleitoral=" + secaoEleitoral + "]";
    }
}
