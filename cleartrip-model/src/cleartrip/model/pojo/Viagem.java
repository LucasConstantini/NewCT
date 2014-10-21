package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;

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
    private String dataPartida;
    private String horaPartida;
    private String aeroportoIda;
    private String ciaAereaIda;
    private String numeroVooIda;
    private String dataCompromisso;
    private String horaCompromisso;
    private String dataVolta;
    private String horaVolta;
    private String aeroportoVolta;
    private String ciaAereaVolta;
    private String numeroVooVolta;
    private Double valorAdiantameto;
    private Double valorReembolso;
    private Double valorRessarcimento;
    private String numeroReciboAdiantamento;
    private String numeroReciboRessarcimento;
    private String relatoViagem;
    private String dataAprovacao;
    private String dataEncerramento;

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    public String getTelefoneDestino() {
        return telefoneDestino;
    }

    public void setTelefoneDestino(String telefoneDestino) {
        this.telefoneDestino = telefoneDestino;
    }

    public String getOutrosMateriais() {
        return outrosMateriais;
    }

    public void setOutrosMateriais(String outrosMateriais) {
        this.outrosMateriais = outrosMateriais;
    }

    public String getCidadePartida() {
        return cidadePartida;
    }

    public void setCidadePartida(String cidadePartida) {
        this.cidadePartida = cidadePartida;
    }

    public String getEnderecoPartida() {
        return enderecoPartida;
    }

    public void setEnderecoPartida(String enderecoPartida) {
        this.enderecoPartida = enderecoPartida;
    }

    public String getTelefonePartida() {
        return telefonePartida;
    }

    public void setTelefonePartida(String telefonePartida) {
        this.telefonePartida = telefonePartida;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    public String getAeroportoIda() {
        return aeroportoIda;
    }

    public void setAeroportoIda(String aeroportoIda) {
        this.aeroportoIda = aeroportoIda;
    }

    public String getCiaAereaIda() {
        return ciaAereaIda;
    }

    public void setCiaAereaIda(String ciaAereaIda) {
        this.ciaAereaIda = ciaAereaIda;
    }

    public String getNumeroVooIda() {
        return numeroVooIda;
    }

    public void setNumeroVooIda(String numeroVooIda) {
        this.numeroVooIda = numeroVooIda;
    }

    public String getDataCompromisso() {
        return dataCompromisso;
    }

    public void setDataCompromisso(String dataCompromisso) {
        this.dataCompromisso = dataCompromisso;
    }

    public String getHoraCompromisso() {
        return horaCompromisso;
    }

    public void setHoraCompromisso(String horaCompromisso) {
        this.horaCompromisso = horaCompromisso;
    }

    public String getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(String dataVolta) {
        this.dataVolta = dataVolta;
    }

    public String getHoraVolta() {
        return horaVolta;
    }

    public void setHoraVolta(String horaVolta) {
        this.horaVolta = horaVolta;
    }

    public String getAeroportoVolta() {
        return aeroportoVolta;
    }

    public void setAeroportoVolta(String aeroportoVolta) {
        this.aeroportoVolta = aeroportoVolta;
    }

    public String getCiaAereaVolta() {
        return ciaAereaVolta;
    }

    public void setCiaAereaVolta(String ciaAereaVolta) {
        this.ciaAereaVolta = ciaAereaVolta;
    }

    public String getNumeroVooVolta() {
        return numeroVooVolta;
    }

    public void setNumeroVooVolta(String numeroVooVolta) {
        this.numeroVooVolta = numeroVooVolta;
    }

    public Double getValorAdiantameto() {
        return valorAdiantameto;
    }

    public void setValorAdiantameto(Double valorAdiantameto) {
        this.valorAdiantameto = valorAdiantameto;
    }

    public Double getValorReembolso() {
        return valorReembolso;
    }

    public void setValorReembolso(Double valorReembolso) {
        this.valorReembolso = valorReembolso;
    }

    public Double getValorRessarcimento() {
        return valorRessarcimento;
    }

    public void setValorRessarcimento(Double valorRessarcimento) {
        this.valorRessarcimento = valorRessarcimento;
    }

    public String getNumeroReciboAdiantamento() {
        return numeroReciboAdiantamento;
    }

    public void setNumeroReciboAdiantamento(String numeroReciboAdiantamento) {
        this.numeroReciboAdiantamento = numeroReciboAdiantamento;
    }

    public String getNumeroReciboRessarcimento() {
        return numeroReciboRessarcimento;
    }

    public void setNumeroReciboRessarcimento(String numeroReciboRessarcimento) {
        this.numeroReciboRessarcimento = numeroReciboRessarcimento;
    }

    public String getRelatoViagem() {
        return relatoViagem;
    }

    public void setRelatoViagem(String relatoViagem) {
        this.relatoViagem = relatoViagem;
    }

    public String getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(String dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public String getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(String dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
}