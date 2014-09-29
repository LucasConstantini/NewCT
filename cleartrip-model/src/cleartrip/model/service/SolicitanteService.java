package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseSolicitanteService;
import cleartrip.model.dao.UsuarioDAO;
import cleartrip.model.pojo.Solicitante;
import cleartrip.model.pojo.Usuario;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolicitanteService implements BaseSolicitanteService {

    @Override
    public void create(Solicitante pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.create(pojo, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public Solicitante readById(Long login) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Solicitante solicitante = null;
        try {
            UsuarioDAO dao = new UsuarioDAO();
            solicitante = (Solicitante) dao.readById(login, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return solicitante;
    }

    @Override
    public List<Solicitante> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Solicitante> lista = new ArrayList<Solicitante>();
        List<Usuario> list = new ArrayList<Usuario>();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            criteria.put(UsuarioDAO.CRITERION_TIPO_EQ, UsuarioDAO.TIPO_SOLICITANTE);
            list = dao.readByCriteria(criteria, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        for (Usuario usuario : list) {
            lista.add((Solicitante)usuario);
        }
        return lista;
    }

    @Override
    public void update(Solicitante pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.update(pojo, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public void delete(Long login) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.delete(login, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
Map<String, String> errors = new HashMap<String, String>();
        if (properties != null) {
            String nome = (String) properties.get("nome");
            String login = (String) properties.get("login");
            String senha = (String) properties.get("senha");
            String nomeEmpresa = (String) properties.get("empresa");
            String cpf = (String) properties.get("cpf");
            String rg = (String) properties.get("rg");
            String emailCorportivo = (String) properties.get("emailCorportivo");
            String tipo = (String) properties.get("tipo");

            if (nome == null || nome.isEmpty()) {
                errors.put("nome", "Campo obrigatório!");
            }
            if (login == null || login.isEmpty()) {
                errors.put("login", "Campo obrigatório!");
            }
            if (senha == null || senha.isEmpty()) {
                errors.put("senha", "Campo obrigatório!");
            }
            if (nomeEmpresa == null || nomeEmpresa.isEmpty()) {
                errors.put("empresa", "Campo Obrigatório, digite o nome da empresa!");
            }
            if (cpf == null || senha.isEmpty()) {
                errors.put("cpf", "Campo obrigatório!");
            }
            if (rg == null || senha.isEmpty()) {
                errors.put("rg", "Campo obrigatório!");
            }
            if (emailCorportivo == null || emailCorportivo.isEmpty()) {
                errors.put("emailCorportivo", "Campo obrigatório!");
            }
            if (tipo == null || tipo.isEmpty()) {
                errors.put("tipo", "Campo obrigatório!");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
}
