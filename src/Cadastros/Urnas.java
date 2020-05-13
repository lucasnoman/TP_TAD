package Cadastros;

public class Urnas {
    private String municipio;
    private String zonaEleitoral;
    private String secaoEleitoral;

    public Urnas() {
        municipio = "";
        zonaEleitoral = "";
        secaoEleitoral = "";
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
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

    public Urnas(String municipio, String zonaEleitoral, String secaoEleitoral) {
        this.municipio = municipio;
        this.zonaEleitoral = zonaEleitoral;
        this.secaoEleitoral = secaoEleitoral;
    }
}
