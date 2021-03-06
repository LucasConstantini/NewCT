package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.CategoriaDespesa;
import cleartrip.model.pojo.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoriaDespesaDAO implements BaseDAO<CategoriaDespesa> {

    public static final String CRITERION_NOME = "1";
    public static final String CRITERION_VALOR_LIMITE_INICIO = "2";
    public static final String CRITERION_VALOR_LIMITE_FIM = "3";
    public static final String CRITERION_EMPRESA = "4";
    

    @Override
    public void create(CategoriaDespesa e, Connection conn) throws Exception {
        String sql = "INSERT INTO categoria_despesa(nome, valorlimite, empresa_fk) VALUES(?,?,?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        //campo obrigatório
        ps.setString(++i, e.getNome());
        //campo não obrigatórios
        if (e.getValorLimite() != 0) {
            ps.setDouble(++i, e.getValorLimite());
        } else {
            ps.setNull(++i, Types.DOUBLE);
        }
        ps.setLong(++i, e.getEmpresa().getId());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();

    }

    @Override
    public CategoriaDespesa readById(Long id, Connection conn) throws Exception {
        CategoriaDespesa categoriaDespesa = null;
        String sql = "SELECT categoria_despesa.*, empresa.id as empresa_id, empresa.nome as empresa_nome from categoria_despesa left join empresa on categoria_despesa.empresa_fk = empresa.id WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            //setando categoria de despesa
            categoriaDespesa = new CategoriaDespesa();
            categoriaDespesa.setId(rs.getLong("id"));
            categoriaDespesa.setNome(rs.getString("nome"));
            categoriaDespesa.setValorLimite(rs.getDouble("valorlimite"));
            
            //empresa
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("empresa_id"));
            empresa.setNome(rs.getString("empresa_nome"));
            categoriaDespesa.setEmpresa(empresa);

        }
        rs.close();
        ps.close();
        return categoriaDespesa;
    }

    @Override
    public List<CategoriaDespesa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<CategoriaDespesa> lista = new ArrayList<CategoriaDespesa>();
        String sql = "SELECT categoria_despesa.*, empresa.id as empresa_id, empresa.nome as empresa_nome from categoria_despesa left join empresa on categoria_despesa.empresa_fk = empresa.id WHERE 1=1";

        //criterio por nome
        String criterionNome = (String) criteria.get(CRITERION_NOME);
        if (criterionNome != null && !criterionNome.trim().isEmpty()) {
            sql += " AND categoria_despesa.nome ILIKE '%" + criterionNome + "%'";
        }
        
        //criterio por nome
        Long criterionEmpresa = (Long) criteria.get(CRITERION_EMPRESA);
        if (criterionEmpresa != null) {
            sql += " AND empresa.id = " + criterionEmpresa;
        }

        //criterio por intervalo de valores
        Double criterionValorLimite1 = (Double) criteria.get(CRITERION_VALOR_LIMITE_INICIO);
        Double criterionValorLimite2 = (Double) criteria.get(CRITERION_VALOR_LIMITE_FIM);
        if (criterionValorLimite2 != null && !(criterionValorLimite2 < 0)) {
            sql += " AND categoria_despesa.valorlimite between " + criterionValorLimite1 + " and " + criterionValorLimite2;
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //setando categoria de despesa
            CategoriaDespesa categoriaDespesa = new CategoriaDespesa();
            categoriaDespesa.setId(rs.getLong("id"));
            categoriaDespesa.setNome(rs.getString("nome"));
            categoriaDespesa.setValorLimite(rs.getDouble("valorlimite"));

            //empresa
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("empresa_id"));
            empresa.setNome(rs.getString("empresa_nome"));
            categoriaDespesa.setEmpresa(empresa);

            lista.add(categoriaDespesa);
        }
        rs.close();
        ps.close();
        return lista;
    }

    @Override
    public void update(CategoriaDespesa e, Connection conn) throws Exception {
        String sql = "UPDATE categoria_despesa SET nome=?, valorlimite=?, empresa_fk=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;

        //setar os campos obrigatórios
        ps.setString(++i, e.getNome());
        if (e.getValorLimite() != null) {
            ps.setDouble(++i, e.getValorLimite());
        } else {
            ps.setNull(++i, Types.DOUBLE);
        }
        ps.setLong(++i, e.getEmpresa().getId());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();

    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM categoria_despesa WHERE id =" + id);
        st.close();
    }
}
