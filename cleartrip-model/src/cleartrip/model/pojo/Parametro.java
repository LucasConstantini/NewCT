package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;

public class Parametro extends BasePOJO {

    private Empresa empresa;
    private String manha;
    private String tarde;
    private String noite;
    private Double custoKm;
    private Integer margemDeslocamento;
    private String dataInicio;
    private String dataTermino;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getManha() {
        return manha;
    }

    public void setManha(String manha) {
        this.manha = manha;
    }

    public String getTarde() {
        return tarde;
    }

    public void setTarde(String tarde) {
        this.tarde = tarde;
    }

    public String getNoite() {
        return noite;
    }

    public void setNoite(String noite) {
        this.noite = noite;
    }

    public Double getCustoKm() {
        return custoKm;
    }

    public void setCustoKm(Double custoKm) {
        this.custoKm = custoKm;
    }

    public Integer getMargemDeslocamento() {
        return margemDeslocamento;
    }

    public void setMargemDeslocamento(Integer margemDeslocamento) {
        this.margemDeslocamento = margemDeslocamento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }
}