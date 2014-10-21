package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseViagemService;
import cleartrip.model.dao.ViagemDAO;
import cleartrip.model.pojo.Viagem;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViagemService implements BaseViagemService {

    @Override
    public void create(Viagem pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ViagemDAO dao = new ViagemDAO();//DAO -Data Access Object
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
//        
//        boolean ok = true;
//        if (properties != null) {
//            Long idTransporte = (Long) properties.get("meioTransporte.id");
//            Long idUsuario = (Long) properties.get("usuario.id");
//            String status = (String) properties.get("status");
//            String destino = (String) properties.get("destino");
//            String enderecoDestivo = (String) properties.get("enderecoDestino");
//            String telefoneDestino = (String) properties.get("telefoneDestino");
//            String cidadePartida = (String) properties.get("cidadePartida");
//            String enderecoPartida = (String) properties.get("enderecoPartida");
//            String telefonePartida = (String) properties.get("telefonePartida");
//            String dataPartida = (String) properties.get("dataPartida");
//            String horaPartida = (String) properties.get("horaPartida");
//            String dataVolta = (String) properties.get("dataVolta");
//            String horaVolta = (String) properties.get("horaVolta");
//
//            if (idTransporte == null || idTransporte < 0) {
//                errors.put("transporte", "Campo obrigatório!");
//                ok = false;
//            }
//            if (idUsuario == null || idUsuario < 0) {
//                errors.put("usuario", "Campo obrigatório!");
//                ok = false;
//            }
//            if (status == null || status.isEmpty()) {
//                errors.put("status", "Campo obrigatório!");
//                ok = false;
//            }
//            if (destino == null || destino.isEmpty()) {
//                errors.put("destino", "Campo Obrigatório, digite o nome da empresa!");
//                ok = false;
//            }
//            if (enderecoDestivo == null || enderecoDestivo.isEmpty()) {
//                errors.put("enderecoDestino", "Campo obrigatório!");
//                ok = false;
//            }
//            if (telefoneDestino == null || telefoneDestino.isEmpty()) {
//                errors.put("telefoneDestino", "Campo obrigatório!");
//                ok = false;
//            }
//            if (cidadePartida == null || cidadePartida.isEmpty()) {
//                errors.put("cidadePartida", "Campo obrigatório!");
//                ok = false;
//            }
//            if (enderecoPartida == null || enderecoPartida.isEmpty()) {
//                errors.put("enderecoPartida", "Campo obrigatório!");
//                ok = false;
//            }
//            if (telefonePartida == null || telefonePartida.isEmpty()) {
//                errors.put("telefonePartida", "Campo obrigatório!");
//                ok = false;
//            }
//
//            if (horaPartida == null || horaPartida.isEmpty()) {
//                errors.put("horaPartida", "Entre com a hora da partida!");
//                ok = false;
//            }
//            if (horaVolta == null || horaVolta.isEmpty()) {
//                errors.put("horaVolta", "Entre com a hora de volta!");
//                ok = false;
//            }
//
//            if (dataPartida == null || dataPartida.isEmpty()) {
//                errors.put("dataPartida", "Digite a data da partida!");
//                ok = false;
//            }
//
//            if (dataVolta == null || dataVolta.isEmpty()) {
//                errors.put("dataVolta", "Digite a data da volta!");
//                ok = false;
//            }
//
//            if (ok) {
//                Map<String, Object> criteria = new HashMap<String, Object>();
//                criteria.put(ViagemDAO.CRITERION_DATA_PARTIDA_INICIO_EQ, dataPartida);
//                criteria.put(ViagemDAO.CRITERION_DATA_PARTIDA_FIM_EQ, dataVolta);
//                criteria.put(ViagemDAO.CRITERION_USUARIO_EQ, idUsuario);
//                criteria.put(ViagemDAO.CRITERION_STATUS_EQ, status);
//                List<Viagem> viagens = readByCriteria(criteria);
//                if (!viagens.isEmpty()) {
//                    errors.put("invalido", "Esta viagem não pode ser marcada, pois já tem uma viagem marcada na mesma data para este usuário.");
//                }
//            }
//
//        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

    @Override
    public Viagem readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Viagem viagem = null;
        try {
            ViagemDAO dao = new ViagemDAO();
            viagem = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return viagem;
    }

    @Override
    public List<Viagem> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Viagem> lista = null;
        try {
            ViagemDAO dao = new ViagemDAO();
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
    public void update(Viagem pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ViagemDAO dao = new ViagemDAO();
            dao.update(pojo, conn);
            conn.commit();
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
            ViagemDAO dao = new ViagemDAO();
            dao.delete(login, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }

    }
}
