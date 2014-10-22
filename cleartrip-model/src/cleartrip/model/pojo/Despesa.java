package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;
import java.sql.Date;
import java.sql.Time;

public class Despesa extends BasePOJO {

    private String foto;
    private Viagem viagem;
    private CategoriaDespesa categoriaDespesa;
    private Double valor;
    private String nomeEstabelecimento;
    private Date DataCompra;
    private Time horaCompra;
    private int cnpj;
    private String descritivo;
    private Double valorRealAutorizado;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
