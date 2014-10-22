package cleartrip.model.base.service;

import cleartrip.model.base.BaseService;
import cleartrip.model.pojo.Despesa;

public interface BaseDespesaService extends BaseService<Despesa> {

    public void setImagem(byte[] imagem) throws Exception;

    public byte[] getImagem(Long id) throws Exception;
}
