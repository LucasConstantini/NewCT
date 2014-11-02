package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;

public class Despesa extends BasePOJO {

    private byte[] foto;
    private Viagem viagem;
    private CategoriaDespesa categoriaDespesa;
    private Double valor;
    private String nomeEstabelecimento;
    private String DataCompra;
    private String horaCompra;
    private Long cnpj;
    private String descritivo;
    private Double valorRealAutorizado;

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public CategoriaDespesa getCategoriaDespesa() {
        return categoriaDespesa;
    }

    public void setCategoriaDespesa(CategoriaDespesa categoriaDespesa) {
        this.categoriaDespesa = categoriaDespesa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public String getDataCompra() {
        return DataCompra;
    }

    public void setDataCompra(String DataCompra) {
        this.DataCompra = DataCompra;
    }

    public String getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(String horaCompra) {
        this.horaCompra = horaCompra;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    public Double getValorRealAutorizado() {
        return valorRealAutorizado;
    }

    public void setValorRealAutorizado(Double valorRealAutorizado) {
        this.valorRealAutorizado = valorRealAutorizado;
    }


}
