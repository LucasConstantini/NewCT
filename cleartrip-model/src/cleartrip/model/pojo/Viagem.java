package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;
import java.sql.Date;
import java.sql.Time;

public class Viagem extends BasePOJO {

    private Transporte transporte;
    private Usuario usuario;
    private String status;
    private String destino;
    private String motivo;
    private String enderecoDestino;
    private String telefoneDestino;
    private String outrosMateriais;
    private String cidadePartida;
    private String enderecoPartida;
    private String telefonePartida;
    private Date dataPartida;
    private Time horaPartida;
    private String aeroportoIda;
    private String ciaAereaIda;
    private String numeroVooIda;
    private Date dataCompromisso;
    private Time horaCompromisso;
    private Date dataVolta;
    private Time horaVolta;
    private String aeroportoVolta;
    private String ciaAereaVolta;
    private String numeroVooVolta;
    private Double valorAdiantameto;
    private Double valorReembolso;
    private Double valorRessarcimento;
    private String numeroReciboAdiantamento;
    private String numeroReciboRessarcimento;
    private String relatoViagem;
    private Date dataAprovacao;
    private Date dataEncerramento;

    /**
     * @return the transporte
     */
    public Transporte getTransporte() {
        return transporte;
    }

    /**
     * @param transporte the transporte to set
     */
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the enderecoDestino
     */
    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    /**
     * @param enderecoDestino the enderecoDestino to set
     */
    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    /**
     * @return the telefoneDestino
     */
    public String getTelefoneDestino() {
        return telefoneDestino;
    }

    /**
     * @param telefoneDestino the telefoneDestino to set
     */
    public void setTelefoneDestino(String telefoneDestino) {
        this.telefoneDestino = telefoneDestino;
    }

    /**
     * @return the outrosMateriais
     */
    public String getOutrosMateriais() {
        return outrosMateriais;
    }

    /**
     * @param outrosMateriais the outrosMateriais to set
     */
    public void setOutrosMateriais(String outrosMateriais) {
        this.outrosMateriais = outrosMateriais;
    }

    /**
     * @return the cidadePartida
     */
    public String getCidadePartida() {
        return cidadePartida;
    }

    /**
     * @param cidadePartida the cidadePartida to set
     */
    public void setCidadePartida(String cidadePartida) {
        this.cidadePartida = cidadePartida;
    }

    /**
     * @return the enderecoPartida
     */
    public String getEnderecoPartida() {
        return enderecoPartida;
    }

    /**
     * @param enderecoPartida the enderecoPartida to set
     */
    public void setEnderecoPartida(String enderecoPartida) {
        this.enderecoPartida = enderecoPartida;
    }

    /**
     * @return the telefonePartida
     */
    public String getTelefonePartida() {
        return telefonePartida;
    }

    /**
     * @param telefonePartida the telefonePartida to set
     */
    public void setTelefonePartida(String telefonePartida) {
        this.telefonePartida = telefonePartida;
    }

    /**
     * @return the dataPartida
     */
    public Date getDataPartida() {
        return dataPartida;
    }

    /**
     * @param dataPartida the dataPartida to set
     */
    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    /**
     * @return the horaPartida
     */
    public Time getHoraPartida() {
        return horaPartida;
    }

    /**
     * @param horaPartida the horaPartida to set
     */
    public void setHoraPartida(Time horaPartida) {
        this.horaPartida = horaPartida;
    }

    /**
     * @return the aeroportoIda
     */
    public String getAeroportoIda() {
        return aeroportoIda;
    }

    /**
     * @param aeroportoIda the aeroportoIda to set
     */
    public void setAeroportoIda(String aeroportoIda) {
        this.aeroportoIda = aeroportoIda;
    }

    /**
     * @return the ciaAereaIda
     */
    public String getCiaAereaIda() {
        return ciaAereaIda;
    }

    /**
     * @param ciaAereaIda the ciaAereaIda to set
     */
    public void setCiaAereaIda(String ciaAereaIda) {
        this.ciaAereaIda = ciaAereaIda;
    }

    /**
     * @return the numeroVooIda
     */
    public String getNumeroVooIda() {
        return numeroVooIda;
    }

    /**
     * @param numeroVooIda the numeroVooIda to set
     */
    public void setNumeroVooIda(String numeroVooIda) {
        this.numeroVooIda = numeroVooIda;
    }

    /**
     * @return the daataCompromisso
     */
    public Date getDataCompromisso() {
        return dataCompromisso;
    }

