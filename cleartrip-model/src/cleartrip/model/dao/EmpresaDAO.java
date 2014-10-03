package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmpresaDAO implements BaseDAO<Empresa> {

    public static final String CRITERION_NOME_I_LIKE = "1";
    public static final String CRITERION_CPF_REPRESENTANTE = "2";

    @Override
    public void create(Empresa e, Connection conn) throws Exception {
        String slq = "INSERT INTO empresa(nome, nomefantasia, endereco, telefone, nomerepresentante, cpfrepresentante, cnpj) VALUES(?,?,?,?,?,?,?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(slq);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getNomeFantasia());
        ps.setString(++i, e.getEndereco());
        ps.setString(++i, e.getTelefone());
        ps.setString(++i, e.getNomeRepresentante());
        ps.setLong(++i, e.getCpfRepresentante());
        ps.setLong(++i, e.getCnpj());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Empresa readById(Long id, Connection conn) throws Exception {
        Empresa empresa = null;
        String sql = "SELECT * FROM empresa WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            empresa = new Empresa();
            empresa.setId(rs.getLong("id"));
            empresa.setNome(rs.getString("nome"));
            empresa.setNomeFantasia(rs.getString("nomefantasia"));
            empresa.setNomeRepresentante(rs.getString("nomerepresentante"));
            empresa.setEndereco(rs.getString("endereco"));
            empresa.setTelefone(rs.getString("telefone"));
            empresa.setCpfRepresentante(rs.getLong("cpfrepresentante"));
            empresa.setCnpj(rs.getLong("cnpj"));
        }
        rs.close();
        ps.close();
        return empresa;
    }

    @Override
    public List<Empresa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Empresa> lista = new ArrayList<Empresa>();
        String sql = "SELECT * FROM empresa WHERE 1=1";

        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND nome ILIKE '%" + criterionNomeILike + "%'";
        }
        
        Long criterionCpfRepresentante = (Long) criteria.get(CRITERION_CPF_REPRESENTANTE);
        if (criterionCpfRepresentante != null) {
            sql += " AND cpfrepresentante = '" + criterionCpfRepresentante + "'";
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Empresa e = new Empresa();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));
            e.setNomeFantasia(rs.getString("nomefantasia"));
            e.setNomeRepresentante(rs.getString("nomerepresentante"));
            e.setEndereco(rs.getString("endereco"));
            e.setTelefone(rs.getString("telefone"));
            e.setCpfRepresentante(rs.getLong("cpfrepresentante"));
            e.setCnpj(rs.getLong("cnpj"));
            lista.add(e);
        }
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(Empresa e, Connection conn) throws Exception {
        String sql = "UPDATE empresa SET nome=?, nomefantasia=?, endereco=?, telefone=?, nomerepresentante=?, cpfrepresentante=?, cnpj=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getNomeFantasia());
        ps.setString(++i, e.getNomeRepresentante());
        ps.setString(++i, e.getEndereco());
        ps.setString(++i, e.getTelefone());
        ps.setLong(++i, e.getCpfRepresentante());
        ps.setLong(++i, e.getCnpj());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM empresa WHERE id=" + id);
        st.close();
    }
}
