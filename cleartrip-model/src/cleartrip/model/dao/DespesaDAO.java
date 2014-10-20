package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.Administrador;
import cleartrip.model.pojo.Despesa;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Financeiro;
import cleartrip.model.pojo.Solicitante;
import cleartrip.model.pojo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DespesaDAO implements BaseDAO<Despesa> {

    public static final String TIPO_SOLICITANTE = "Solicitante";
    public static final String TIPO_FINANCEIRO = "Financeiro";
    public static final String TIPO_ADMINISTRADOR = "Administrador";

    public static final String CRITERION_TIPO_EQ = "1";
    public static final String CRITERION_NOME_I_LIKE = "2";
    public static final String CRITERION_USUARIO_EQ = "3";
    public static final String CRITERION_SENHA_EQ = "4";

    @Override
    public void create(Despesa e, Connection conn) throws Exception {
        String sql = "INSERT INTO despesa(comprovante, valor, nomeestabelecimento, datacompra, horacompra, cnpj, descritivo, valorrealautorizado, viagem_fk, categoria_despesa_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        

        ps.execute();
        ps.close();

    }

    @Override
    public Despesa readById(Long id, Connection conn) throws Exception {
        Despesa e = new Despesa();
        return e;
    }

    @Override
    public List<Despesa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Despesa> lista = new ArrayList<Despesa>();
        String sql = "SELECT usuario.id, usuario.tipo,usuario.login,usuario.senha,usuario.nome,usuario.cpf,usuario.rg,usuario.emailcorporativo,usuario.emailpessoal,usuario.telefonecorporativo,usuario.telefonepessoal, empresa.id as empresa_id, empresa.nome as empresa_nome FROM empresa right join usuario on usuario.empresa_fk = empresa.id WHERE 1=1";

        String criterionTipoEq = (String) criteria.get(CRITERION_TIPO_EQ);
        if (criterionTipoEq != null && !criterionTipoEq.trim().isEmpty()) {
            sql += " AND usuario.tipo = '" + criterionTipoEq + "'";
        }

        String criterionUsuarioEq = (String) criteria.get(CRITERION_USUARIO_EQ);
        if (criterionUsuarioEq != null) {
            sql += " AND usuario.login = '" + criterionUsuarioEq + "'";
        }

        String criterionSenhaEq = (String) criteria.get(CRITERION_SENHA_EQ);
        if (criterionSenhaEq != null) {
            sql += " AND usuario.senha = '" + criterionSenhaEq + "'";
        }

        //Pesquisa por nome do usuário
        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND lower(usuario.nome) ilike '%" + criterionNomeILike + "%'";
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Despesa e = new Despesa();
           
            lista.add(e);
        }
        rs.close();
        s.close();

        return lista;
    }

    @Override
    public void update(Despesa e, Connection conn) throws Exception {
        String sql = "UPDATE despesa SET comprovante=?, valor=?,nomeestabelecimento=?, datacompra=?, horacompra=?, cnpj=?, descritivo=?, valorrealautorizado=?, viagem_fk=?, categoria_despesa_fk=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
       
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM despesa WHERE id = " + id + ";");
        st.close();
    }
}
