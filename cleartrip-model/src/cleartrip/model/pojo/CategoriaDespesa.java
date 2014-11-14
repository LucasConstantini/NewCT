package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;

public class CategoriaDespesa extends BasePOJO {

    
    private String nome;
    private Double valorLimite;
    private Empresa empresa;
   

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valorLimite
     */
    public Double getValorLimite() {
        return valorLimite;
    }

    /**
     * @param valorLimite the valorLimite to set
     */
    public void setValorLimite(Double valorLimite) {
        this.valorLimite = valorLimite;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
}