    /**
     * @param daataCompromisso the daataCompromisso to set
     */
    public void setDataCompromisso(Date dataCompromisso) {
        this.dataCompromisso = dataCompromisso;
    }

    /**
     * @return the horaCompromisso
     */
    public Time getHoraCompromisso() {
        return horaCompromisso;
    }

    /**
     * @param horaCompromisso the horaCompromisso to set
     */
    public void setHoraCompromisso(Time horaCompromisso) {
        this.horaCompromisso = horaCompromisso;
    }

    /**
     * @return the dataVolta
     */
    public Date getDataVolta() {
        return dataVolta;
    }

    /**
     * @param dataVolta the dataVolta to set
     */
    public void setDataVolta(Date dataVolta) {
        this.dataVolta = dataVolta;
    }

    /**
     * @return the horaVolta
     */
    public Time getHoraVolta() {
        return horaVolta;
    }

    /**
     * @param horaVolta the horaVolta to set
     */
    public void setHoraVolta(Time horaVolta) {
        this.horaVolta = horaVolta;
    }

    /**
     * @return the aeroportoVolta
     */
    public String getAeroportoVolta() {
        return aeroportoVolta;
    }

    /**
     * @param aeroportoVolta the aeroportoVolta to set
     */
    public void setAeroportoVolta(String aeroportoVolta) {
        this.aeroportoVolta = aeroportoVolta;
    }

    /**
     * @return the ciaAereaVolta
     */
    public String getCiaAereaVolta() {
        return ciaAereaVolta;
    }

    /**
     * @param ciaAereaVolta the ciaAereaVolta to set
     */
    public void setCiaAereaVolta(String ciaAereaVolta) {
        this.ciaAereaVolta = ciaAereaVolta;
    }

    /**
     * @return the numeroVooVolta
     */
    public String getNumeroVooVolta() {
        return numeroVooVolta;
    }

    /**
     * @param numeroVooVolta the numeroVooVolta to set
     */
    public void setNumeroVooVolta(String numeroVooVolta) {
        this.numeroVooVolta = numeroVooVolta;
    }

    /**
     * @return the valorAdiantameto
     */
    public Double getValorAdiantameto() {
        return valorAdiantameto;
    }

    /**
     * @param valorAdiantameto the valorAdiantameto to set
     */
    public void setValorAdiantameto(Double valorAdiantameto) {
        this.valorAdiantameto = valorAdiantameto;
    }

    /**
     * @return the valorReembolso
     */
    public Double getValorReembolso() {
        return valorReembolso;
    }

    /**
     * @param valorReembolso the valorReembolso to set
     */
    public void setValorReembolso(Double valorReembolso) {
        this.valorReembolso = valorReembolso;
    }

    /**
     * @return the valorRessarcimento
     */
    public Double getValorRessarcimento() {
        return valorRessarcimento;
    }

    /**
     * @param valorRessarcimento the valorRessarcimento to set
     */
    public void setValorRessarcimento(Double valorRessarcimento) {
        this.valorRessarcimento = valorRessarcimento;
    }

    /**
     * @return the numeroReciboAdiantamento
     */
    public String getNumeroReciboAdiantamento() {
        return numeroReciboAdiantamento;
    }

    /**
     * @param numeroReciboAdiantamento the numeroReciboAdiantamento to set
     */
    public void setNumeroReciboAdiantamento(String numeroReciboAdiantamento) {
        this.numeroReciboAdiantamento = numeroReciboAdiantamento;
    }

    /**
     * @return the numeroReciboRessarcimento
     */
    public String getNumeroReciboRessarcimento() {
        return numeroReciboRessarcimento;
    }

    /**
     * @param numeroReciboRessarcimento the numeroReciboRessarcimento to set
     */
    public void setNumeroReciboRessarcimento(String numeroReciboRessarcimento) {
        this.numeroReciboRessarcimento = numeroReciboRessarcimento;
    }

    /**
     * @return the relatoViagem
     */
    public String getRelatoViagem() {
        return relatoViagem;
    }

    /**
     * @param relatoViagem the relatoViagem to set
     */
    public void setRelatoViagem(String relatoViagem) {
        this.relatoViagem = relatoViagem;
    }

    /**
     * @return the dataAprovacao
     */
    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    /**
     * @param dataAprovacao the dataAprovacao to set
     */
    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    /**
     * @return the dataEncerrmento
     */
    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    /**
     * @param dataEncerrmento the dataEncerrmento to set
     */
    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
    
    

   
}