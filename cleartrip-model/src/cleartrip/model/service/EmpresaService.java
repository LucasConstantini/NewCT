package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.ServiceLocator;
import cleartrip.model.base.service.BaseEmpresaService;
import cleartrip.model.dao.EmpresaDAO;
import cleartrip.model.pojo.Empresa;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpresaService implements BaseEmpresaService {

    @Override
    public void create(Empresa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            EmpresaDAO dao = new EmpresaDAO();
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
    public Empresa readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Empresa empresa = null;
        try {
            EmpresaDAO dao = new EmpresaDAO();
            empresa = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return empresa;
    }

    @Override
    public List<Empresa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Empresa> lista = null;
        try {
            EmpresaDAO dao = new EmpresaDAO();
            lista = dao.readByCriteria(criteria, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return lista;
    }

    @Override
    public void update(Empresa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            EmpresaDAO dao = new EmpresaDAO();
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
    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            EmpresaDAO dao = new EmpresaDAO();
            dao.delete(id, conn);
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
            Long id = (Long) properties.get("id");
            String nome = (String) properties.get("nome");
            String nomeFantasia = (String) properties.get("nomeFantasia");
            String endereco = (String) properties.get("endereco");
            String telefone = (String) properties.get("telefone");
            String nomeRepresentante = (String) properties.get("nomeRepresentante");
            long cpfRepresentante = (Long) properties.get("cpfRepresentante");
            long cnpj = (Long) properties.get("cnpj");
            
            if (nome == null || nome.isEmpty()) {
                errors.put("nome", "Informe um nome!");
            }
            
            if (nomeFantasia == null || nomeFantasia.isEmpty()) {
                errors.put("nomeFantasia", "Informe um nome fantasia da empresa!");
            }
            
            if (endereco == null || endereco.isEmpty()) {
                errors.put("endereco", "Informe o endereço!");
            }
            
            if (telefone == null || telefone.isEmpty()) {
                errors.put("telefone", "Informe o telefone da empresa!");
            }
            
            if (nomeRepresentante == null || nomeRepresentante.isEmpty()) {
                errors.put("nomeRepresentante", "Informe um representante!");
            }
            
            if (cpfRepresentante < 0) {
                errors.put("cpfRepresentante", "Informe o CPF do representante!");
            }
            Map<String, Object> criteria = new HashMap<>();
            criteria.put(EmpresaDAO.CRITERION_CPF_REPRESENTANTE, properties.get("cpfRepresentante"));
            List<Empresa> empresas = ServiceLocator.getEmpresaService().readByCriteria(criteria);
            if (!empresas.isEmpty()) {
                errors.put("cpfRepresentante", "Este CPF já representa Outra Empresa!");
            }
            if (cnpj < 0) {
                errors.put("cnpj", "Informe o CNPJ da empresa!");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
}
