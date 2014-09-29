package cleartrip.model.base.service;

import cleartrip.model.base.BaseService;
import cleartrip.model.pojo.Usuario;

public interface BaseUsuarioService extends BaseService<Usuario> {

    public Usuario login(String login, String senha);

    public String encode(String input);
}
