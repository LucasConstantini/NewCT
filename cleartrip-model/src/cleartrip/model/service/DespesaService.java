package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseDespesaService;
import cleartrip.model.dao.DespesaDAO;
import cleartrip.model.pojo.Despesa;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DespesaService implements BaseDespesaService {

    @Override
    public void create(Despesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DespesaDAO dao = new DespesaDAO();//DAO -Data Access Object
            dao.create(pojo, conn);
            conn.commit();
            conn.close();//fecha a conexão para liberar a conexão para o próximo que for usar
        } catch (Exception e) {
            conn.rollback();//desfaz os comando efetuados no banco de dados
            conn.close();
            throw e;//avisar que deu erro
        }

    }

    @Override
    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
        Map<String, String> errors = new HashMap<String, String>();
//        if (properties != null) {
//            Long idViagem = (Long) properties.get("viagem.id");
//            Long idCategoriaDespesa = (Long) properties.get("categoriaDespesa.id");
//            Double valor = (Double) properties.get("valor");
//            Date dataCompra = (Date) properties.get("dataCompra");
//            Time horaCompra = (Time) properties.get("horaCompra");
//            Double valorRealAutorizado = (Double) properties.get("valorRealAutorizado");
//
//            if (idViagem == null) {
//                errors.put("viagem", "Campo obrigatório!");
//            }
//            if (idCategoriaDespesa == null) {
//                errors.put("categoriaDespesa", "Campo obrigatório!");
//            }
//            if (valor == null || valor < 0) {
//                errors.put("valor", "Campo Obrigatório!");
//            }
//            if (dataCompra == null) {
//                errors.put("dataCompra", "Campo obrigatório!");
//            }
//            if (horaCompra == null) {
//                errors.put("horaCompra", "Campo obrigatório!");
//            }
//            if (valorRealAutorizado == null || valorRealAutorizado < 0) {
//                errors.put("valorRealAutorizado", "Campo obrigatório!");
//            }
//        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

    @Override
    public Despesa readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Despesa despesa = null;
        try {
            DespesaDAO dao = new DespesaDAO();
            despesa = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return despesa;
    }

    @Override
    public List<Despesa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Despesa> lista = null;
        try {
            DespesaDAO dao = new DespesaDAO();
            lista = dao.readByCriteria(criteria, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return lista;
    }

    @Override
    public void update(Despesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DespesaDAO dao = new DespesaDAO();
            dao.update(pojo, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }

    }

    @Override
    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DespesaDAO dao = new DespesaDAO();
            dao.delete(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }

    }

}
