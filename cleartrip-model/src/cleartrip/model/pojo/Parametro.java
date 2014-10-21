package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;
import java.util.Date;
import java.sql.Time;

public class Parametro extends BasePOJO {

   
    private Empresa empresa;
    private Time manha;
    private Time tarde;
    private Time noite;
    private Double custoKm;
    private Integer margemDeslocamento;
    private Date dataInicio;
    private Date dataTermino;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Time getManha() {
        return manha;
    }

    public void setManha(Time manha) {
        this.manha = manha;
    }

    public Time getTarde() {
        return tarde;
    }

    public void setTarde(Time tarde) {
        this.tarde = tarde;
    }

    public Time getNoite() {
        return noite;
    }

    public void setNoite(Time noite) {
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
}