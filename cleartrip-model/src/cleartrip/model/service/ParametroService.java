package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseParametroService;
import cleartrip.model.dao.ParametroDAO;
import cleartrip.model.pojo.Parametro;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParametroService implements BaseParametroService {

    @Override
    public void create(Parametro pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ParametroDAO dao = new ParametroDAO();
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
    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
        Map<String, String> errors = new HashMap<String, String>();
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

    @Override
    public Parametro readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Parametro parametro = null;
        try {
            ParametroDAO dao = new ParametroDAO();
            parametro = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return parametro;
    }

    @Override
    public List<Parametro> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Parametro> lista = null;
        try {
            ParametroDAO dao = new ParametroDAO();
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
    public void update(Parametro pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ParametroDAO dao = new ParametroDAO();
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
            ParametroDAO dao = new ParametroDAO();
            dao.delete(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }

    }
}
