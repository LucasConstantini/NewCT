package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;
import java.sql.Date;
import java.sql.Time;

public class Despesa extends BasePOJO {

    private Viagem viagem;
    //private CategoriaDespesa categoriaDespesa;
    private Double valor;
    private String nomeEstabelecimento;
    private Date DataCompra;
    private Time horaCompra;
    private int cnpj;
    private String descritivo;
    private Double valorRealAutorizado;

    /**
     * @return the viagem
     */
    public Viagem getViagem() {
        return viagem;
    }

    /**
     * @param viagem the viagem to set
     */
    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the nomeEstabelecimento
     */
    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    /**
     * @param nomeEstabelecimento the nomeEstabelecimento to set
     */
    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    /**
     * @return the DataCompra
     */
    public Date getDataCompra() {
        return DataCompra;
    }

    /**
     * @param DataCompra the DataCompra to set
     */
    public void setDataCompra(Date DataCompra) {
        this.DataCompra = DataCompra;
    }

    /**
     * @return the horaCompra
     */
    public Time getHoraCompra() {
        return horaCompra;
    }

    /**
     * @param horaCompra the horaCompra to set
     */
    public void setHoraCompra(Time horaCompra) {
        this.horaCompra = horaCompra;
    }

    /**
     * @return the cnpj
     */
    public int getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the descritivo
     */
    public String getDescritivo() {
        return descritivo;
    }

    /**
     * @param descritivo the descritivo to set
     */
    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    /**
     * @return the valorRealAutorizado
     */
    public Double getValorRealAutorizado() {
        return valorRealAutorizado;
    }

    /**
     * @param valorRealAutorizado the valorRealAutorizado to set
     */
    public void setValorRealAutorizado(Double valorRealAutorizado) {
        this.valorRealAutorizado = valorRealAutorizado;
    }
    
        
}